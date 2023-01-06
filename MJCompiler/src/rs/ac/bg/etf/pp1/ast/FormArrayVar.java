// generated with ast extension for cup
// version 0.8
// 4/0/2023 0:53:54


package rs.ac.bg.etf.pp1.ast;

public class FormArrayVar extends FormVariable {

    private String formVarName;

    public FormArrayVar (String formVarName) {
        this.formVarName=formVarName;
    }

    public String getFormVarName() {
        return formVarName;
    }

    public void setFormVarName(String formVarName) {
        this.formVarName=formVarName;
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
        buffer.append("FormArrayVar(\n");

        buffer.append(" "+tab+formVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormArrayVar]");
        return buffer.toString();
    }
}
