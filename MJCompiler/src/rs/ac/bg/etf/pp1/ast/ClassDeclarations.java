// generated with ast extension for cup
// version 0.8
// 21/0/2023 23:53:41


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarations implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String className;
    private Extension Extension;
    private VarDeclarationsList VarDeclarationsList;
    private MethDeclarationsOptional MethDeclarationsOptional;

    public ClassDeclarations (String className, Extension Extension, VarDeclarationsList VarDeclarationsList, MethDeclarationsOptional MethDeclarationsOptional) {
        this.className=className;
        this.Extension=Extension;
        if(Extension!=null) Extension.setParent(this);
        this.VarDeclarationsList=VarDeclarationsList;
        if(VarDeclarationsList!=null) VarDeclarationsList.setParent(this);
        this.MethDeclarationsOptional=MethDeclarationsOptional;
        if(MethDeclarationsOptional!=null) MethDeclarationsOptional.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public Extension getExtension() {
        return Extension;
    }

    public void setExtension(Extension Extension) {
        this.Extension=Extension;
    }

    public VarDeclarationsList getVarDeclarationsList() {
        return VarDeclarationsList;
    }

    public void setVarDeclarationsList(VarDeclarationsList VarDeclarationsList) {
        this.VarDeclarationsList=VarDeclarationsList;
    }

    public MethDeclarationsOptional getMethDeclarationsOptional() {
        return MethDeclarationsOptional;
    }

    public void setMethDeclarationsOptional(MethDeclarationsOptional MethDeclarationsOptional) {
        this.MethDeclarationsOptional=MethDeclarationsOptional;
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
        if(Extension!=null) Extension.accept(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.accept(visitor);
        if(MethDeclarationsOptional!=null) MethDeclarationsOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Extension!=null) Extension.traverseTopDown(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseTopDown(visitor);
        if(MethDeclarationsOptional!=null) MethDeclarationsOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Extension!=null) Extension.traverseBottomUp(visitor);
        if(VarDeclarationsList!=null) VarDeclarationsList.traverseBottomUp(visitor);
        if(MethDeclarationsOptional!=null) MethDeclarationsOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarations(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(Extension!=null)
            buffer.append(Extension.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclarationsList!=null)
            buffer.append(VarDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethDeclarationsOptional!=null)
            buffer.append(MethDeclarationsOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarations]");
        return buffer.toString();
    }
}
