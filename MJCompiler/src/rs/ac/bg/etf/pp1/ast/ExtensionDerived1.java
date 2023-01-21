// generated with ast extension for cup
// version 0.8
// 21/0/2023 23:53:41


package rs.ac.bg.etf.pp1.ast;

public class ExtensionDerived1 extends Extension {

    public ExtensionDerived1 () {
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
        buffer.append("ExtensionDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ExtensionDerived1]");
        return buffer.toString();
    }
}
