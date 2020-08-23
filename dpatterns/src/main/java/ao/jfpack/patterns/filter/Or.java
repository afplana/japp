package ao.jfpack.patterns.filter;

import java.util.Collection;

public class Or<T> implements Filter<T> {

    private final Filter<T> filter;
    private final Filter<T> orFilter;

    public Or(Filter<T> filter, Filter<T> orFilter) {
        this.filter = filter;
        this.orFilter = orFilter;
    }

    @Override
    public Collection<T> apply(Collection<T> collection) {
        Collection<T> first = filter.apply(collection);
        Collection<T> other = orFilter.apply(collection);

        for (T t : other) {
            if(!first.contains(t)){
                first.add(t);
            }
        }
        return first;
    }
}
