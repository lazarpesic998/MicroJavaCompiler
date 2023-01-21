package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	Obj topScope = null;
	Obj currentMethod = null;
	Obj optionalDesignator = null;

	String currentDesignatorName;
	String currentFunctionName;

	private final List<Obj> designatorMagicList = new ArrayList<Obj>();;
	List<Struct> actParsList = new ArrayList<>();

	int loopCnt = 0;
	int formParsCnt = 0;
	boolean errorDetected = false;
	int printCallCount = 0;
	boolean returnFound = false;
	int nVars;
	int varCnt = 0;

	//pomaze mi da nadjem koji je tip trenutno, valjda nece da napravi problem
	Struct currentType = null;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}

	//OBRADA GLAVNOG PROGRAMA

	public void visit(ProgName progName) {
		progName.obj = TabS.insert(Obj.Prog, progName.getProgName(), TabS.noType);
		TabS.openScope();
	}
	
	public void visit(Program program) {
		
		// U programu mora postojati metoda sa imenom main.
		Obj searchMain = TabS.find("main");
		if ( searchMain == TabS.noObj){
			report_error("SEMANTICKA GRESKA: U programu mora postojati metoda sa imenom main", program);
		}else{
			// Ona mora biti deklarisana kao void metoda bez argumenata
			if(searchMain.getKind() != Obj.Meth || searchMain.getType() != TabS.noType ||
				searchMain.getLevel() !=0){
				report_error("SEMANTICKA GRESKA: MAIN metoda mora biti deklarisana kao void metoda bez argumenata", program);
			}
		}

		TabS.chainLocalSymbols(program.getProgName().obj);
		TabS.closeScope();
		report_info("Obradjen glavni program " + program.getProgName().getProgName(), program);
	}


	//GLOBALNE PROMENLJIVE
	
	public void visit(Var varName) {

		//ako je promenljiva vec deklarisana
		Obj searchedVar = TabS.find(varName.getVarName());
		if(searchedVar == TabS.noObj){
			TabS.insert(Obj.Var, varName.getVarName(), currentType);
			//log info
			varCnt++;
			report_info("Deklarisana promenljiva " + varName.getVarName() + " tipa " + currentType.getKind(), varName);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija simbola", varName);
		}
	}
	
	public void visit(ArrayVar varName) {

		Struct currentArrayType = TabS.findArrayType(currentType);

		//exception handling
		if(currentType == null) {
			report_error("Desila se SEMANTICKA GRESKA: currentType = null !", varName);
			return;
		}

		Obj searchedVar = TabS.find(varName.getVarName());
		if(searchedVar == TabS.noObj){
			TabS.insert(Obj.Var, varName.getVarName(), currentArrayType);
			//log info
			varCnt++;
			report_info("Deklarisana NIZOVNA promenljiva " + varName.getVarName() + " tipa " + currentType.getKind(), varName);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija simbola", varName);
		}

	}
	
	public void visit(Type typeName) {
		Obj typeNode = TabS.find(typeName.getTypeName());
		if(typeNode == TabS.noObj){
			report_error("SEMANTICKA GRESKA: Nije pronadjen tip " + typeName.getTypeName() + " u tabeli simbola! ", null);
			typeName.struct = TabS.noType;
		}else{
			if(Obj.Type == typeNode.getKind()){
				typeName.struct = typeNode.getType();
			}else{
				report_error("SEMANTICKA GRESKA: Ime " + typeName.getTypeName() + " ne predstavlja tip!", typeName);
				typeName.struct = TabS.noType;
			}
   	}
   	currentType = typeName.struct;
	}


	//METHODS

	public void visit(MethodReturnType methodReturnType){
		if (TabS.find(methodReturnType.getMethodName()) == TabS.noObj){
			currentMethod = TabS.insert(Obj.Meth, methodReturnType.getMethodName() , currentType);
			methodReturnType.obj = currentMethod;
			TabS.openScope();
			report_info("Deklaracija METODE : " + methodReturnType.getMethodName() + "() sa povratinim tipom: " + currentType.getKind(), methodReturnType);
		}else{
			report_error("SEMANTICKA GRESKA: methoda " + methodReturnType.getMethodName() + "() je vec deklarisana", methodReturnType);
		}
		
	}

	public void visit(MethodReturnVoid methodReturnVoid) {
		currentType = TabS.noType;
		if (TabS.find(methodReturnVoid.getMethodName()) == TabS.noObj){
			currentMethod = TabS.insert(Obj.Meth, methodReturnVoid.getMethodName() , currentType);
			methodReturnVoid.obj = currentMethod;
			TabS.openScope();
			report_info("Deklaracija METODE : " + methodReturnVoid.getMethodName() + "() sa povratinim tipom: " + currentType.getKind(), methodReturnVoid);
		}else{
			report_error("SEMANTICKA GRESKA: methoda " + methodReturnVoid.getMethodName() + "() je vec deklarisana", methodReturnVoid);
		}
	}

	public void visit(MethodDecl methodDecl){
		if(!returnFound && currentMethod.getType() != TabS.noType){
			report_error("SEMANTICKA GRESKA: methoda " + currentMethod.getName() + "() nema RETURN iskaz", methodDecl);
		}
		currentMethod.setLevel(formParsCnt);
		TabS.chainLocalSymbols(currentMethod);
		TabS.closeScope();

		returnFound = false;
		formParsCnt = 0;
		currentMethod = null;
	}

	public void visit(FormVar formVar){
		Obj searchedVar = null;
		if(TabS.currentScope.getLocals() != null){
			searchedVar = TabS.currentScope.getLocals().searchKey(formVar.getFormVarName());
		}
		if(searchedVar == null){
			Obj obj = TabS.insert(Obj.Var, formVar.getFormVarName(), currentType);
			formParsCnt++;
			obj.setFpPos(formParsCnt);
			report_info("Deklarisan FormVar " + formVar.getFormVarName() + " tipa " + currentType.getKind(), formVar);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija FormVar", formVar);
		}
		
	}
	public void visit(FormVarArray formVar){
		Obj searchedVar = TabS.currentScope.getLocals().searchKey(formVar.getFormVarName());
		if(searchedVar == null){
			Obj obj = TabS.insert(Obj.Var, formVar.getFormVarName(), TabS.findArrayType(currentType));
			formParsCnt++;
			obj.setFpPos(formParsCnt);
			report_info("Deklarisan FormVar " + formVar.getFormVarName() + " tipa " + currentType.getKind(), formVar);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija FormVar", formVar);
		}
	}

	//ActPars
	public void visit(ActParam actParam){
		actParsList.add(actParam.getExpr().struct);
	}

	public void visit(ActParams actParam){
		actParsList.add(actParam.getExpr().struct);
	}

	public void visit(DesignatorFactor designatorFactor){
		designatorFactor.struct = designatorFactor.getDesignator().obj.getType();
	}
	public void visit(FactorFunctionCall factorFunctionCall){
		factorFunctionCall.struct = factorFunctionCall.getFunctionCall().struct;
	}
	public void visit(NumConstFactor numConstFactor){
		numConstFactor.struct = TabS.intType;
	}
	public void visit(CharConstFactor charConstFactor){
		charConstFactor.struct = TabS.charType;
	}
	public void visit(BoolConstFactor boolConstFactor){
		boolConstFactor.struct = TabS.boolType;
	}
	//for classes
	public void visit(NewFactor newFactor){
		report_error("Desila se SEMANTICKA GRESKA: pravljenje klasa  nije podrzano", newFactor);
	}
	public void visit(NewFactorArray newFactorArray){
		if(newFactorArray.getExpr().struct != TabS.intType){
			report_error("Desila se SEMANTICKA GRESKA: Tip neterminala Expr mora biti int.", newFactorArray);
		}
		newFactorArray.struct = TabS.findArrayType(currentType);
	}
	public void visit(ExprFactor exprFactor){
		exprFactor.struct = exprFactor.getExpr().struct;
	}
	
	public void visit(TermFactor termFactor){
		termFactor.struct = termFactor.getFactor().struct;
	}
	
	public void visit(TermFactorList termFactorList){
		Struct termStruct = termFactorList.getTerm().struct;
		Struct factorStruct = termFactorList.getFactor().struct;
		//Term i Factor moraju biti tipa int.
		if(termStruct.equals(factorStruct) && termStruct == TabS.intType){
			termFactorList.struct = termStruct;
		}else{
			report_error("Desila se SEMANTICKA GRESKA: mnozenje ovih tipova nije dozvoljeno", termFactorList);
			termFactorList.struct = TabS.noType;
		}

	}

	public void visit(ExprOption expr){
		expr.struct = expr.getExpr().struct;
	}

	public void visit(MinusExpr expr){
		expr.struct = expr.getTerm().struct;
		// Term mora biti tipa int.
		if(expr.getTerm().struct != TabS.intType){
			report_error("Desila se SEMANTICKA GRESKA: MinusExpr: Term mora biti tipa int.", expr);
		}
	}

	public void visit(PlusExpr expr){
		expr.struct = expr.getTerm().struct;
	}

	public void visit(ExprAddopList exprAddopList){
		Struct termStruct = exprAddopList.getTerm().struct;
		Struct exprStruct = exprAddopList.getExpr().struct;
		// Expr i Term moraju biti tipa int. U svakom slučaju, tipovi za Expr i Term moraju biti komatibilni
		if(termStruct.equals(exprStruct) && termStruct==TabS.intType){
			exprAddopList.struct = termStruct;
		}else{
			report_error("Desila se SEMANTICKA GRESKA: sabiranje ovih tipova nije dozvoljeno", exprAddopList);
			exprAddopList.struct = TabS.noType;
		}
	}


	public void visit(ReturnStatement returnStatement){
		//Ne sme postojati izvan tela (statiÄ�kih) metoda, odnosno globalnih funkcija
		if(currentMethod == null) {
			report_error("Desila se SEMANTICKA GRESKA: RETURN ne sme postojati izvan tela (statickih) metoda, odnosno globalnih funkcija.", returnStatement);
		}
		//Tip neterminala Expr mora biti ekvivalentan povratnom tipu tekuÄ‡e metode/ globalne funkcije.
		//Ako neterminal Expr nedostaje, tekuÄ‡a metoda mora biti deklarisana kao void. 
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if(!currMethType.compatibleWith(returnStatement.getExprOptional().struct)){
			report_error("Desila se SEMANTICKA GRESKA: NEKOMPATIBILNI tipovi Tip neterminala Expr mora biti ekvivalentan povratnom tipu tekuÄ‡e metode/ globalne funkcije.", returnStatement);
		}
	}

	public void visit(NoExprOption expr){
		// Ako neterminal Expr nedostaje, tekuÄ‡a metoda mora biti deklarisana kao void. 
		expr.struct = TabS.noType;
	}

	//POZIVI FUNKCIJA
	public void visit(FunctionCall functionCall){
		//Designator mora označavati globalnu funkciju glavnog programa. 
		Obj func = functionCall.getDesignator().obj;
		if(Obj.Meth == func.getKind()){
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + functionCall.getLine(), null);
			functionCall.struct = func.getType();
		}else{
			report_error("Desila se SEMANTICKA GRESKA: ime nije funkcija", functionCall);
			functionCall.struct = TabS.noType;
		}

		List<Obj> formParsList = new ArrayList<>(func.getLocalSymbols());
		//Broj formalnih i stvarnih argumenata metode ili konstruktora mora biti isti
		if(func.getLevel() != actParsList.size()){
			report_error("Desila se SEMANTICKA GRESKA: Broj formalnih i stvarnih argumenata metode ili konstruktora mora biti isti", functionCall);
		}

		// Tip svakog stvarnog argumenta mora biti kompatibilan pri dodeli sa tipom svakog formalnog argumenta na odgovarajućoj poziciji.
		for(int i=0; i<func.getLevel(); i++){
			if(!formParsList.get(i).getType().equals(actParsList.get(i))){
				report_error("Desila se SEMANTICKA GRESKA:  Tip svakog stvarnog argumenta mora biti kompatibilan pri dodeli sa tipom svakog formalnog argumenta na odgovarajućoj poziciji", functionCall);
			}
		} 





		actParsList.clear();

	}

	public void visit(DesignatorIdent designatorIdent){
		Obj obj = TabS.find(designatorIdent.getDesignatorName());
		if(obj == TabS.noObj){
			report_error("Desila se SEMANTICKA GRESKA: designator nije deklarisan", designatorIdent);
		}else{
			designatorIdent.obj = obj;
			report_info("Nadjen designator: " + designatorIdent.getDesignatorName(), designatorIdent);
		}
	}

	public void visit(DesignatorClassAndField designatorIdent){
		report_error("Desila se SEMANTICKA GRESKA: DesignatorClassAndField nije jos implementirano", designatorIdent);
	}

	public void visit(DesignatorArray designatorIdent){
		//Tip neterminala Designator mora biti niz. 
		designatorIdent.obj = designatorIdent.getDesignator().obj;
		if(designatorIdent.obj.getType().getKind() != Struct.Array){
			report_error("Desila se SEMANTICKA GRESKA: indeksiranje NON_Array tipa", designatorIdent);
		}
		//promena Kind da ne bude tipa Array, nego pristupljenom elementu niza
		designatorIdent.obj = new Obj(Obj.Elem, designatorIdent.getDesignator().obj.getName(), designatorIdent.obj.getType().getElemType());

		//Tip neterminala Expr mora biti int. 
		if(!designatorIdent.getExpr().struct.equals(TabS.intType)){
			report_error("Desila se SEMANTICKA GRESKA: DesignatorArray: Tip neterminala Expr mora biti int", designatorIdent);
		}
	}

	


	//SIMBOLICKE KONSTANTE
	public void visit(NumConst constant){
		//ako je promenljiva vec deklarisana
		Obj searchedConst = TabS.find(constant.getConstName());
		if(searchedConst == TabS.noObj){
			//kombatiblinost tipova
			if(currentType != TabS.intType){
				report_error("Desila se SEMANTICKA GRESKA: Tip terminala numConst mora biti ekvivalentan tipu Type.", constant);
			}

			//save
			Obj currentConst = TabS.insert(Obj.Con, constant.getConstName(), currentType);
			currentConst.setAdr(constant.getConstVal());
			report_info("Deklarisana BROJEVNA KONSTANTA " + constant.getConstName() + " tipa " + currentType.getKind() + " vrednosti: " + constant.getConstVal(), constant);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija simbola", constant);
		}
	}

	public void visit(BoolConst constant){
		//ako je promenljiva vec deklarisana
		Obj searchedConst = TabS.find(constant.getConstName());
		if(searchedConst == TabS.noObj){
			//kombatiblinost tipova
			if(currentType != TabS.boolType){
				report_error("Desila se SEMANTICKA GRESKA: Tip terminala boolConst mora biti ekvivalentan tipu Type.", constant);
			}

			//save
			int boolVal = 0;
			if(constant.getConstVal()) boolVal = 1;
			Obj currentConst = TabS.insert(Obj.Con, constant.getConstName(), currentType);
			currentConst.setAdr(boolVal);

			//log info
			report_info("Deklarisana BOOL KONSTANTA " + constant.getConstName() + " tipa " + currentType.getKind() + " vrednosti: " + constant.getConstVal() + ": " + boolVal, constant);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija simbola", constant);
		}
	}

	public void visit(CharConst constant){
		//ako je promenljiva vec deklarisana
		Obj searchedConst = TabS.find(constant.getConstName());
		if(searchedConst == TabS.noObj){
			//kombatiblinost tipova
			if(currentType != TabS.intType){
				report_error("Desila se SEMANTICKA GRESKA: Tip terminala charConst mora biti ekvivalentan tipu Type.", constant);
			}

			//save
			Obj currentConst = TabS.insert(Obj.Con, constant.getConstName(), currentType);
			currentConst.setAdr(constant.getConstVal());
			report_info("Deklarisana CHAR KONSTANTA " + constant.getConstName() + " tipa " + currentType.getKind() + " vrednosti: " + constant.getConstVal(), constant);
		}else{
			report_error("Desila se SEMANTICKA GRESKA: DVOSTRUKA definicija simbola", constant);
		}
	}

	public void visit(AssignopExpresion assignopExpr){
		assignopExpr.struct = assignopExpr.getExpr().struct;
	}

	public void visit(DesignatorStatementAssign designatorStatementAssign){
		//Designator mora oznaÄ�avati promenljivu, element niza ili polje unutar objekta
		//note: polje unutar objekta jos nije podrzano, klase nisu podrzane
		Obj obj = designatorStatementAssign.getDesignator().obj;
		if(! (obj.getKind() == Obj.Var || obj.getKind() == Obj.Elem)){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati promenljivu, element niza ili polje unutar objekta.", designatorStatementAssign);
		}

		//Tip neterminala Expr mora biti kompatibilan pri dodeli sa tipom neterminala Designator.
		if(designatorStatementAssign.getDesignator().obj.getType() != designatorStatementAssign.getAssignopExpr().struct){
			report_error("Desila se SEMANTICKA GRESKA: Tip neterminala Expr mora biti kompatibilan pri dodeli sa tipom neterminala Designator.", designatorStatementAssign);
		}
	}

	public void visit(DesignatorStatementInc designator){
		//Designator mora oznaÄ�avati promenljivu, element niza ili polje unutar objekta
		//note: polje unutar objekta jos nije podrzano, klase nisu podrzane
		Obj obj = designator.getDesignator().obj;
		if(! (obj.getKind() == Obj.Var || obj.getKind() == Obj.Elem)){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati promenljivu, element niza ili polje unutar objekta.", designator);
		}

		//Designator mora biti tipa int
		if(designator.getDesignator().obj.getType() != TabS.intType){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora biti tipa int.", designator);
		}
	}

	public void visit(DesignatorDec designator){
		//Designator mora oznaÄ�avati promenljivu, element niza ili polje unutar objekta
		//note: polje unutar objekta jos nije podrzano, klase nisu podrzane
		Obj obj = designator.getDesignator().obj;
		if(! (obj.getKind() == Obj.Var || obj.getKind() == Obj.Elem)){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati promenljivu, element niza ili polje unutar objekta.", designator);
		}

		//Designator mora biti tipa int
		if(designator.getDesignator().obj.getType() != TabS.intType){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora biti tipa int.", designator);
		}
	}

	public void visit(DesignatorFunctionCall designator){
		//Designator mora oznaÄ�avati nestatiÄ�ku metodu unutraÅ¡nje klase ili globalnu funkciju glavnog programa.
		if(designator.getFunctionCall().getDesignator().obj.getKind() != Obj.Meth){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznaÄ�avati nestatiÄ�ku metodu unutraÅ¡nje klase ili globalnu funkciju glavnog programa.", designator);
		}
	}

	//Svi Designator neterminali sa leve strane znaka za dodelu vrednsti moraju oznaÄ�avati promenljivu, element niza ili polje unutar objekta.
	public void visit(ParameterListDesignator designator){
		//Designator mora oznaÄ�avati promenljivu, element niza ili polje unutar objekta
		//note: polje unutar objekta jos nije podrzano, klase nisu podrzane
		Obj obj = designator.getDesignator().obj;
		designatorMagicList.add(obj);

		if(! (obj.getKind() == Obj.Var || obj.getKind() == Obj.Elem)){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati promenljivu, element niza ili polje unutar objekta.", designator);
		}
		report_info("Nadjen magic designator " + obj.getName() + " tipa " + currentType.getKind(), designator);
		
	}

	public void visit(ParameterListComma parameterListComma){
		//Designator mora oznaÄ�avati promenljivu, element niza ili polje unutar objekta
		//note: polje unutar objekta jos nije podrzano, klase nisu podrzane
		Obj obj = optionalDesignator;
		designatorMagicList.add(obj);
		if(obj != null){
			if(! (obj.getKind() == Obj.Var || obj.getKind() == Obj.Elem)){
				report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati promenljivu, element niza ili polje unutar objekta.", parameterListComma);
			}
			report_info("Nadjen magic designator " + obj.getName() + " tipa " + currentType.getKind(), parameterListComma);
		}else{
			report_info("Nadjen PRAZAN magic designator", parameterListComma);
		}
	}

	public void visit(DesignatorOption designatorOption){
		optionalDesignator = designatorOption.getDesignator().obj;
	}
	public void visit(NoDesignatorOption designatorOption){
		optionalDesignator = null;
	}
	public void visit(NoParameterList noParameterList){
		designatorMagicList.add(null);
		report_info("Nadjen PRAZAN magic designator", noParameterList);
	}
	
	public void visit(DesignatorMagic magic){
		// Designator sa desne strane znaka za dodelu vrednosti mora predstavljati niz.
		if(magic.getDesignator().obj.getType().getKind() != Struct.Array){
			report_error("Desila se SEMANTICKA GRESKA: Designator sa desne strane znaka za dodelu vrednosti mora predstavljati niz..", magic);
		}
		/*Tip elementa niza predstavljen neterminalom Designator sa desne strane znaka za dodelu 
		vrednosti mora biti kompatibilan pri dodeli sa tipom svih neterminala Designator sa leve strane 
		znaka za dodelu vrednosti.  */
		Struct tipElemenataNiza = magic.getDesignator().obj.getType().getElemType();
		for(int i=0; i<designatorMagicList.size(); i++){
			Obj currElem = designatorMagicList.get(i);
			if(currElem!=null && !currElem.getType().equals(tipElemenataNiza)){
				report_error("Desila se SEMANTICKA GRESKA: Tip elementa niza predstavljen neterminalom Designator sa desne strane znaka za dodelu vrednosti mora biti kompatibilan pri dodeli sa tipom svih neterminala Designator sa leve strane znaka za dodelu vrednosti.", magic);
			}
		}
		/* U sluÄ�aju da je sa leve strane znaka za dodelu vrednosti navedeno viÅ¡e neterminala Designator od 
		duÅ¾ine niza, potrebno tokom izvrÅ¡avanja prijaviti greÅ¡ku (runtime error) */
		// if(designatorMagicList.size() > magic.getDesignator().obj.getType())
		magic.getDesignator();
		report_info("Good MAGIC...  ", magic);
		//clear list
		designatorMagicList.clear();
	}

	public void visit(WhileStart WhileStart){
		loopCnt++;
	}

	public void visit(ForeachStart foreachStart){
		loopCnt++;
	}

	public void visit(Break breakFound){
		//iskaz break se moÅ¾e koristiti samo unutar while ili foreach petlje.
		if(loopCnt <= 0){
			report_error("Desila se SEMANTICKA GRESKA: skaz break se moÅ¾e koristiti samo unutar while ili foreach petlje.", breakFound);
		}
	}

	public void visit(Continue continueFound){
		//iskaz break se moÅ¾e koristiti samo unutar while ili foreach petlje.
		if(loopCnt <= 0){
			report_error("Desila se SEMANTICKA GRESKA: skaz Continue se moÅ¾e koristiti samo unutar while ili foreach petlje.", continueFound);
		}
	}

	public void visit(WhileStatement whileStatement){
		if(loopCnt <= 0) report_error("Desila se SEMANTICKA GRESKA: loopCnt kad se zatvara while ili foreach ne sme biti manji od 0 ", whileStatement);
		loopCnt--;
	}

	public void visit(ForeachStatement foreachStatement){
		//Designator mora oznacavati niz proizvoljnog tipa. 
		if(foreachStatement.getDesignator().obj.getType().getKind() != Struct.Array){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati niz proizvoljnog tipa", foreachStatement);
		}

		// ident mora biti lokalna ili globalna promenljiva istog tipa kao i elementi niza koji opisuje Designator
		Obj identObj = TabS.find(foreachStatement.getForeachIdent().getIdent());
		if(identObj == TabS.noObj){
			report_error("Desila se SEMANTICKA GRESKA: ident u foreach nije deklarisan", foreachStatement);
		}else{
			if(!identObj.getType().equals(foreachStatement.getDesignator().obj.getType().getElemType())){
				report_error("Desila se SEMANTICKA GRESKA: ident mora biti lokalna ili globalna promenljiva istog tipa kao i elementi niza koji opisuje Designator", foreachStatement);
			}
		}

		//Obrada petlje
		if(loopCnt <= 0) report_error("Desila se SEMANTICKA GRESKA: loopCnt kad se zatvara while ili foreach ne sme biti manji od 0 ", foreachStatement);
		loopCnt--;
	}

	public void visit(ReadStatement readStatement){
		//Designator mora oznacavati promenljivu, element niza ili polje unutar objekta
		//note: polje unutar objekta jos nije podrzano, klase nisu podrzane
		Obj obj = readStatement.getDesignator().obj;
		if(! (obj.getKind() == Obj.Var || obj.getKind() == Obj.Elem)){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora oznacavati promenljivu, element niza ili polje unutar objekta.", readStatement);
		}

		//Designator mora biti tipa int, char ili bool
		if(readStatement.getDesignator().obj.getType() != TabS.intType &&
		readStatement.getDesignator().obj.getType() != TabS.boolType &&
		readStatement.getDesignator().obj.getType() != TabS.charType){
			report_error("Desila se SEMANTICKA GRESKA: Designator mora biti tipa int, char ili bool.", readStatement);
		}
	}

	public void visit(PrintStatement printStatement){
		//Expr mora biti tipa int, char ili bool.
		if(	printStatement.getExpr().struct != TabS.intType &&
			printStatement.getExpr().struct != TabS.boolType &&
			printStatement.getExpr().struct != TabS.charType){
			report_error("Desila se SEMANTICKA GRESKA: Expr mora biti tipa int, char ili bool.", printStatement);
		}
	}

	public void visit(CondFactExpr condition){
		//Tip uslovnog izraza Condition mora biti bool.
		if(condition.getExpr().struct != TabS.boolType){
			report_error("Desila se SEMANTICKA GRESKA: Tip uslovnog izraza Condition mora biti bool.", condition);
		}
//		report_info("AAAAAAAAAAAA", condition);
	}
	public void visit(CondFactTwoExpr condition){
		//Tipovi oba izraza moraju biti kompatibilni. 
		if(!condition.getExpr().struct.equals(condition.getExpr1().struct)){
			report_error("Desila se SEMANTICKA GRESKA: CondFactTwoExpr Tipovi oba izraza moraju biti kompatibilni", condition);
		}

		//Uz promenljive tipa klase ili niza, od relacionih operatora, mogu se koristiti samo != i ==. 
		if(condition.getExpr().struct.getKind() == Struct.Array &&
		condition.getExpr1().struct.getKind() == Struct.Array){
			if(condition.getRelop().getClass() != Eq.class &&
				condition.getRelop().getClass() != Neq.class){
					report_error("Desila se SEMANTICKA GRESKA: Uz promenljive tipa niza, od relacionih operatora, mogu se koristiti samo != i ==", condition);
			}
		}
	}

}
