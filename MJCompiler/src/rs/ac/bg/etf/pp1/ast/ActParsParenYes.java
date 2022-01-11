// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class ActParsParenYes extends ActParsParenOptional {

    private ActParsParen ActParsParen;

    public ActParsParenYes (ActParsParen ActParsParen) {
        this.ActParsParen=ActParsParen;
        if(ActParsParen!=null) ActParsParen.setParent(this);
    }

    public ActParsParen getActParsParen() {
        return ActParsParen;
    }

    public void setActParsParen(ActParsParen ActParsParen) {
        this.ActParsParen=ActParsParen;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsParen!=null) ActParsParen.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsParen!=null) ActParsParen.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsParen!=null) ActParsParen.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsParenYes(\n");

        if(ActParsParen!=null)
            buffer.append(ActParsParen.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsParenYes]");
        return buffer.toString();
    }
}
