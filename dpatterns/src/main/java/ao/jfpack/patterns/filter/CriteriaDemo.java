package ao.jfpack.patterns.filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CriteriaDemo {
    public static void main(String... args) {
        List<String> strings = Arrays.asList(null, null, "Alain", "Ingri", "Bery");
        Filter<String> nonNull = new NonNullFilter();

        Collection<String> result = nonNull.apply(strings);

        for (String str : result) {
            System.out.println(str);
        }
    }
}
