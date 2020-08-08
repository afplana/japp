package ao.jfpack.patterns.decorator;

import ao.jfpack.patterns.structure.validation.DataValidation;
import ao.jfpack.patterns.structure.validation.Validation;
import ao.jfpack.patterns.structure.validation.ValidationException;

public class DecoratorDemo {
    public static void main(String... args) throws ValidationException {
        Validation<byte[], String> validation = new DataValidation();
        Validation<byte[], String> decorated = new DataProcessorDecorator(validation);

        System.out.println(decorated.validate("this".getBytes()));
    }
}
