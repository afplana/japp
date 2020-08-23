package ao.jfpack.patterns.bridge;

public abstract class CrudOperations<T> {

    protected CrudAPI<T> serviceAPI;

    protected CrudOperations(CrudAPI<T> serviceAPI) {
        this.serviceAPI = serviceAPI;
    }

    public abstract T save();
}
