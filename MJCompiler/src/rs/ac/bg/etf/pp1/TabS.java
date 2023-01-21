package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class TabS extends Tab {
    //standardni bool tip -strukturni cvor
    public static final Struct boolType = new Struct(Struct.Bool);

    //standardni nizovni tipovi - strukturni cvorovi za nizove
    public static final Struct intArrayType = new Struct(Struct.Array, intType);
    public static final Struct charArrayType = new Struct(Struct.Array, charType);
    public static final Struct boolArrayType = new Struct(Struct.Array, boolType);
    public static final Struct noArrayType = new Struct(Struct.Array, noType);

    public static Struct findArrayType(Struct s){
        if(s == TabS.intType) return intArrayType;
		if(s == TabS.charType) return charArrayType;
		if(s == TabS.boolType) return boolArrayType;
        
		return noArrayType;
    }

    
    public static void init() {
        Tab.init();
        Scope universe = currentScope;
        universe.addToLocals(new Obj(Obj.Type, "bool", boolType));
        universe.addToLocals(new Obj(Obj.Type, "intArray", intArrayType));
        universe.addToLocals(new Obj(Obj.Type, "charArray", charArrayType));
        universe.addToLocals(new Obj(Obj.Type, "boolArray", boolArrayType));
        universe.addToLocals(new Obj(Obj.Type, "noArray", noArrayType));

    }

    /*public static void dump(SymbolTableVisitor stv) {
        System.out.println("=====================SYMBOL TABLE DUMP=========================");
        if (stv == null)
            stv = new DumpSymbolTableVisitor();
        for (Scope s = currentScope; s != null; s = s.getOuter()) {
            s.accept(stv);
        }
        System.out.println(stv.getOutput());
    }*/

    //TODO: napravi insert sa drugim parametrima
    //public static Obj insert(int kind, String name, Struct type)
}
