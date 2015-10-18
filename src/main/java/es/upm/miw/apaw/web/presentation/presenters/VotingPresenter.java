package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerThemeManager;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        model.put("themes", new BusinessControllerThemeManager().getAll());
        return "VotingView";
    }

    public String voteTheme(Model model) {
        int id = new BusinessControllerThemeManager().nextIdValue();
        String name = model.get("themeName").toString();
        int value = new Integer(model.get("value").toString());
        Theme theme = new BusinessControllerThemeManager().getTheme(name);
        Vote vote = new Vote(id, value, theme);
        new BusinessControllerThemeManager().vote(vote);
        model.put("themes", new BusinessControllerThemeManager().getAll());
        return "VotingView";
    }

    public String themeManager(Model model) {
        return "ThemeManagerView";
    }

}
