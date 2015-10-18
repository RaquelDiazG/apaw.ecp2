package es.upm.miw.apaw;

import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;

public class Client {

    public HttpResponse send(HttpRequest request) {
        return new Server().send(request);
    }

}
