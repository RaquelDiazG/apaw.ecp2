package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ErrorPresenter {

    private BusinessController businessController = new BusinessController();

    public String process(Model model) {
        model.put("themes", businessController.getAllThemes());
        return "ErrorView";
    }

    public String voting(Model model) {
        model.put("themes", businessController.getAllVotings());
        return "VotingView";
    }

}
