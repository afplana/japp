package ao.jfpack.patterns.filter;

import java.util.Collection;

public class And<T> implements Filter<T> {

    private final Filter<T> filter;
    private final Filter<T> andFilter;

    public And(Filter<T> filter, Filter<T> andFilter) {
        this.filter = filter;
        this.andFilter = andFilter;
    }

    @Override
    public Collection<T> apply(Collection<T> collection) {
        Collection<T> first = filter.apply(collection);
        return andFilter.apply(first);
    }
}
