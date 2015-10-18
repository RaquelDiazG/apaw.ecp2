package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerThemeManager;
import es.upm.miw.apaw.rest.business.views.TransferObjectVoting;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ErrorPresenter {

    public String process(Model model) {
        model.put("log", "ErrorPresenter:process");
        return "ErrorView";
    }

    public String voting(Model model) {
        model.put("log", "ErrorPresenter:voting");
        new BusinessControllerThemeManager().m2(new TransferObjectVoting());
        return "ErrorView";
    }

}
