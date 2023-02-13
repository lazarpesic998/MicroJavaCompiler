package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	private Stack<Integer> addopCodeStack = new Stack<>();
	private Stack<Integer> mulopCodeStack = new Stack<>();
	private int currentRelop;

	private int totalNumberOfJumpsInIf = 0;
	private int totalNumberOfAndJumps = 0;

	private Stack<Integer> skipThenStack = new Stack<>();
	private Stack<Integer> skipElseStack = new Stack<>();
	private Stack<Integer> thenStack = new Stack<>();

	//za ugnjezdene pozive, moralokalni stek, kad naidjes naIfStart napravi ih
	private List<Stack<Integer>> skipThenList = new ArrayList<>();
	private List<Stack<Integer>> skipElseList = new ArrayList<>();
	private List<Stack<Integer>> thenList = new ArrayList<>();

	private Stack<Integer> loopStack = new Stack<>();
	private Stack<Integer> skipLoopStack = new Stack<>();

	private Obj currentArrayObj = null;
	private int currentArrayLenght =0;
	private List<Obj> objectsToBeInitialised = new ArrayList<>();

	private Obj currentForeachArray = null;
	private Obj myForeachCnt = SemanticAnalyzer.myForeachCnt;

	public int getMainPc() {
		return mainPc;
	}

	public void visit(PrintStatement printStatement) {
		//TODO: onaj deo ,numConst dodaj
		Struct exprStruct = printStatement.getExpr().struct;
		if (exprStruct == TabS.intType || exprStruct == TabS.boolType) {
			Code.loadConst(5);
			Code.put(Code.print);
		} else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}

	public void visit(ReadStatement readStatement) {
		Struct objType = readStatement.getDesignator().obj.getType();
		if (objType == TabS.intType || objType == TabS.boolType) {
			Code.put(Code.read);
		} else {
			Code.put(Code.bread);
		}
		Code.store(readStatement.getDesignator().obj);
	}

	// Constants
	public void visit(NumConst constVal) {
		Obj obj = new Obj(Obj.Con, constVal.getConstName(), TabS.intType, constVal.getConstVal(), 0);
		Code.load(obj);
	}

	public void visit(BoolConst constVal) {
		int boolVal = constVal.getConstVal().equals(true) ? 1 : 0;
		Obj obj = new Obj(Obj.Con, constVal.getConstName(), TabS.boolType, boolVal, 0);
		Code.load(obj);
	}

	public void visit(CharConst constVal) {
		Obj obj = new Obj(Obj.Con, constVal.getConstName(), TabS.charType, constVal.getConstVal(), 0);
		Code.load(obj);
	}

	public void visit(ConstNumFactor constVal) {
		Code.loadConst(constVal.getNumFactor());
	}

	public void visit(ConstCharFactor constVal) {
		Code.loadConst(constVal.getCharFactor());
	}

	public void visit(ConstBoolFactor constVal) {
		int boolVal = constVal.getBoolFactor().equals(true) ? 1 : 0;
		Code.loadConst(boolVal);
	}

	public void visit(MethodReturnVoid methodTypeName) {
		if ("main".equalsIgnoreCase(methodTypeName.getMethodName())) {
			mainPc = Code.pc;
		}
		handleMethodEnter(methodTypeName);
	}

	public void visit(MethodReturnType methodTypeName) {
		handleMethodEnter(methodTypeName);
	}

	private void handleMethodEnter(MethodTypeName methodTypeName) {
		methodTypeName.obj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(methodTypeName.obj.getLevel());
		Code.put(methodTypeName.obj.getLocalSymbols().size());
	}

	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(DesignatorFactor designator) {
		Code.load(designator.getDesignator().obj);
	}

	public void visit(DesignatorArrayStart designatorArray) {
		Code.load(designatorArray.getDesignator().obj);
	}

	public void visit(DesignatorStatementAssign designatorStatementAssign) {
		Code.store(designatorStatementAssign.getDesignator().obj);
	}

	public void visit(FunctionCall functionCall) {
		Obj functionObj = functionCall.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
	}

	public void visit(DesignatorFunctionCall designatorFunctionCall) {
		if (designatorFunctionCall.getFunctionCall().getDesignator().obj.getType() != TabS.noType) {
			Code.put(Code.pop);
		}
	}

	public void visit(Mul mul) {
		mulopCodeStack.push(Code.mul);
	}

	public void visit(Div div) {
		mulopCodeStack.push(Code.div);
	}

	public void visit(Mod mod) {
		mulopCodeStack.push(Code.rem);
	}

	public void visit(Plus add) {
		addopCodeStack.push(Code.add);
	}

	public void visit(Minus sub) {
		addopCodeStack.push(Code.sub);
	}

	public void visit(MinusExpr minusExpr) {
		Code.put(Code.neg);
	}

	public void visit(ExprAddopList exprAddopList) {
		Code.put(addopCodeStack.pop());
	}

	public void visit(TermFactorList termFactorList) {
		Code.put(mulopCodeStack.pop());
	}

	public void visit(DesignatorStatementInc designatorStatementInc) {
		Obj desigatorObj = designatorStatementInc.getDesignator().obj;
		if (desigatorObj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(desigatorObj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(desigatorObj);
	}

	public void visit(DesignatorDec designatorDec) {
		Obj desigatorObj = designatorDec.getDesignator().obj;
		if (desigatorObj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(desigatorObj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(desigatorObj);
	}

	public void visit(NewFactorArray newFactorArray) {
		Struct type = newFactorArray.getType().struct;
		Code.put(Code.newarray);
		if (type == TabS.charType) {
			Code.put(0);
		} else {
			Code.put(1);
		}

	}

	public void visit(Eq eq) {
		currentRelop = Code.eq;
	}

	public void visit(Neq neq) {
		currentRelop = Code.ne;
	}

	public void visit(Gt gt) {
		currentRelop = Code.gt;
	}

	public void visit(Gte gte) {
		currentRelop = Code.ge;
	}

	public void visit(Lt lt) {
		currentRelop = Code.lt;
	}

	public void visit(Lte le) {
		currentRelop = Code.le;
	}

	//za samo boolExpr, ako nije ispunjen skoci posle then
	public void visit(CondFactExpr condFactExpr) {
		Code.loadConst(1);
		skipThenStack.push(Code.pc + 1);
		Code.putFalseJump(Code.eq, Code.pc);
	}

	//skoci posle then
	public void visit(CondFactTwoExpr condFactTwoExpr) {
		skipThenStack.push(Code.pc + 1);
		Code.putFalseJump(currentRelop, Code.pc);
	}

	public void visit(IfStart ifStart){
		saveOldStacks();
		createNewStacks();
	}

	private void saveOldStacks() {
		if(skipThenList.size() != 0){
			int lastIndex = skipThenList.size()-1;
			skipThenList.set(lastIndex, skipThenStack);
			skipElseList.set(lastIndex, skipElseStack);
			thenList.set(lastIndex, thenStack);
		}
	}

	private void createNewStacks() {
		skipThenStack = new Stack<>();
		skipElseStack = new Stack<>();
		thenStack = new Stack<>();

		skipThenList.add(skipThenStack);
		skipElseList.add(skipElseStack);
		thenList.add(thenStack);
	}

	private void restoreStacks() {
		if(skipThenList.size() > 1){
			int lastIndex = skipThenList.size()-1;
			//skoloni poslednji
			skipThenList.remove(lastIndex);
			skipElseList.remove(lastIndex);
			thenList.remove(lastIndex);
			lastIndex--;
			//stavi da je trenutni prethodni
			skipThenStack = skipThenList.get(lastIndex);
			skipElseStack = skipElseList.get(lastIndex);
			thenStack = thenList.get(lastIndex);

		}
	}

	//popravi zapise koji su posle then (i posle else)
	public void visit(IfStatement ifStatement) {
		resetNumberOfJumpsCounters();
		while (!skipThenStack.isEmpty()) {
			Code.fixup(skipThenStack.pop());
		}

		restoreStacks();
	}

	//kada se zavrsi then deo treba treba preskociti else
	//popravi zapise koji treba da preskoce then, i dodju na else
	public void visit(ElseStart elseStart) {
		skipElseStack.push(Code.pc + 1); // popravljas u ElseStatement-u
		Code.putJump(Code.pc);// jmp to reapir

		while (!skipThenStack.isEmpty()) {
			Code.fixup(skipThenStack.pop());
		}
	}

	//popravi zapise koji su posle then (i posle else)
	public void visit(ElseStatement elseStatement) {
		resetNumberOfJumpsCounters();
		while (!skipElseStack.isEmpty()) {
			Code.fixup(skipElseStack.pop());
		}
		restoreStacks();
	}

	//ovo je mesto gde popravljamo skok - skacemo na then
	//ako je uslov pre toga zadovoljen treba preskociti poslednju proveru i skociti na then
	public void visit(Orop orop) {
		if (!skipThenStack.isEmpty()) {
			int adr = skipThenStack.pop();
			patchInstruction(adr);
			thenStack.push(adr);
		}
		while(!skipThenStack.isEmpty() && totalNumberOfAndJumps > 0) {
			Code.fixup(skipThenStack.pop());
			totalNumberOfAndJumps--;
		}
	}

	//ovo je mesto gde pocenje then, popravi skokove na then
	public void visit(CondIf condIf){
		while(!thenStack.isEmpty()){
			Code.fixup(thenStack.pop());
		}
	}

	private void patchInstruction(int pos){
		int stari=Code.pc;
		Code.pc=pos-1; //u funkciju sam slao Code.pc+1, gde je adresa na koju treba da se skoci
		int oldInstruction = Code.get(pos-1) - Code.jcc;
		Code.put(Code.inverse[oldInstruction]+Code.jcc);
		Code.pc=stari;
	}

	public void visit(Andop andop) {
		totalNumberOfAndJumps++;
	}

	private void resetNumberOfJumpsCounters(){
		totalNumberOfJumpsInIf = 0;
		totalNumberOfAndJumps = 0;
	}

	//DESIGNATOR MAGIC
	public void visit(DesignatorMagic designatorMagic){
		if(objectsToBeInitialised.size() > currentArrayLenght){
			Code.error("RUNTIME ERROR: broj elemenata koje treba inicijalizovati premasuje velicinu niza");
			return;
		}
		//obrnuti for jer su na steku kad je niz u pitanju obrnutim redosledom se cita
		for(int i=objectsToBeInitialised.size()-1; i>=0; i--){
			Obj obj = objectsToBeInitialised.get(i);
			if(obj == null) continue;
			Code.load(currentArrayObj);
			Code.loadConst(i);
			Code.put(Code.aload);
			Code.store(obj);
		}
		objectsToBeInitialised.clear();
	}

	public void visit(DesignatorIdent designatorIdent){
		Obj obj = designatorIdent.obj;
		if(obj.getType().getKind() == Struct.Array){
			currentArrayObj = obj;
			currentArrayLenght = obj.getFpPos();
		}
	}

	public void visit(ParameterListDesignator parameterListDesignator){
		objectsToBeInitialised.add(parameterListDesignator.getDesignator().obj);
	}

	public void visit(DesignatorOption designatorOption){
		objectsToBeInitialised.add(designatorOption.getDesignator().obj);
	}

	public void visit(NoDesignatorOption designatorOption){
		objectsToBeInitialised.add(null);
	}
	public void visit(NoParameterList noParameterList){
		objectsToBeInitialised.add(null);
	}


	//WHILE
	//petlja pocinje kad pocinje i provera njenih uslova
	public void visit(WhileStart whileStart){
		loopStack.push(Code.pc);
	}

	//na ovom mestu znas gde se zavrsava petlja pa popravi skokove iza petlje
	//kad se zavrsi while iteracija vrati se da proveris uslov ponovo
	public void visit(WhileStatement whileStatement){
		if(!loopStack.isEmpty()){
			int adr = loopStack.get(0);
			Code.putJump(adr);
		}
		while(!skipLoopStack.isEmpty()){
			Code.fixup(skipLoopStack.pop());
		}
		loopStack.clear();
	}

	public void visit(ConditionWhile conditionWhile){
		for(int i=0; i<skipThenStack.size(); i++){
			skipLoopStack.push(skipThenStack.get(i));
		}
		skipThenStack.clear();
	}

	//skoci ponovo na petlju
	public void visit(Continue toBeContinued){
		if(!loopStack.isEmpty()){
			Code.putJump(loopStack.get(0));
		}
	}

	//stavi skok iza petelje
	public void visit(Break takeABreak){
		skipLoopStack.push(Code.pc+1);
		Code.putJump(0);
	}

	//FOREACH
	private void incForeachCnt(){
		Code.load(myForeachCnt);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(myForeachCnt);

		// Code.load(myForeachCnt);
		// Code.loadConst(5);
		// Code.put(Code.print);
	}

	private void resetForeachCnt(){
		Code.loadConst(0);
		Code.store(myForeachCnt);
	}

	//samo za pamcenje nad kojim nizom je pozvan foreach
	public void visit(ForeachDesignator foreachDesignator){
		currentForeachArray = foreachDesignator.getDesignator().obj;
	}

	//ovde cu da se vracam da pokupim nove vrednosti curr
	public void visit(ForeachIdent foreachIdent){

		resetForeachCnt();
		loopStack.push(Code.pc);

		//if(myForeachCnt < arrayLen)
		Code.load(myForeachCnt);
		Code.loadConst(currentArrayLenght);
		skipLoopStack.push(Code.pc+1);
		Code.putFalseJump(Code.lt, Code.pc);

		//curr = niz[myForeachCnt]
		Code.load(currentArrayObj);
		Code.load(myForeachCnt);
		Code.put(Code.aload);
		Code.store(foreachIdent.getDesignator().obj);

		//curr++
		incForeachCnt();
	}

	public void visit(ForeachStatement foreachStatement){
		Code.putJump(loopStack.pop());

		while(!skipLoopStack.isEmpty()){
			Code.fixup(skipLoopStack.pop());
		}
	}

}
