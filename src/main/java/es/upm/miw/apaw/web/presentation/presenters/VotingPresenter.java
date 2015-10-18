package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController1;
import es.upm.miw.apaw.rest.business.views.TransferObject2;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        model.put("log", "VotingPresenter:process");
        return "VotingView";
    }

    public String voteTheme(Model model) {
        model.put("log", "VotingPresenter:voteTheme");
        new BusinessController1().m2(new TransferObject2());
        return "VotingView";
    }

    public String themeManager(Model model) {
        model.put("log", "VotingPresenter:themeManager");
        new BusinessController1().m2(new TransferObject2());
        return "VotingView";
    }

}
