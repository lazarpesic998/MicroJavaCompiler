// generated with ast extension for cup
// version 0.8
// 6/1/2023 22:22:46


package rs.ac.bg.etf.pp1.ast;

public class FormVarArray extends FormVariable {

    private Type Type;
    private String formVarName;

    public FormVarArray (Type Type, String formVarName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.formVarName=formVarName;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormVarArray(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+formVarName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormVarArray]");
        return buffer.toString();
    }
}
