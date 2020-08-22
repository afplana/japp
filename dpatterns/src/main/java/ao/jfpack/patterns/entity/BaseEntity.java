package ao.jfpack.patterns.entity;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    public abstract String toJson();
}
