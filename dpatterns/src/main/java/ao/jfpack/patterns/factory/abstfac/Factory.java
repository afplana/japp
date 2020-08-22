package ao.jfpack.patterns.factory.abstfac;

public interface Factory<T> {
    T build(String[] attributes);
}
