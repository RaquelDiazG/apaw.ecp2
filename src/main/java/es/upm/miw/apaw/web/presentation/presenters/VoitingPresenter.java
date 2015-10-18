package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController1;
import es.upm.miw.apaw.rest.business.views.TransferObject2;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VoitingPresenter {

    public String process(Model model) {
        model.put("log", "VoitingPresenter:process");
        return "VoitingView";
    }

    public String voteTheme(Model model) {
        model.put("log", "VoitingPresenter:voteTheme");
        new BusinessController1().m2(new TransferObject2());
        return "VoitingView";
    }

    public String themeManager(Model model) {
        model.put("log", "UI1Presenter:themeManager");
        new BusinessController1().m2(new TransferObject2());
        return "UI1VVoitingViewiew";
    }

}
