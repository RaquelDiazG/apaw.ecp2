package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerTheme;
import es.upm.miw.apaw.rest.business.controllers.BusinessControllerVote;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ErrorPresenter {

    private BusinessControllerTheme businessControllerTheme = new BusinessControllerTheme();

    private BusinessControllerVote businessControllerVote = new BusinessControllerVote();

    public String process(Model model) {
        model.put("themes", businessControllerTheme.getAllThemes());
        return "ErrorView";
    }

    public String voting(Model model) {
        model.put("themes", businessControllerVote.getAllVotings());
        return "VotingView";
    }

}
