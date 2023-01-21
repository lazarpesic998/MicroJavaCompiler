// generated with ast extension for cup
// version 0.8
// 21/0/2023 23:53:41


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MethodTypeName MethodTypeName;
    private FormalParsOptional FormalParsOptional;
    private VarDeclarationsList VarDeclarationsList;
    private StatementList StatementList;

    public MethodDecl (MethodTypeName MethodTypeName, FormalParsOptional FormalParsOptional, VarDeclarationsList VarDeclarationsList, StatementList StatementList) {
        this.MethodTypeName=MethodTypeName;
        if(MethodTypeName!=null) MethodTypeName.setParent(this);
        this.FormalParsOptional=FormalParsOptional;
        if(FormalParsOptional!=null) FormalParsOptional.setParent(this);
        this.VarDeclarationsList=VarDeclarationsList;
        if(VarDeclarationsList!=null) VarDeclarationsList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodTypeName getMethodTypeName() {
        return MethodTypeName;
    }

    public void setMethodTypeName(MethodTypeName MethodTypeName) {
        this.MethodTypeName=MethodTypeName;
    }

    public FormalParsOptional getFormalParsOptional() {
        return FormalParsOptional;
    }

    public void setFormalParsOptional(FormalParsOptional FormalParsOptional) {
        this.FormalParsOptional=FormalParsOptional;
    }

    public VarDeclarationsList getVarDeclarationsList() {
        return VarDeclarationsList;
    }

    public void setVarDeclarationsList(VarDeclarationsList VarDeclarationsList) {
        this.VarDeclarationsList=VarDeclarationsList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
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
        if(MethodTypeName!=null) MethodTypeName.accept(visitor);
        if(FormalParsOptional!=null) FormalParsOptional.accept(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodTypeName!=null) MethodTypeName.traverseTopDown(visitor);
        if(FormalParsOptional!=null) FormalParsOptional.traverseTopDown(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodTypeName!=null) MethodTypeName.traverseBottomUp(visitor);
        if(FormalParsOptional!=null) FormalParsOptional.traverseBottomUp(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(MethodTypeName!=null)
            buffer.append(MethodTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormalParsOptional!=null)
            buffer.append(FormalParsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationsList!=null)
            buffer.append(VarDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
