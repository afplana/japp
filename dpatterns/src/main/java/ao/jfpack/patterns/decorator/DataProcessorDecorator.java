package ao.jfpack.patterns.decorator;

import ao.jfpack.patterns.structure.validation.Validation;
import ao.jfpack.patterns.structure.validation.ValidationException;

public class DataProcessorDecorator extends ValidationDecorator {

    public DataProcessorDecorator(Validation<byte[], String> decorated) {
        super(decorated);
    }

    @Override
    public String validate(byte[] bytes) throws ValidationException {
        return process(bytes);
    }

    private String process(byte[] bytes) {
        return ("Decorated: " + new String(bytes));
    }
}
