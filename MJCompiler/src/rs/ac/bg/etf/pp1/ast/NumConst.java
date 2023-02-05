// generated with ast extension for cup
// version 0.8
// 5/1/2023 1:44:10


package rs.ac.bg.etf.pp1.ast;

public class NumConst extends IdentValuePair {

    private String constName;
    private Integer constVal;

    public NumConst (String constName, Integer constVal) {
        this.constName=constName;
        this.constVal=constVal;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Integer getConstVal() {
        return constVal;
    }

    public void setConstVal(Integer constVal) {
        this.constVal=constVal;
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
        buffer.append("NumConst(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+constVal);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumConst]");
        return buffer.toString();
    }
}
