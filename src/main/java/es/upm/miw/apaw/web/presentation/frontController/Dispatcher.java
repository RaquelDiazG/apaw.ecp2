package es.upm.miw.apaw.web.presentation.frontController;

import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;
import es.upm.miw.apaw.web.presentation.models.Model;
import es.upm.miw.apaw.web.presentation.presenters.ErrorPresenter;
import es.upm.miw.apaw.web.presentation.presenters.ThemeManagerPresenter;
import es.upm.miw.apaw.web.presentation.presenters.VotingPresenter;
import es.upm.miw.apaw.web.presentation.views.ErrorView;
import es.upm.miw.apaw.web.presentation.views.ThemeManagerView;
import es.upm.miw.apaw.web.presentation.views.View;
import es.upm.miw.apaw.web.presentation.views.VotingView;

public class Dispatcher {

    private static final String VOTING_PRESENTER = "VotingPresenter";

    private static final String THEME_MANAGER_PRESENTER = "ThemeManagerPresenter";

    private static final String ERROR_PRESENTER = "ErrorPresenter";

    private static final String VOTING_VIEW = "VotingView";

    private static final String THEME_MANAGER_VIEW = "ThemeManagerView";

    private static final String ERROR_VIEW = "ErrorView";

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case VOTING_PRESENTER:
            VotingPresenter votingPresenter = new VotingPresenter();
            nextView = votingPresenter.process(model);
            break;
        case THEME_MANAGER_PRESENTER:
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            nextView = themeManagerPresenter.process(model);
            break;
        case ERROR_PRESENTER:
            ErrorPresenter errorPresenter = new ErrorPresenter();
            nextView = errorPresenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String controller = request.getPath() + "Presenter";
        String action = request.getParams().get("action");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case VOTING_PRESENTER:
            VotingPresenter votingPresenter = new VotingPresenter();
            if ("voteTheme".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = votingPresenter.voteTheme(model);
            } else if ("themeManager".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = votingPresenter.themeManager(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case THEME_MANAGER_PRESENTER:
            ThemeManagerPresenter themeManagerPresenter = new ThemeManagerPresenter();
            if ("createTheme".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = themeManagerPresenter.createTheme(model);
            } else if ("voting".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = themeManagerPresenter.voting(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case ERROR_PRESENTER:
            ErrorPresenter ErrorPresenter = new ErrorPresenter();
            if ("voting".equals(action)) {
                // TODO uI3Presenter.setters((request.getParams().get("param")));
                nextView = ErrorPresenter.voting(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }

    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case VOTING_VIEW:
            view = new VotingView();
            break;
        case THEME_MANAGER_VIEW:
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
