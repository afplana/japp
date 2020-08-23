package ao.jfpack.patterns.adapter;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;


public abstract class HttpResponseImpl<T> implements HttpResponse<T> {

    // Todo: implements methods to handle this params
    int statusCode;
    HttpRequest httpRequest;
    T body;
    HttpHeaders headers;
    URI uri;
    HttpClient client;

    public HttpResponseImpl(HttpRequest httpRequest, HttpHeaders headers, HttpClient client, URI uri) {
        this.httpRequest = httpRequest;
        this.headers = headers;
        this.client = client;
        this.uri = uri == null ? URI.create("http://localhost"): null;
        this.body = null;
        this.statusCode = 200;
    }

    public HttpResponseImpl() {
        this(null, null, null, null);
    }


    @Override
    public int statusCode() {
        return statusCode;
    }

    @Override
    public HttpRequest request() {
        return httpRequest;
    }

    @Override
    public Optional<HttpResponse<T>> previousResponse() {
        return Optional.empty();
    }

    @Override
    public HttpHeaders headers() {
        return headers;
    }

    @Override
    public T body() {
        return body;
    }

    @Override
    public Optional<SSLSession> sslSession() {
        return Optional.empty();
    }

    @Override
    public URI uri() {
        return uri;
    }

    @Override
    public HttpClient.Version version() {
        return client.version();
    }
}
