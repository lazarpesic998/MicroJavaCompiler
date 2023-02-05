// generated with ast extension for cup
// version 0.8
// 5/1/2023 1:44:10


package rs.ac.bg.etf.pp1.ast;

public class FormParsList extends FormPars {

    private FormPars FormPars;
    private FormVariable FormVariable;

    public FormParsList (FormPars FormPars, FormVariable FormVariable) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.FormVariable=FormVariable;
        if(FormVariable!=null) FormVariable.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(FormVariable!=null) FormVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(FormVariable!=null) FormVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(FormVariable!=null) FormVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsList(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormVariable!=null)
            buffer.append(FormVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsList]");
        return buffer.toString();
    }
}
