package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    private BusinessController businessController = new BusinessController();

    public String process(Model model) {
        model.put("themes", businessController.getAllVotings());
        return "VotingView";
    }

    public String voteTheme(Model model) {
        int id = businessController.nextIdVote();
        String name = model.get("themeName").toString();
        int value = new Integer(model.get("value").toString());
        Theme theme = businessController.getTheme(name);
        Vote vote = new Vote(id, value, theme);
        businessController.voteTheme(vote);
        model.put("themes", businessController.getAllVotings());
        return "VotingView";
    }

    public String themeManager(Model model) {
        return "ThemeManagerView";
    }

}
