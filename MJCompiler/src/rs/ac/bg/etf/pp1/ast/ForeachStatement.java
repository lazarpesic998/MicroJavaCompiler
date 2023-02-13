// generated with ast extension for cup
// version 0.8
// 6/1/2023 22:22:46


package rs.ac.bg.etf.pp1.ast;

public class ForeachStatement extends SingleStatement {

    private ForeachDesignator ForeachDesignator;
    private ForeachIdent ForeachIdent;
    private Statement Statement;

    public ForeachStatement (ForeachDesignator ForeachDesignator, ForeachIdent ForeachIdent, Statement Statement) {
        this.ForeachDesignator=ForeachDesignator;
        if(ForeachDesignator!=null) ForeachDesignator.setParent(this);
        this.ForeachIdent=ForeachIdent;
        if(ForeachIdent!=null) ForeachIdent.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForeachDesignator getForeachDesignator() {
        return ForeachDesignator;
    }

    public void setForeachDesignator(ForeachDesignator ForeachDesignator) {
        this.ForeachDesignator=ForeachDesignator;
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
        if(ForeachDesignator!=null) ForeachDesignator.accept(visitor);
        if(ForeachIdent!=null) ForeachIdent.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForeachDesignator!=null) ForeachDesignator.traverseTopDown(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForeachDesignator!=null) ForeachDesignator.traverseBottomUp(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForeachStatement(\n");

        if(ForeachDesignator!=null)
            buffer.append(ForeachDesignator.toString("  "+tab));
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
