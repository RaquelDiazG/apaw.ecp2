package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController2;
import es.upm.miw.apaw.rest.business.views.TransferObject2;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ThemeManagerPresenter {

    public String process(Model model) {
        model.put("log", "UI2Presenter:process");
        return "UI2View";
    }

    public String action1(Model model) {
        model.put("log", "UI2Presenter:action1");
        TransferObject2 transferObject2 = new BusinessController2().m1();
        model.put("transferObject2", transferObject2);
        return "UI2View";
    }

}
