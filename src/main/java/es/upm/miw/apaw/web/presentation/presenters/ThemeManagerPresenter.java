package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController2;
import es.upm.miw.apaw.rest.business.views.TransferObject2;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ThemeManagerPresenter {

    public String process(Model model) {
        model.put("log", "ThemeManagerPresenter:process");
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        model.put("log", "ThemeManagerPresenter:createTheme");
        TransferObject2 transferObject2 = new BusinessController2().m1();
        model.put("transferObject2", transferObject2);
        return "ThemeManagerView";
    }

    public String voting(Model model) {
        model.put("log", "ThemeManagerPresenter:voting");
        TransferObject2 transferObject2 = new BusinessController2().m1();
        model.put("transferObject2", transferObject2);
        return "ThemeManagerView";
    }

}
