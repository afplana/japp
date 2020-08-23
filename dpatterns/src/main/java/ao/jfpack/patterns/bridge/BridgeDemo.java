package ao.jfpack.patterns.bridge;

import ao.jfpack.patterns.entity.Country;
import ao.jfpack.patterns.entity.District;

public class BridgeDemo {
        public static void main(String[] args) {
            CrudAPI<District> districtOps = new DistrictOperations();
            CrudAPI<Country> countryOps = new CountryOperations();

            CrudOperations<District> district = new CrudOperationsImpl<>(new District(),districtOps);
            CrudOperations<Country> country = new CrudOperationsImpl<>(new Country(), countryOps);

            district.save();
            country.save();

            System.out.println();

            System.out.println("District in database: "+districtOps.getAll().size());
            System.out.println("Countries in database: "+countryOps.getAll().size());
        }
}
