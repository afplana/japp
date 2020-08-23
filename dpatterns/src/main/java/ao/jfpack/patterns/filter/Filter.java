package ao.jfpack.patterns.filter;

import java.util.Collection;

public interface Filter<T> {
    Collection<T> apply(Collection<T> list);
}
