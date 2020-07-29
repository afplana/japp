package ao.jfpack.patterns.factory;

import ao.jfpack.patterns.structure.validation.ChecksumValidation;
import ao.jfpack.patterns.structure.validation.DataValidation;

public enum Types {

    CHECKSUM_VALIDATION_TYPE(ChecksumValidation.class.getTypeName()),
    DATA_VALIDATION_TYPE(DataValidation.class.getName());

    String type;

    Types(String type) {
        this.type = type;
    }
}
