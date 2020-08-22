package ao.jfpack.patterns.factory;

import ao.jfpack.patterns.entity.BaseEntity;
import ao.jfpack.patterns.entity.Country;
import ao.jfpack.patterns.entity.District;

import static java.lang.Long.parseLong;

public class EntityFactory {
    public static BaseEntity entityOf(Class<?> clazz, String[] attr) {
        switch (clazz.getSimpleName().toUpperCase()) {
            case "DISTRICT":
                return district(attr);
            case "COUNTRY":
                return country(attr);
            default:
                throw new IllegalStateException("No creator for: " + clazz.getName());
        }
    }

    private static District district(String[] attr) {
        return attr.length >= 3
                ?new District(parseLong(attr[0]), attr[1], attr[2])
                :new District();
    }

    private static Country country(String[] attr) {
        return attr.length >= 2
                ?new Country(parseLong(attr[0]), attr[1])
                :new Country();
    }
}
