// generated with ast extension for cup
// version 0.8
// 5/1/2023 1:44:10


package rs.ac.bg.etf.pp1.ast;

public class FormalParsOptionalDerived1 extends FormalParsOptional {

    public FormalParsOptionalDerived1 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParsOptionalDerived1(\n");

        buffer.append(tab);
        buffer.append(") [FormalParsOptionalDerived1]");
        return buffer.toString();
    }
}
