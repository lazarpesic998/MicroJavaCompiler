// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class DeclarationsDerived3 extends Declarations {

    private Declarations Declarations;
    private ClassDeclarations ClassDeclarations;

    public DeclarationsDerived3 (Declarations Declarations, ClassDeclarations ClassDeclarations) {
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
        this.ClassDeclarations=ClassDeclarations;
        if(ClassDeclarations!=null) ClassDeclarations.setParent(this);
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public ClassDeclarations getClassDeclarations() {
        return ClassDeclarations;
    }

    public void setClassDeclarations(ClassDeclarations ClassDeclarations) {
        this.ClassDeclarations=ClassDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declarations!=null) Declarations.accept(visitor);
        if(ClassDeclarations!=null) ClassDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
        if(ClassDeclarations!=null) ClassDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        if(ClassDeclarations!=null) ClassDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationsDerived3(\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclarations!=null)
            buffer.append(ClassDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationsDerived3]");
        return buffer.toString();
    }
}
