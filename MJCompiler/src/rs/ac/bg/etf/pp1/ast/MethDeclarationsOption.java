// generated with ast extension for cup
// version 0.8
// 6/1/2023 22:22:46


package rs.ac.bg.etf.pp1.ast;

public class MethDeclarationsOption extends MethDeclarationsOptional {

    private MethDeclarations MethDeclarations;

    public MethDeclarationsOption (MethDeclarations MethDeclarations) {
        this.MethDeclarations=MethDeclarations;
        if(MethDeclarations!=null) MethDeclarations.setParent(this);
    }

    public MethDeclarations getMethDeclarations() {
        return MethDeclarations;
    }

    public void setMethDeclarations(MethDeclarations MethDeclarations) {
        this.MethDeclarations=MethDeclarations;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethDeclarations!=null) MethDeclarations.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethDeclarations!=null) MethDeclarations.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethDeclarations!=null) MethDeclarations.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethDeclarationsOption(\n");

        if(MethDeclarations!=null)
            buffer.append(MethDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethDeclarationsOption]");
        return buffer.toString();
    }
}
