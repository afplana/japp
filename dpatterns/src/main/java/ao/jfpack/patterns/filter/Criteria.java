package ao.jfpack.patterns.filter;

import java.util.List;

public interface Criteria<T> {

    List<T> meetCriteria(List<T> list);
}
