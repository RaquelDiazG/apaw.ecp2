package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerTheme;
import es.upm.miw.apaw.rest.business.controllers.BusinessControllerVote;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ThemeManagerPresenter {

    private BusinessControllerTheme businessControllerTheme = new BusinessControllerTheme();

    private BusinessControllerVote businessControllerVote = new BusinessControllerVote();

    public String process(Model model) {
        model.put("themes", businessControllerTheme.getAllThemes());
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        int id = businessControllerTheme.nextIdTheme();
        String name = model.get("themeName").toString();
        Theme theme = new Theme(id, name);
        businessControllerTheme.createTheme(theme);
        model.put("themes", businessControllerTheme.getAllThemes());
        return "ThemeManagerView";
    }

    public String voting(Model model) {
        model.put("themes", businessControllerVote.getAllVotings());
        return "VotingView";
    }

}
