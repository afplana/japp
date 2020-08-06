package ao.jfpack.patterns.filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaDemo {
    public static void main(String... args) {
        List<Installation> installations = new ArrayList<>();
        installations.add(new Installation(1L, "ENABLED", "CUSTOMER_1"));
        installations.add(new Installation(2L, "ENABLED", "CUSTOMER_1"));
        installations.add(new Installation(3L, "DISABLED", "CUSTOMER_1"));
        installations.add(new Installation(4L, "ENABLED", "CUSTOMER_2"));
        installations.add(new Installation(5L, "ENABLED", "CUSTOMER_2"));
        installations.add(new Installation(6L, "DISABLED", "CUSTOMER_1"));
        installations.add(new Installation(7L, "UNKNOWN", "CUSTOMER_2"));

        Criteria<Installation> enabled = new CriteriaEnabled();
        Criteria<Installation> disabled = new CriteriaDisabled();
        Criteria<Installation> both = new And<>(enabled, disabled);
        Criteria<Installation> or = new Or<>(enabled, disabled);

        System.out.println("Enabled: ");
        printInstallations(enabled.meetCriteria(installations));

        System.out.println("\nDisabled: ");
        printInstallations(disabled.meetCriteria(installations));

        System.out.println("\nEnabled/Disabled: ");
        printInstallations(both.meetCriteria(installations));

        System.out.println("\nSingle Or Females: ");
        printInstallations(or.meetCriteria(installations));
    }

    private static void printInstallations(List<Installation> meetCriteria) {
        for (Installation installation : meetCriteria) {
            System.out.println(installation.toString());
        }
    }
}
