// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class DeclarationsDerived4 extends Declarations {

    private Declarations Declarations;
    private RecordDeclarations RecordDeclarations;

    public DeclarationsDerived4 (Declarations Declarations, RecordDeclarations RecordDeclarations) {
        this.Declarations=Declarations;
        if(Declarations!=null) Declarations.setParent(this);
        this.RecordDeclarations=RecordDeclarations;
        if(RecordDeclarations!=null) RecordDeclarations.setParent(this);
    }

    public Declarations getDeclarations() {
        return Declarations;
    }

    public void setDeclarations(Declarations Declarations) {
        this.Declarations=Declarations;
    }

    public RecordDeclarations getRecordDeclarations() {
        return RecordDeclarations;
    }

    public void setRecordDeclarations(RecordDeclarations RecordDeclarations) {
        this.RecordDeclarations=RecordDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Declarations!=null) Declarations.accept(visitor);
        if(RecordDeclarations!=null) RecordDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Declarations!=null) Declarations.traverseTopDown(visitor);
        if(RecordDeclarations!=null) RecordDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Declarations!=null) Declarations.traverseBottomUp(visitor);
        if(RecordDeclarations!=null) RecordDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationsDerived4(\n");

        if(Declarations!=null)
            buffer.append(Declarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RecordDeclarations!=null)
            buffer.append(RecordDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationsDerived4]");
        return buffer.toString();
    }
}
