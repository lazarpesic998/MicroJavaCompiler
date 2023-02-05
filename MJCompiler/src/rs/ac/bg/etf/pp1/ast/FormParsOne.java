// generated with ast extension for cup
// version 0.8
// 5/1/2023 1:44:10


package rs.ac.bg.etf.pp1.ast;

public class FormParsOne extends FormPars {

    private FormVariable FormVariable;

    public FormParsOne (FormVariable FormVariable) {
        this.FormVariable=FormVariable;
        if(FormVariable!=null) FormVariable.setParent(this);
    }

    public FormVariable getFormVariable() {
        return FormVariable;
    }

    public void setFormVariable(FormVariable FormVariable) {
        this.FormVariable=FormVariable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormVariable!=null) FormVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormVariable!=null) FormVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormVariable!=null) FormVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsOne(\n");

        if(FormVariable!=null)
            buffer.append(FormVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsOne]");
        return buffer.toString();
    }
}
