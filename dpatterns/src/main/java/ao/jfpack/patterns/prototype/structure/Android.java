package ao.jfpack.patterns.prototype.structure;

import java.util.logging.Logger;

public class Android extends Smartphone {

    Logger log = Logger.getLogger(Android.class.getName());

    public Android(){
        type = "Android";
    }

    @Override
    public void load() {
        log.info("Loading Android screen...");
    }
}
