// generated with ast extension for cup
// version 0.8
// 6/1/2023 0:18:28


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclLst extends ConstDeclList {

    private ConstDeclList ConstDeclList;
    private IdentValuePair IdentValuePair;

    public ConstDeclLst (ConstDeclList ConstDeclList, IdentValuePair IdentValuePair) {
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
        this.IdentValuePair=IdentValuePair;
        if(IdentValuePair!=null) IdentValuePair.setParent(this);
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public IdentValuePair getIdentValuePair() {
        return IdentValuePair;
    }

    public void setIdentValuePair(IdentValuePair IdentValuePair) {
        this.IdentValuePair=IdentValuePair;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
        if(IdentValuePair!=null) IdentValuePair.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
        if(IdentValuePair!=null) IdentValuePair.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        if(IdentValuePair!=null) IdentValuePair.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclLst(\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentValuePair!=null)
            buffer.append(IdentValuePair.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclLst]");
        return buffer.toString();
    }
}
