package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerThemeManager;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        model.put("themes", new BusinessControllerThemeManager().getAll());
        return "VotingView";
    }

    public String voteTheme(Model model) {
        // TO-DO
        return "VotingView";
    }

    public String themeManager(Model model) {
        return "ThemeManagerView";
    }

}
