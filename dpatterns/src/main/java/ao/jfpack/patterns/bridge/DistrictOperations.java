package ao.jfpack.patterns.bridge;

import ao.jfpack.patterns.entity.District;

import java.util.ArrayList;
import java.util.List;

public class DistrictOperations implements CrudAPI<District> {

    List<District> districts;

    DistrictOperations() {
        this.districts = new ArrayList<>();
    }


    @Override
    public District save(District baseEntity) {
        districts.add(baseEntity);
        return baseEntity;
    }

    @Override
    public District get(long id) {
        return districts.stream()
                .filter(district -> district.id == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(long id) {
        District district = get(id);
        if (district == null) return;
        districts.remove(district);
    }

    @Override
    public List<District> getAll() {
        return new ArrayList<>(districts);
    }

}
