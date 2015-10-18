package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController1;
import es.upm.miw.apaw.rest.business.views.TransferObject2;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VoitingPresenter {

    public String process(Model model) {
        model.put("log", "UI1Presenter:process");
        return "UI1View";
    }

    public String login(Model model) {
        model.put("log", "UI1Presenter:login");
        new BusinessController1().m2(new TransferObject2());
        return "UI1View";
    }

    public String logout(Model model) {
        model.put("log", "UI1Presenter:logout");
        new BusinessController1().m2(new TransferObject2());
        return "UI1View";
    }

}
