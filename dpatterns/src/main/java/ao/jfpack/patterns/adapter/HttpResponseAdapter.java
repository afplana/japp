package ao.jfpack.patterns.adapter;

import ao.jfpack.patterns.common.Response;

import javax.net.ssl.SSLSession;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class HttpResponseAdapter<T> implements Response<T> {

    private final HttpResponse<T> response;

    public HttpResponseAdapter(HttpResponse<T> response) {
        this.response = response;
    }

    public int statusCode() {
        return response.statusCode();
    }

    public Map<String, List<String>> getHeaders() {
        return response.headers().map();
    }

    public T getBody() {
        return response.body();
    }


    public Optional<SSLSession> sslSession() {
        return response.sslSession();
    }

    public String uri() {
        return response.uri().toString();
    }
}
