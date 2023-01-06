// generated with ast extension for cup
// version 0.8
// 4/0/2023 0:53:54


package rs.ac.bg.etf.pp1.ast;

public class AndCondFactLst extends AndCondFactList {

    private AndCondFactList AndCondFactList;
    private AndCondFact AndCondFact;

    public AndCondFactLst (AndCondFactList AndCondFactList, AndCondFact AndCondFact) {
        this.AndCondFactList=AndCondFactList;
        if(AndCondFactList!=null) AndCondFactList.setParent(this);
        this.AndCondFact=AndCondFact;
        if(AndCondFact!=null) AndCondFact.setParent(this);
    }

    public AndCondFactList getAndCondFactList() {
        return AndCondFactList;
    }

    public void setAndCondFactList(AndCondFactList AndCondFactList) {
        this.AndCondFactList=AndCondFactList;
    }

    public AndCondFact getAndCondFact() {
        return AndCondFact;
    }

    public void setAndCondFact(AndCondFact AndCondFact) {
        this.AndCondFact=AndCondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AndCondFactList!=null) AndCondFactList.accept(visitor);
        if(AndCondFact!=null) AndCondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AndCondFactList!=null) AndCondFactList.traverseTopDown(visitor);
        if(AndCondFact!=null) AndCondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AndCondFactList!=null) AndCondFactList.traverseBottomUp(visitor);
        if(AndCondFact!=null) AndCondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AndCondFactLst(\n");

        if(AndCondFactList!=null)
            buffer.append(AndCondFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AndCondFact!=null)
            buffer.append(AndCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AndCondFactLst]");
        return buffer.toString();
    }
}
