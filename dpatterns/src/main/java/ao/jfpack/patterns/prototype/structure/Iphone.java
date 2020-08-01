package ao.jfpack.patterns.prototype.structure;

import java.util.logging.Logger;

public class Iphone extends Smartphone {

    Logger log = Logger.getLogger(Iphone.class.getName());

    public Iphone(){
        type = "iPhone";
    }
    @Override
    public void load() {
        log.info("Loading Iphone screen...");
    }
}
