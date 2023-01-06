package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;

import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class TabS extends Tab {
    //standardni bool tip
    public static final StructExtended boolType = new StructExtended(StructExtended.Bool);

    //standardni nizovni tipovi
    public static final StructExtended intArrayType = new StructExtended(StructExtended.Array, intType);
    public static final StructExtended charArrayType = new StructExtended(StructExtended.Array, charType);
    public static final StructExtended boolArrayType = new StructExtended(StructExtended.Array, boolType);
    public static final StructExtended noArrayType = new StructExtended(StructExtended.Array, noType);


    //TODO: napravi strukturne cvorove za nizove
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
