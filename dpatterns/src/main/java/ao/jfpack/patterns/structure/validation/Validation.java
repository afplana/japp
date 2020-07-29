package ao.jfpack.patterns.structure.validation;

public interface Validation<T, V> {

    V validate(T t) throws ValidationException;
}
