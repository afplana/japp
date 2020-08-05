package ao.jfpack.patterns.bridge;

import java.io.InputStream;

public class SaveServiceImpl extends SaveService {

    private final InputStream data;

    public SaveServiceImpl(InputStream data, SaveServiceAPI serviceAPI) {
        super(serviceAPI);
        this.data = data;
    }

    @Override
    public void save() {
        serviceAPI.saveInDatabase(data);
    }
}
