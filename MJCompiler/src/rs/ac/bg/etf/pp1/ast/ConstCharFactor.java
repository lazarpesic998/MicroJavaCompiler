// generated with ast extension for cup
// version 0.8
// 6/1/2023 22:22:46


package rs.ac.bg.etf.pp1.ast;

public class ConstCharFactor extends Factor {

    private Character charFactor;

    public ConstCharFactor (Character charFactor) {
        this.charFactor=charFactor;
    }

    public Character getCharFactor() {
        return charFactor;
    }

    public void setCharFactor(Character charFactor) {
        this.charFactor=charFactor;
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
        buffer.append("ConstCharFactor(\n");

        buffer.append(" "+tab+charFactor);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstCharFactor]");
        return buffer.toString();
    }
}
