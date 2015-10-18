package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerThemeManager;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ThemeManagerPresenter {

    public String process(Model model) {
        model.put("themes", new BusinessControllerThemeManager().getAll());
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        int id = new BusinessControllerThemeManager().nextId();
        String name = model.get("themeName").toString();
        Theme theme = new Theme(id, name);
        new BusinessControllerThemeManager().create(theme);
        model.put("themes", new BusinessControllerThemeManager().getAll());
        return "ThemeManagerView";
    }

    public String voting(Model model) {
        return "VotingView";
    }

}
