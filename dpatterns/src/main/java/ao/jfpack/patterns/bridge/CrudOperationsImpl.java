package ao.jfpack.patterns.bridge;

public class CrudOperationsImpl<T> extends CrudOperations<T> {

    private final T data;

    public CrudOperationsImpl(T data, CrudAPI<T> serviceAPI) {
        super(serviceAPI);
        this.data = data;
    }

    @Override
    public T save() {
        System.out.println("Entity " + data + " saved!");
        return serviceAPI.save(data);
    }
}
