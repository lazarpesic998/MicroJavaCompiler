// generated with ast extension for cup
// version 0.8
// 6/1/2023 0:18:29


package rs.ac.bg.etf.pp1.ast;

public class ActParsListDerived1 extends ActParsList {

    public ActParsListDerived1 () {
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
        buffer.append("ActParsListDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ActParsListDerived1]");
        return buffer.toString();
    }
}
