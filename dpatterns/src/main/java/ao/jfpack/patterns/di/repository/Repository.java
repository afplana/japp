package ao.jfpack.patterns.di.repository;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> saveAll(Collection<T> c);
}
