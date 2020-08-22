package ao.jfpack.patterns.factory;

import ao.jfpack.patterns.entity.Contract;
import ao.jfpack.patterns.entity.Country;
import ao.jfpack.patterns.entity.District;

public class FactoryDemo {

    public static void main(String[] args) {
        String[] countryInfo = "1,Germany".split(",");
        String[] districtInfo = "1,7892,89999921".split(",");

        Country germany = (Country) EntityFactory.entityOf(Country.class, countryInfo);
        District district7892 = (District) EntityFactory.entityOf(District.class, districtInfo);
        district7892.country = germany;

        System.out.println("District 7892 info: " + district7892.toJson());
    }
}
