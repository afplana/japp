package ao.jfpack.patterns.entity;

import java.util.Objects;

public class Organisation {
    public long id;
    public District district;

    public Organisation(long id, District district) {
        this.id = id;
        this.district = district;
    }

    public Organisation(long id) {
        this(id, null);
    }

    public Organisation() {
        this(999, null);
    }

    public String toString() {
        return "{ ID: "+ id + " }";
    }

}
