package es.upm.miw.apaw.web.presentation.frontController;

import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;

public class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        dispatcher = new Dispatcher();
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        dispatcher.doGet(request, response);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        dispatcher.doPost(request, response);
    }

}
