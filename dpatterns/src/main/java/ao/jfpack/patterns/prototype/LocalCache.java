package ao.jfpack.patterns.prototype;

import ao.jfpack.patterns.prototype.structure.Android;
import ao.jfpack.patterns.prototype.structure.Iphone;
import ao.jfpack.patterns.prototype.structure.Smartphone;

import java.util.Hashtable;
import java.util.logging.Logger;

public class LocalCache {

    private static final Hashtable<String, Smartphone> smartphoneHashtable  = new Hashtable<>();
    private static final Logger log = Logger.getLogger(LocalCache.class.getName());

    public static Smartphone getSmartphone(String id) {
        Smartphone cached = smartphoneHashtable.get(id);
        return (Smartphone) cached.clone();
    }

    public static void loadCache() {
        Iphone iphone = new Iphone();
        iphone.setId("1");
        saveInCache(iphone);

        Android android = new Android();
        android.setId("2");
        saveInCache(android);

        Android android_existent = new Android();
        android_existent.setId("2");
        saveInCache(android_existent);
    }

    public static void saveInCache(Smartphone smartphone) {
        smartphoneHashtable.putIfAbsent(smartphone.getId(), smartphone);
    }

    public static void main (String... args) {
        LocalCache.loadCache();

        Smartphone cloned_1 = (Smartphone) LocalCache.getSmartphone("1");
        Smartphone cloned_2 = (Smartphone) LocalCache.getSmartphone("2");

        log.info("Smartphone: " + cloned_1.getType());
        ((Iphone)cloned_1).load();
        log.info("Smartphone: " + cloned_2.getType());
        ((Android)cloned_2).load();
    }
}
