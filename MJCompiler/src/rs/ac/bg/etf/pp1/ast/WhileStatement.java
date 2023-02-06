// generated with ast extension for cup
// version 0.8
// 6/1/2023 0:18:28


package rs.ac.bg.etf.pp1.ast;

public class WhileStatement extends SingleStatement {

    private WhileStart WhileStart;
    private ConditionWhile ConditionWhile;
    private Statement Statement;

    public WhileStatement (WhileStart WhileStart, ConditionWhile ConditionWhile, Statement Statement) {
        this.WhileStart=WhileStart;
        if(WhileStart!=null) WhileStart.setParent(this);
        this.ConditionWhile=ConditionWhile;
        if(ConditionWhile!=null) ConditionWhile.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public WhileStart getWhileStart() {
        return WhileStart;
    }

    public void setWhileStart(WhileStart WhileStart) {
        this.WhileStart=WhileStart;
    }

    public ConditionWhile getConditionWhile() {
        return ConditionWhile;
    }

    public void setConditionWhile(ConditionWhile ConditionWhile) {
        this.ConditionWhile=ConditionWhile;
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
        if(WhileStart!=null) WhileStart.accept(visitor);
        if(ConditionWhile!=null) ConditionWhile.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(WhileStart!=null) WhileStart.traverseTopDown(visitor);
        if(ConditionWhile!=null) ConditionWhile.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(WhileStart!=null) WhileStart.traverseBottomUp(visitor);
        if(ConditionWhile!=null) ConditionWhile.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WhileStatement(\n");

        if(WhileStart!=null)
            buffer.append(WhileStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionWhile!=null)
            buffer.append(ConditionWhile.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [WhileStatement]");
        return buffer.toString();
    }
}
