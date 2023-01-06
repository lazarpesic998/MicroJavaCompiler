// generated with ast extension for cup
// version 0.8
// 4/0/2023 0:53:54


package rs.ac.bg.etf.pp1.ast;

public class FormParsVariableLst extends FormParsVariableList {

    private FormParsVariableList FormParsVariableList;
    private FormPars FormPars;

    public FormParsVariableLst (FormParsVariableList FormParsVariableList, FormPars FormPars) {
        this.FormParsVariableList=FormParsVariableList;
        if(FormParsVariableList!=null) FormParsVariableList.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
    }

    public FormParsVariableList getFormParsVariableList() {
        return FormParsVariableList;
    }

    public void setFormParsVariableList(FormParsVariableList FormParsVariableList) {
        this.FormParsVariableList=FormParsVariableList;
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsVariableList!=null) FormParsVariableList.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsVariableList!=null) FormParsVariableList.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsVariableList!=null) FormParsVariableList.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsVariableLst(\n");

        if(FormParsVariableList!=null)
            buffer.append(FormParsVariableList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsVariableLst]");
        return buffer.toString();
    }
}
