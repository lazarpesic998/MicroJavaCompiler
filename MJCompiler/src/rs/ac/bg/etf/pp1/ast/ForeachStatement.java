// generated with ast extension for cup
// version 0.8
// 21/0/2023 23:53:41


package rs.ac.bg.etf.pp1.ast;

public class ForeachStatement extends SingleStatement {

    private Designator Designator;
    private ForeachStart ForeachStart;
    private ForeachIdent ForeachIdent;
    private Statement Statement;

    public ForeachStatement (Designator Designator, ForeachStart ForeachStart, ForeachIdent ForeachIdent, Statement Statement) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ForeachStart=ForeachStart;
        if(ForeachStart!=null) ForeachStart.setParent(this);
        this.ForeachIdent=ForeachIdent;
        if(ForeachIdent!=null) ForeachIdent.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ForeachStart getForeachStart() {
        return ForeachStart;
    }

    public void setForeachStart(ForeachStart ForeachStart) {
        this.ForeachStart=ForeachStart;
    }

    public ForeachIdent getForeachIdent() {
        return ForeachIdent;
    }

    public void setForeachIdent(ForeachIdent ForeachIdent) {
        this.ForeachIdent=ForeachIdent;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ForeachStart!=null) ForeachStart.accept(visitor);
        if(ForeachIdent!=null) ForeachIdent.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ForeachStart!=null) ForeachStart.traverseTopDown(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ForeachStart!=null) ForeachStart.traverseBottomUp(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForeachStatement(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForeachStart!=null)
            buffer.append(ForeachStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForeachIdent!=null)
            buffer.append(ForeachIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForeachStatement]");
        return buffer.toString();
    }
}
