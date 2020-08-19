package ao.jfpack.patterns.structure.validation;

import java.util.logging.Logger;

public class DataValidation implements Validation<byte[], String> {

    private static final Logger log = Logger.getLogger(DataValidation.class.getName());

    @Override
    public String validate(byte[] bytes) {
        log.info("Validating data!");
        return new String(bytes);
    }
}
