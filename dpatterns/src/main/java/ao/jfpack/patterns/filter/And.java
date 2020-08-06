package ao.jfpack.patterns.filter;

import java.util.List;

public class And<T> implements Criteria<T> {

    private final Criteria<T> criteria;
    private final Criteria<T> otherCriteria;

    public And(Criteria<T> criteria, Criteria<T> otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<T> meetCriteria(List<T> list) {
        List<T> first = criteria.meetCriteria(list);
        return otherCriteria.meetCriteria(first);
    }
}
