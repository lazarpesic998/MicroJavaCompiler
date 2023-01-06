// generated with ast extension for cup
// version 0.8
// 4/0/2023 0:53:54


package rs.ac.bg.etf.pp1.ast;

public class FormParss extends FormPars {

    private Type Type;
    private FormVariable FormVariable;

    public FormParss (Type Type, FormVariable FormVariable) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormVariable=FormVariable;
        if(FormVariable!=null) FormVariable.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(FormVariable!=null) FormVariable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormVariable!=null) FormVariable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormVariable!=null) FormVariable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParss(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormVariable!=null)
            buffer.append(FormVariable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParss]");
        return buffer.toString();
    }
}
