// generated with ast extension for cup
// version 0.8
// 5/1/2023 1:44:10


package rs.ac.bg.etf.pp1.ast;

public class DeclarationsDerived2 extends Declarations {

    private Declarations Declarations;
    private VarDeclarations VarDeclarations;

    public DeclarationsDerived2 (Declarations Declarations, VarDeclarations VarDeclarations) {
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
        this.VarDeclarations=VarDeclarations;
        if(VarDeclarations!=null) VarDeclarations.setParent(this);
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public VarDeclarations getVarDeclarations() {
        return VarDeclarations;
    }

    public void setVarDeclarations(VarDeclarations VarDeclarations) {
        this.VarDeclarations=VarDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declarations!=null) Declarations.accept(visitor);
        if(VarDeclarations!=null) VarDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
        if(VarDeclarations!=null) VarDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        if(VarDeclarations!=null) VarDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationsDerived2(\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarations!=null)
            buffer.append(VarDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationsDerived2]");
        return buffer.toString();
    }
}
