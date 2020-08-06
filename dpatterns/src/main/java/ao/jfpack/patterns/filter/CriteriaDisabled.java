package ao.jfpack.patterns.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaDisabled implements Criteria<Installation> {

    @Override
    public List<Installation> meetCriteria(List<Installation> installations) {
        return installations.stream()
                .filter(installation -> installation.status.equals("DISABLED"))
                .collect(Collectors.toList());
    }
}
