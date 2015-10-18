package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    private BusinessController businessController = new BusinessController();

    public String process(Model model) {
        model.put("themes", businessController.getAll());
        return "VotingView";
    }

    public String voteTheme(Model model) {
        int id = businessController.nextIdValue();
        String name = model.get("themeName").toString();
        int value = new Integer(model.get("value").toString());
        Theme theme = businessController.getTheme(name);
        Vote vote = new Vote(id, value, theme);
        new BusinessController().vote(vote);
        model.put("themes", businessController.getAll());
        return "VotingView";
    }

    public String themeManager(Model model) {
        return "ThemeManagerView";
    }

}
