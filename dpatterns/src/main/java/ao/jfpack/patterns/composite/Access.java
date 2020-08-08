package ao.jfpack.patterns.composite;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Access {
    String type;
    Set<Access> accessSet;

    public Access(String type) {
        accessSet = new HashSet<>();
        this.type = type;
    }

    public void add(Access... access) {
        Collections.addAll(accessSet, access);
    }
}
