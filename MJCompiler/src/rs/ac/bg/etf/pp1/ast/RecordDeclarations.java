// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class RecordDeclarations implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String recordName;
    private VarDeclarationsList VarDeclarationsList;

    public RecordDeclarations (String recordName, VarDeclarationsList VarDeclarationsList) {
        this.recordName=recordName;
        this.VarDeclarationsList=VarDeclarationsList;
        if(VarDeclarationsList!=null) VarDeclarationsList.setParent(this);
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName=recordName;
    }

    public VarDeclarationsList getVarDeclarationsList() {
        return VarDeclarationsList;
    }

    public void setVarDeclarationsList(VarDeclarationsList VarDeclarationsList) {
        this.VarDeclarationsList=VarDeclarationsList;
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
        if(VarDeclarationsList!=null) VarDeclarationsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDeclarations(\n");

        buffer.append(" "+tab+recordName);
        buffer.append("\n");

        if(VarDeclarationsList!=null)
            buffer.append(VarDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDeclarations]");
        return buffer.toString();
    }
}
