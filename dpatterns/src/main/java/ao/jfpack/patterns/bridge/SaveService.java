package ao.jfpack.patterns.bridge;

public abstract class SaveService {

    protected SaveServiceAPI serviceAPI;

    protected SaveService(SaveServiceAPI serviceAPI) {
        this.serviceAPI = serviceAPI;
    }

    public abstract void save();
}
