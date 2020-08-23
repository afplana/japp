package ao.jfpack.patterns.adapter;

import javax.net.ssl.SSLSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Response<T> {

    int statusCode();

    Map<String, List<String>> getHeaders();

    T getBody();

    Optional<SSLSession> sslSession();

    String uri();

}
