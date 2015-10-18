package es.upm.miw.apaw.web.presentation.frontController;

import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.http.HttpResponse;
import es.upm.miw.apaw.web.presentation.models.Model;
import es.upm.miw.apaw.web.presentation.presenters.ErrorPresenter;
import es.upm.miw.apaw.web.presentation.presenters.ThemeManagerPresenter;
import es.upm.miw.apaw.web.presentation.presenters.VoitingPresenter;
import es.upm.miw.apaw.web.presentation.views.ErrorView;
import es.upm.miw.apaw.web.presentation.views.ThemeManagerView;
import es.upm.miw.apaw.web.presentation.views.View;
import es.upm.miw.apaw.web.presentation.views.VoitingView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String presenter = request.getPath() + "Presenter";
        String nextView = request.getPath() + "View";

        switch (presenter) {
        case "UI1Presenter":
            VoitingPresenter uI1Presenter = new VoitingPresenter();
            nextView = uI1Presenter.process(model);
            break;
        case "UI2Presenter":
            ThemeManagerPresenter uI2Presenter = new ThemeManagerPresenter();
            nextView = uI2Presenter.process(model);
            break;
        case "UI3Presenter":
            ErrorPresenter uI3Presenter = new ErrorPresenter();
            nextView = uI3Presenter.process(model);
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
        case "UI1Presenter":
            VoitingPresenter uI1Presenter = new VoitingPresenter();
            if ("login".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = uI1Presenter.voteTheme(model);
            } else if ("logout".equals(action)) {
                // TODO uI1Presenter.setters((request.getParams().get("param")));
                nextView = uI1Presenter.themeManager(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "UI2Presenter":
            ThemeManagerPresenter uI2Presenter = new ThemeManagerPresenter();
            if ("action1".equals(action)) {
                // TODO uI2Presenter.setters((request.getParams().get("param")));
                nextView = uI2Presenter.createTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "UI3Presenter":
            ErrorPresenter uI3Presenter = new ErrorPresenter();
            if ("action2".equals(action)) {
                // TODO uI3Presenter.setters((request.getParams().get("param")));
                nextView = uI3Presenter.action2(model);
            } else if ("action3".equals(action)) {
                // TODO uI3Presenter.setters((request.getParams().get("param")));
                nextView = uI3Presenter.action3(model);
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
        case "UI1View":
            view = new VoitingView();
            break;
        case "UI2View":
            view = new UI2View();
            break;
        case "UI3View":
            view = new ThemeManagerView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
