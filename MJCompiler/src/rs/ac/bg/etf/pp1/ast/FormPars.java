// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class FormPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private Variable Variable;
    private FormParsVariableList FormParsVariableList;

    public FormPars (Type Type, Variable Variable, FormParsVariableList FormParsVariableList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.Variable=Variable;
        if(Variable!=null) Variable.setParent(this);
        this.FormParsVariableList=FormParsVariableList;
        if(FormParsVariableList!=null) FormParsVariableList.setParent(this);
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

    public FormParsVariableList getFormParsVariableList() {
        return FormParsVariableList;
    }

    public void setFormParsVariableList(FormParsVariableList FormParsVariableList) {
        this.FormParsVariableList=FormParsVariableList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(Variable!=null) Variable.accept(visitor);
        if(FormParsVariableList!=null) FormParsVariableList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(Variable!=null) Variable.traverseTopDown(visitor);
        if(FormParsVariableList!=null) FormParsVariableList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(Variable!=null) Variable.traverseBottomUp(visitor);
        if(FormParsVariableList!=null) FormParsVariableList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

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

        if(FormParsVariableList!=null)
            buffer.append(FormParsVariableList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
