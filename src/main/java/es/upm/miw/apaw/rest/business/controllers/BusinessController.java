package es.upm.miw.apaw.rest.business.controllers;

import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;

public class BusinessController {

    public List<String> getAllThemes() {
        return DaoFactory.getFactory().getThemeDao().findAllNames();
    }

    public void createTheme(Theme theme) {
        DaoFactory.getFactory().getThemeDao().create(theme);
    }

    public int nextIdTheme() {
        return DaoFactory.getFactory().getThemeDao().findAll().size();
    }

    public int nextIdVote() {
        return DaoFactory.getFactory().getVoteDao().findAll().size();
    }

    public Theme getTheme(String name) {
        return DaoFactory.getFactory().getThemeDao().findByName(name);
    }

    public void voteTheme(Vote vote) {
        DaoFactory.getFactory().getVoteDao().create(vote);
    }
}
