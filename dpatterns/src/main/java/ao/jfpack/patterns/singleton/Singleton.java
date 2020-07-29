package ao.jfpack.patterns.singleton;

import java.util.Objects;
import java.util.logging.Logger;

public class Singleton {

    private static final Singleton instance = new Singleton();

    Logger log = Logger.getLogger(this.getClass().getName());

    private Singleton(){
    }

    private static Singleton getInstance() {
        if(Objects.isNull(instance))
            return new Singleton();
        return instance;
    }

    public void verify(String newPath) {
        log.info("Instance created!");
    }
}
