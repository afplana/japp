package ao.jfpack.patterns.prototype;

import ao.jfpack.patterns.entity.BaseEntity;
import ao.jfpack.patterns.entity.Country;
import ao.jfpack.patterns.entity.District;

import java.util.Hashtable;
import java.util.logging.Logger;

public class LocalCache {

    private static final Logger log = Logger.getLogger(LocalCache.class.getName());
    private static final Hashtable<Long, BaseEntity> ENTITY_HASHTABLE = new Hashtable<>();

    public static BaseEntity getEntity(long id) {
        BaseEntity cached = ENTITY_HASHTABLE.get(id);
        return (BaseEntity) cached.clone();
    }

    public static void loadCache() {
        Country country = new Country(1, "Germany");
        saveInCache(country);

        District district = new District(1, "3568", "13001", country);
        saveInCache(district);

        District district1 = new District(2, "7653", "13002", country);
        saveInCache(district1);
    }

    public static void saveInCache(BaseEntity entity) {
        ENTITY_HASHTABLE.putIfAbsent(entity.id, entity);
    }

    public static void main (String... args) {
        LocalCache.loadCache();

        Country cloned_1 = (Country) LocalCache.getEntity(1);
        District cloned_2 = (District) LocalCache.getEntity(2);

        log.info("BaseEntity: " + cloned_1.toJson());
        log.info("BaseEntity: " + cloned_2.toJson());
    }
}
