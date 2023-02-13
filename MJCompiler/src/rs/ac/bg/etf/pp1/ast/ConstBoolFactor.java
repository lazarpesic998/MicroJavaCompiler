// generated with ast extension for cup
// version 0.8
// 6/1/2023 22:22:46


package rs.ac.bg.etf.pp1.ast;

public class ConstBoolFactor extends Factor {

    private Boolean boolFactor;

    public ConstBoolFactor (Boolean boolFactor) {
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
        buffer.append("ConstBoolFactor(\n");

        buffer.append(" "+tab+boolFactor);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstBoolFactor]");
        return buffer.toString();
    }
}
