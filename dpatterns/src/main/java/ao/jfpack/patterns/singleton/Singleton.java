package ao.jfpack.patterns.singleton;

import java.util.Objects;
import java.util.logging.Logger;

public class Singleton {

    private static final Logger log = Logger.getLogger(Singleton.class.getName());
    private static Singleton instance;

    private Singleton(){
    }

    private static Singleton getInstance() {
        // The following code snippet provides the double-checked locking implementation.
        if(Objects.isNull(instance)) {
            synchronized (Singleton.class) {
                if (Objects.isNull(instance))
                    return new Singleton();
            }
        }
        return instance;
    }

    public void verify(String newPath) {
        log.info("Instance created!");
    }
}
