package ao.jfpack.structure;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class Criteria<T> {

    private final T value;

    private Criteria(T value) {
        this.value = value;
    }

    public static <T> Criteria<T> of(T value) {
        return new Criteria<>(Objects.requireNonNull(value));
    }

    public Criteria<T> testAndAccept(Predicate<T> predicate, Consumer<T> consumer) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(consumer);
        if(predicate.test(value))
            consumer.accept(value);
        return this;
    }

}
