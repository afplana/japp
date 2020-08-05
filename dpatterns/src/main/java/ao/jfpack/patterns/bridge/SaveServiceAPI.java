package ao.jfpack.patterns.bridge;

import java.io.InputStream;

public interface SaveServiceAPI {
    void saveInDatabase(InputStream data);
}
