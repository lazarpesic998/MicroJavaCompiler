// generated with ast extension for cup
// version 0.8
// 6/1/2023 0:18:29


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArray extends Designator {

    private DesignatorArrayStart DesignatorArrayStart;
    private Expr Expr;

    public DesignatorArray (DesignatorArrayStart DesignatorArrayStart, Expr Expr) {
        this.DesignatorArrayStart=DesignatorArrayStart;
        if(DesignatorArrayStart!=null) DesignatorArrayStart.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public DesignatorArrayStart getDesignatorArrayStart() {
        return DesignatorArrayStart;
    }

    public void setDesignatorArrayStart(DesignatorArrayStart DesignatorArrayStart) {
        this.DesignatorArrayStart=DesignatorArrayStart;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorArrayStart!=null) DesignatorArrayStart.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorArrayStart!=null) DesignatorArrayStart.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorArrayStart!=null) DesignatorArrayStart.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArray(\n");

        if(DesignatorArrayStart!=null)
            buffer.append(DesignatorArrayStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorArray]");
        return buffer.toString();
    }
}
