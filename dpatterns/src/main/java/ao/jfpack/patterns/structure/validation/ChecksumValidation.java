package ao.jfpack.patterns.structure.validation;


import java.util.logging.Logger;

public class ChecksumValidation implements Validation<byte[], String> {

    Logger log = Logger.getLogger(ChecksumValidation.class.getName());

    @Override
    public String validate(byte[] bytes) throws ValidationException{
        log.info("Validating checksum!");
        return new String(bytes);
    }
}
