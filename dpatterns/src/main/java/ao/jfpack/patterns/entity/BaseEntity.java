package ao.jfpack.patterns.entity;

import java.io.Serializable;
import java.util.logging.Logger;

public abstract class BaseEntity implements Serializable, Cloneable {

    private static final Logger log = Logger.getLogger(BaseEntity.class.getName());
    public long id;
    public abstract String toJson();

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return clone;
    }
}
