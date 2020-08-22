package ao.jfpack.patterns.entity;

import java.time.OffsetDateTime;

public class Contract {
    long id;
    OffsetDateTime signedDate;

    public Contract(long id) {
        this.id = id;
        signedDate = OffsetDateTime.now();
    }

    public Contract() {
        this(999);
    }

    public String toString() {
        return "{ ID: " + this.id + " DATE: " + this.signedDate.toString() + " }";
    }
}
