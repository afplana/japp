package ao.jfpack.patterns.prototype.structure;

public abstract class Smartphone implements Cloneable {

    private String id;
    protected String type;

    abstract void load();

    public String getId() { return this.id; }

    public String getType() { return this.type; }

    public void setId(String id) { this.id = id; }

    public Object clone() {
        Object clone = null;
        try { clone = super.clone(); }
        catch (CloneNotSupportedException e) { e.printStackTrace(); }
        return clone;
    }
}
