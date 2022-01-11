// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class FormParsVariableLst extends FormParsVariableList {

    private FormParsVariableList FormParsVariableList;
    private Type Type;
    private Variable Variable;

    public FormParsVariableLst (FormParsVariableList FormParsVariableList, Type Type, Variable Variable) {
        this.FormParsVariableList=FormParsVariableList;
        if(FormParsVariableList!=null) FormParsVariableList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Variable=Variable;
        if(Variable!=null) Variable.setParent(this);
    }

    public FormParsVariableList getFormParsVariableList() {
        return FormParsVariableList;
    }

    public void setFormParsVariableList(FormParsVariableList FormParsVariableList) {
        this.FormParsVariableList=FormParsVariableList;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public Variable getVariable() {
        return Variable;
    }

    public void setVariable(Variable Variable) {
        this.Variable=Variable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsVariableList!=null) FormParsVariableList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(Variable!=null) Variable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsVariableList!=null) FormParsVariableList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Variable!=null) Variable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsVariableList!=null) FormParsVariableList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Variable!=null) Variable.traverseBottomUp(visitor);
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

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Variable!=null)
            buffer.append(Variable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsVariableLst]");
        return buffer.toString();
    }
}
