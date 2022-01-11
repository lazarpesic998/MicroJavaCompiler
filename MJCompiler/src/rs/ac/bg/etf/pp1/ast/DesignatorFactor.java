// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorFactor extends Factor {

    private Designator Designator;
    private ActParsParenOptional ActParsParenOptional;

    public DesignatorFactor (Designator Designator, ActParsParenOptional ActParsParenOptional) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsParenOptional=ActParsParenOptional;
        if(ActParsParenOptional!=null) ActParsParenOptional.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsParenOptional getActParsParenOptional() {
        return ActParsParenOptional;
    }

    public void setActParsParenOptional(ActParsParenOptional ActParsParenOptional) {
        this.ActParsParenOptional=ActParsParenOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsParenOptional!=null) ActParsParenOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsParenOptional!=null) ActParsParenOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsParenOptional!=null) ActParsParenOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorFactor(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsParenOptional!=null)
            buffer.append(ActParsParenOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorFactor]");
        return buffer.toString();
    }
}
