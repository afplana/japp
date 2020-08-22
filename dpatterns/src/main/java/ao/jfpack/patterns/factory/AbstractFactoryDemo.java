package ao.jfpack.patterns.factory;

import ao.jfpack.patterns.entity.Contract;
import ao.jfpack.patterns.entity.Organisation;
import ao.jfpack.patterns.entity.User;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        String[] userInfo = "1 afplana".split(" ");
        String[] contractInfo = new String[]{"1"};
        String[] organisationInfo = new String[]{"1"};

        User user = (User) FactoryProvider.factoryOf(User.class).build(userInfo);
        Contract contract = (Contract) FactoryProvider
                .factoryOf(Contract.class).build(contractInfo);
        Organisation org = (Organisation) FactoryProvider
                .factoryOf(Organisation.class).build(organisationInfo);

        System.out.println("User info: " + user.toString());
        System.out.println("Contract info: " + contract.toString());
        System.out.println("Organisation info: " + org.toString());
    }
}
