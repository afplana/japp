package ao.jfpack.patterns.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class NonNullFilter implements Filter<String> {

    @Override
    public Collection<String> apply(Collection<String> list) {
        return list.stream().filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
