// generated with ast extension for cup
// version 0.8
// 4/0/2023 0:53:54


package rs.ac.bg.etf.pp1.ast;

public class OrCondTermLst extends OrCondTermList {

    private OrCondTermList OrCondTermList;
    private OrCondTerm OrCondTerm;

    public OrCondTermLst (OrCondTermList OrCondTermList, OrCondTerm OrCondTerm) {
        this.OrCondTermList=OrCondTermList;
        if(OrCondTermList!=null) OrCondTermList.setParent(this);
        this.OrCondTerm=OrCondTerm;
        if(OrCondTerm!=null) OrCondTerm.setParent(this);
    }

    public OrCondTermList getOrCondTermList() {
        return OrCondTermList;
    }

    public void setOrCondTermList(OrCondTermList OrCondTermList) {
        this.OrCondTermList=OrCondTermList;
    }

    public OrCondTerm getOrCondTerm() {
        return OrCondTerm;
    }

    public void setOrCondTerm(OrCondTerm OrCondTerm) {
        this.OrCondTerm=OrCondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OrCondTermList!=null) OrCondTermList.accept(visitor);
        if(OrCondTerm!=null) OrCondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OrCondTermList!=null) OrCondTermList.traverseTopDown(visitor);
        if(OrCondTerm!=null) OrCondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OrCondTermList!=null) OrCondTermList.traverseBottomUp(visitor);
        if(OrCondTerm!=null) OrCondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OrCondTermLst(\n");

        if(OrCondTermList!=null)
            buffer.append(OrCondTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OrCondTerm!=null)
            buffer.append(OrCondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OrCondTermLst]");
        return buffer.toString();
    }
}
