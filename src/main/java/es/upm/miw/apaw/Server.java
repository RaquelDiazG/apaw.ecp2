package es.upm.miw.apaw;

import es.upm.miw.apaw.http.HttpMethod;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;
import es.upm.miw.apaw.http.HttpStatus;
import es.upm.miw.apaw.web.presentation.frontController.FrontController;

public class Server {

    public HttpResponse send(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        if (HttpMethod.GET.equals(request.getMethod())) {
            new FrontController().doGet(request, response);
        } else if (HttpMethod.POST.equals(request.getMethod())) {
            new FrontController().doPost(request, response);
        }
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
