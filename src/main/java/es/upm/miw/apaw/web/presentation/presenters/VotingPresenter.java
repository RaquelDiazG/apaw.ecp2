package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerTheme;
import es.upm.miw.apaw.rest.business.controllers.BusinessControllerVote;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    private BusinessControllerTheme businessControllerTheme = new BusinessControllerTheme();

    private BusinessControllerVote businessControllerVote = new BusinessControllerVote();

    public String process(Model model) {
        model.put("themes", businessControllerVote.getAllVotings());
        return "VotingView";
    }

    public String voteTheme(Model model) {
        int id = businessControllerVote.nextIdVote();
        String name = model.get("themeName").toString();
        int value = new Integer(model.get("value").toString());
        Theme theme = businessControllerTheme.getTheme(name);
        Vote vote = new Vote(id, value, theme);
        businessControllerVote.voteTheme(vote);
        model.put("themes", businessControllerVote.getAllVotings());
        return "VotingView";
    }

    public String themeManager(Model model) {
        model.put("themes", businessControllerTheme.getAllThemes());
        return "ThemeManagerView";
    }

}
