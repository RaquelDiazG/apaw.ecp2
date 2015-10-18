package es.upm.miw.apaw.web.presentation.presenters;

import es.upm.miw.apaw.rest.business.controllers.BusinessControllerThemeManager;
import es.upm.miw.apaw.rest.business.controllers.BusinessControllerVoiting;
import es.upm.miw.apaw.rest.business.views.TransferObjectTheme;
import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        // model.put("log", "VotingPresenter:process");
        model.put("themes", new BusinessControllerThemeManager().getAll());
        return "VotingView";
    }

    public String voteTheme(Model model) {
        model.put("log", "VotingPresenter:voteTheme");
        new BusinessControllerVoiting().m2(new TransferObjectTheme());
        return "VotingView";
    }

    public String themeManager(Model model) {
        model.put("log", "VotingPresenter:themeManager");
        new BusinessControllerVoiting().m2(new TransferObjectTheme());
        return "VotingView";
    }

}
