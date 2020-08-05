package ao.jfpack.patterns.bridge;

import java.io.InputStream;

public class InstallationSaveService implements SaveServiceAPI {

    @Override
    public void saveInDatabase(InputStream data) {
        System.out.println("Saving data of type Installation");
    }
}
