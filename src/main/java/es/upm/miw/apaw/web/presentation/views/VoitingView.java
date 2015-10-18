package es.upm.miw.apaw.web.presentation.views;

import es.upm.miw.apaw.web.presentation.models.Model;

public class VoitingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("UI1View");
        System.out.println("   " + model.get("log"));
    }

}
