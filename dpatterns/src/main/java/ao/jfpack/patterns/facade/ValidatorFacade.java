package ao.jfpack.patterns.facade;

import ao.jfpack.patterns.structure.validation.ChecksumValidation;
import ao.jfpack.patterns.structure.validation.DataValidation;
import ao.jfpack.patterns.structure.validation.Validation;
import ao.jfpack.patterns.structure.validation.ValidationException;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class ValidatorFacade {

    private final Validation<byte[], String> data;
    private final Validation<byte[], String> checksum;

    Logger log = Logger.getLogger(this.getClass().getName());

    private ValidatorFacade() {
        data = new DataValidation();
        checksum = new ChecksumValidation();
    }

    public Supplier<ValidatorFacade> instance() {
        return ValidatorFacade::new;
    }

    private boolean validateChecksum(byte[] bytes, String expected) {
        String fromData = null;
        try {
            fromData = checksum.validate(bytes);
            data.validate(bytes);
        } catch (ValidationException e) {
            log.severe("Validation failed! with error: " + e);
        }
        assert fromData != null;
        return fromData.equals(expected);
    }
}
