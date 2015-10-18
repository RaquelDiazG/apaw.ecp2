package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessController;
import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.web.presentation.models.Model;

public class ThemeManagerPresenter {

    private BusinessController businessController = new BusinessController();

    public String process(Model model) {
        model.put("themes", businessController.getAll());
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        int id = businessController.nextId();
        String name = model.get("themeName").toString();
        Theme theme = new Theme(id, name);
        businessController.create(theme);
        model.put("themes", businessController.getAll());
        return "ThemeManagerView";
    }

    public String voting(Model model) {
        return "VotingView";
    }

}
