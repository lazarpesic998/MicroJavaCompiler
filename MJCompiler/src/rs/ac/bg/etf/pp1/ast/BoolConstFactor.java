// generated with ast extension for cup
// version 0.8
// 21/0/2023 23:53:41


package rs.ac.bg.etf.pp1.ast;

public class BoolConstFactor extends Factor {

    private Boolean boolFactor;

    public BoolConstFactor (Boolean boolFactor) {
        this.boolFactor=boolFactor;
    }

    public Boolean getBoolFactor() {
        return boolFactor;
    }

    public void setBoolFactor(Boolean boolFactor) {
        this.boolFactor=boolFactor;
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
        buffer.append("BoolConstFactor(\n");

        buffer.append(" "+tab+boolFactor);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BoolConstFactor]");
        return buffer.toString();
    }
}
