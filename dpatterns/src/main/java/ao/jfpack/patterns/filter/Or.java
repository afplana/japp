package ao.jfpack.patterns.filter;

import java.util.List;

public class Or<T> implements Criteria<T> {

    private final Criteria<T> criteria;
    private final Criteria<T> otherCriteria;

    public Or(Criteria<T> criteria, Criteria<T> otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<T> meetCriteria(List<T> list) {

        List<T> first = criteria.meetCriteria(list);
        List<T> other = otherCriteria.meetCriteria(list);

        for (T t : other) {
            if(!first.contains(t)){
                first.add(t);
            }
        }
        return first;
    }
}
