package ao.jfpack.patterns.factory;

import ao.jfpack.patterns.structure.validation.ChecksumValidation;
import ao.jfpack.patterns.structure.validation.DataValidation;
import ao.jfpack.patterns.structure.validation.Validation;

import java.util.function.Function;

public class ValidationFactory implements Function<Types, Validation<byte[], String>> {

    @Override
    public Validation<byte[], String> apply(Types types) {
        switch (types) {
            case CHECKSUM_VALIDATION_TYPE:
                return new ChecksumValidation();
            case DATA_VALIDATION_TYPE:
                return new DataValidation();
            default:
                throw new IllegalArgumentException("Invalid validation type: " + types);
        }
    }
}
