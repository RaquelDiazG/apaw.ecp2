package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController2;
import es.upm.miw.apaw.rest.business.views.TransferObject1;
import es.upm.miw.apaw.rest.business.views.TransferObject2;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ErrorPresenter {

    public String process(Model model) {
        model.put("log", "UI3Presenter:process");
        return "UI3View";
    }

    public String action2(Model model) {
        model.put("log", "UI3Presenter:action2");
        new BusinessController2().m2(new TransferObject1());
        return "UI3View";
    }
    
    public String action3(Model model) {
        model.put("log", "UI3Presenter:action3");
        TransferObject2 transferObject2 = new BusinessController2().m1();
        model.put("transferObject2", transferObject2);
        return "UI3View";
    }

}
