package ao.jfpack.patterns.factory.abstfac;

public class FactoryProvider {

    public static Factory<?> factoryOf(Class<?> clazz) {
        switch (clazz.getSimpleName().toUpperCase()) {
            case "USER":
                return new UserFactory();
            case "CONTRACT":
                return new ContractFactory();
            case "ORGANISATION":
                return new OrganisationFactory();
            default:
                throw new IllegalArgumentException("No factory for: " + clazz.getName());
        }
    }
}
