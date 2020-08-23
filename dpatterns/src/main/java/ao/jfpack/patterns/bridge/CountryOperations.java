package ao.jfpack.patterns.bridge;

import ao.jfpack.patterns.entity.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryOperations implements CrudAPI<Country> {

    List<Country> countries;

    CountryOperations() {
        this.countries = new ArrayList<>();
    }


    @Override
    public Country save(Country baseEntity) {
        countries.add(baseEntity);
        return baseEntity;
    }

    @Override
    public Country get(long id) {
        return countries.stream()
                .filter(country -> country.id == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(long id) {
        Country country = get(id);
        if (country == null) return;
        countries.remove(country);
    }

    @Override
    public List<Country> getAll() {
        return new ArrayList<>(countries);
    }
}
