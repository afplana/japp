package ao.jfpack.patterns.decorator;

import ao.jfpack.patterns.structure.validation.Validation;
import ao.jfpack.patterns.structure.validation.ValidationException;

public abstract class ValidationDecorator implements Validation<byte[], String>{

    protected Validation<byte[], String> decorated;

    public ValidationDecorator(Validation<byte[], String> decorated) {
        this.decorated = decorated;
    }

    @Override
    public String validate(byte[] bytes) throws ValidationException {
        return decorated.validate(bytes);
    }
}
