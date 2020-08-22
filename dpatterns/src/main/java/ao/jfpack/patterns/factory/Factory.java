package ao.jfpack.patterns.factory;

public interface Factory<T> {
    T build(String[] attributes);
}
