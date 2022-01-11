// generated with ast extension for cup
// version 0.8
// 11/0/2022 21:44:31


package rs.ac.bg.etf.pp1.ast;

public class CommaNumConstOption extends CommaNumConstOptional {

    private CommaNumConstOptional CommaNumConstOptional;
    private Integer N2;

    public CommaNumConstOption (CommaNumConstOptional CommaNumConstOptional, Integer N2) {
        this.CommaNumConstOptional=CommaNumConstOptional;
        if(CommaNumConstOptional!=null) CommaNumConstOptional.setParent(this);
        this.N2=N2;
    }

    public CommaNumConstOptional getCommaNumConstOptional() {
        return CommaNumConstOptional;
    }

    public void setCommaNumConstOptional(CommaNumConstOptional CommaNumConstOptional) {
        this.CommaNumConstOptional=CommaNumConstOptional;
    }

    public Integer getN2() {
        return N2;
    }

    public void setN2(Integer N2) {
        this.N2=N2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CommaNumConstOptional!=null) CommaNumConstOptional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CommaNumConstOptional!=null) CommaNumConstOptional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CommaNumConstOptional!=null) CommaNumConstOptional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CommaNumConstOption(\n");

        if(CommaNumConstOptional!=null)
            buffer.append(CommaNumConstOptional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+N2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CommaNumConstOption]");
        return buffer.toString();
    }
}
