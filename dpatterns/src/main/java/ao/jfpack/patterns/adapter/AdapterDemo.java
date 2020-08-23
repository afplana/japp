package ao.jfpack.patterns.adapter;

import ao.jfpack.patterns.common.HttpResponseImpl;
import ao.jfpack.patterns.common.Response;

public class AdapterDemo {

    public static void main(String[] args) {
        HttpResponseImpl<String> response = new HttpResponseImpl<String>() {};
        HttpResponseAdapter<String> responseAdapter = new HttpResponseAdapter<String>(response) {};

        System.out.println("Uri from response: " + getUriFromResponse(responseAdapter));
    }

    public static String getUriFromResponse(Response<String> response) {
        return response.uri();
    }
}
