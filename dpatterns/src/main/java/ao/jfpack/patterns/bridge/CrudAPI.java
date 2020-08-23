package ao.jfpack.patterns.bridge;

import java.util.List;

public interface CrudAPI<T> {

    T save(T baseEntity);

    T get(long id);

    void delete(long id);

    List<T> getAll();
}
