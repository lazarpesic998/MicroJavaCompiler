//package rs.ac.bg.etf.pp1;
//
//import org.apache.log4j.Logger;
//import rs.ac.bg.etf.pp1.ast.*;
//import rs.etf.pp1.symboltable.Tab;
//import rs.etf.pp1.symboltable.*;
//import rs.etf.pp1.symboltable.concepts.Obj;
//import rs.etf.pp1.symboltable.concepts.Struct;
//
//
//import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
//
//public class SemanticAnalyzer extends VisitorAdaptor {
//	
//	boolean errorDetected = false;
//	int printCallCount = 0;
//	Obj topScope = null;
//	boolean returnFound = false;
//	int nVars;
//	int varCnt = 0;
//
//	//pomaze mi da nadjem koji je tip trenutno, valjda nece da napravi problem
//	Struct currentType = null;
//
//	Logger log = Logger.getLogger(getClass());
//
//	public void report_error(String message, SyntaxNode info) {
//		errorDetected = true;
//		StringBuilder msg = new StringBuilder(message);
//		int line = (info == null) ? 0: info.getLine();
//		if (line != 0)
//			msg.append (" na liniji ").append(line);
//		log.error(msg.toString());
//	}
//
//	public void report_info(String message, SyntaxNode info) {
//		StringBuilder msg = new StringBuilder(message); 
//		int line = (info == null) ? 0: info.getLine();
//		if (line != 0)
//			msg.append (" na liniji ").append(line);
//		log.info(msg.toString());
//	}
//
//	
//
//	public void visit(ProgName progName) {
//		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
//		Tab.openScope();
//	}
//	
//	public void visit(Program program) {
//		
//		Tab.chainLocalSymbols(program.getProgName().obj);
//		Tab.closeScope();
//	}
//	
//	public void visit(Var varName) {
//
//		Tab.insert(Obj.Var, varName.getVarName(), currentType);
//		//log info
//		varCnt++;
//		report_info("Deklarisana promenljiva " + varName.getVarName() + " tipa " + currentType.getKind(), varName);
//	}
//	
//	
//	public void visit(ArrayVar varName) {
//
//		Struct currentArrayType = null;
//		if(currentType == TabS.intType){ currentArrayType = TabS.intArrayType;}
//		if(currentType == TabS.charType){ currentArrayType = TabS.charArrayType;}
//		if(currentType == TabS.boolType){ currentArrayType = TabS.boolArrayType;}
//		if(currentType == TabS.noType){ currentArrayType = TabS.noArrayType;}
//
//		Tab.insert(Obj.Var, varName.getVarName(), currentArrayType);
//
//		//log info
//		varCnt++;
//		report_info("Deklarisana nizovna promenljiva " + varName.getVarName() + " tipa " + currentType.getKind(), varName);
//	}
//	
//	public void visit(Type typeName) {
//		Obj typeNode = Tab.find(typeName.getTypeName());
//    	if(typeNode == Tab.noObj){
//    		report_error("Nije pronadjen tip " + typeName.getTypeName() + " u tabeli simbola! ", null);
//    		typeName.struct = Tab.noType;
//    	}else{
//    		if(Obj.Type == typeNode.getKind()){
//    			typeName.struct = typeNode.getType();
//    		}else{
//    			report_error("Greska: Ime " + typeName.getTypeName() + " ne predstavlja tip!", typeName);
//    			typeName.struct = Tab.noType;
//    		}
//    	}
//    	currentType = typeName.struct;
//	}
//	
//	public void visit(VarDeclarations varDeclarations) {
//		//Obj varNode = Tab.insert(Obj.Var, , varDeclarations.getType().struct);
//		//Tab.insert(Obj.Var, varDeclarations.get, varDeclarations.getType().struct);
//	}
//
//
//	//METHODS
//	public void visit(MethodReturnType typeName) {
//		currentType = typeName.getType().struct;
//	}
//	public void visit(MethodReturnVoid typeName) {
//		currentType = new StructExtended(Struct.None);
//	}
//}
