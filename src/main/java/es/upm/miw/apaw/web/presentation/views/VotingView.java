package es.upm.miw.apaw.web.presentation.views;

import es.upm.miw.apaw.web.presentation.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.println("Voting Page");
        System.out.println("   " + model.get("log"));
    }

}
