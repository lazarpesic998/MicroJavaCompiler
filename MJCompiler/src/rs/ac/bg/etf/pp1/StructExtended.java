package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class StructExtended extends Struct {

    public static final int Bool = 5;

    public StructExtended(int kind) {
        super(kind);
    }

    public StructExtended(int kind, Struct elemType) {
        super(kind, elemType);
    }

    public StructExtended(int kind, SymbolDataStructure members) {
        super(kind, members);
    }
}
