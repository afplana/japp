package ao.jfpack.patterns.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaEnabled implements Criteria<Installation> {

    @Override
    public List<Installation> meetCriteria(List<Installation> installations) {
        return installations.stream()
                .filter(installation -> installation.status.equalsIgnoreCase("ENABLED"))
                .collect(Collectors.toList());
    }
}
