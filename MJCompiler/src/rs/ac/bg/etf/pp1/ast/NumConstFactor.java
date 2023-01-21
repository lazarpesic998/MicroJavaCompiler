// generated with ast extension for cup
// version 0.8
// 21/0/2023 23:53:41


package rs.ac.bg.etf.pp1.ast;

public class NumConstFactor extends Factor {

    private Integer numFactor;

    public NumConstFactor (Integer numFactor) {
        this.numFactor=numFactor;
    }

    public Integer getNumFactor() {
        return numFactor;
    }

    public void setNumFactor(Integer numFactor) {
        this.numFactor=numFactor;
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
        buffer.append("NumConstFactor(\n");

        buffer.append(" "+tab+numFactor);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConstFactor]");
        return buffer.toString();
    }
}
