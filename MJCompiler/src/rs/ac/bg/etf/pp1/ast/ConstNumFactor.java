// generated with ast extension for cup
// version 0.8
// 6/1/2023 0:18:29


package rs.ac.bg.etf.pp1.ast;

public class ConstNumFactor extends Factor {

    private Integer numFactor;

    public ConstNumFactor (Integer numFactor) {
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
        buffer.append("ConstNumFactor(\n");

        buffer.append(" "+tab+numFactor);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstNumFactor]");
        return buffer.toString();
    }
}
