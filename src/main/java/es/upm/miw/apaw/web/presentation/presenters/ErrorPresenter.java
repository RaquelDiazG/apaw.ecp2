package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController2;
import es.upm.miw.apaw.rest.business.views.TransferObject1;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ErrorPresenter {

    public String process(Model model) {
        model.put("log", "ErrorPresenter:process");
        return "ErrorView";
    }

    public String voiting(Model model) {
        model.put("log", "ErrorPresenter:voiting");
        new BusinessController2().m2(new TransferObject1());
        return "ErrorView";
    }

}
