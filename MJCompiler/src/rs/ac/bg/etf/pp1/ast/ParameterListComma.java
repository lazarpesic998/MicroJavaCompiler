// generated with ast extension for cup
// version 0.8
// 6/1/2023 22:22:46


package rs.ac.bg.etf.pp1.ast;

public class ParameterListComma extends ParameterList {

    private ParameterList ParameterList;
    private DesignatorOptional DesignatorOptional;

    public ParameterListComma (ParameterList ParameterList, DesignatorOptional DesignatorOptional) {
        this.ParameterList=ParameterList;
        if(ParameterList!=null) ParameterList.setParent(this);
        this.DesignatorOptional=DesignatorOptional;
        if(DesignatorOptional!=null) DesignatorOptional.setParent(this);
    }

    public ParameterList getParameterList() {
        return ParameterList;
    }

    public void setParameterList(ParameterList ParameterList) {
        this.ParameterList=ParameterList;
    }

    public DesignatorOptional getDesignatorOptional() {
        return DesignatorOptional;
    }

    public void setDesignatorOptional(DesignatorOptional DesignatorOptional) {
        this.DesignatorOptional=DesignatorOptional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ParameterList!=null) ParameterList.accept(visitor);
        if(DesignatorOptional!=null) DesignatorOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ParameterList!=null) ParameterList.traverseTopDown(visitor);
        if(DesignatorOptional!=null) DesignatorOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ParameterList!=null) ParameterList.traverseBottomUp(visitor);
        if(DesignatorOptional!=null) DesignatorOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ParameterListComma(\n");

        if(ParameterList!=null)
            buffer.append(ParameterList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorOptional!=null)
            buffer.append(DesignatorOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ParameterListComma]");
        return buffer.toString();
    }
}
