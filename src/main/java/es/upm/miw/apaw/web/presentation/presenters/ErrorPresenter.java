package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.web.presentation.models.Model;

public class ErrorPresenter {

    public String process(Model model) {
        return "ErrorView";
    }

    public String voting(Model model) {
        return "VotingView";
    }

}
