package es.upm.miw.apaw.rest.business.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.rest.business.views.ThemeTransfer;
import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;

public class BusinessControllerVote {

    public int nextIdVote() {
        return DaoFactory.getFactory().getVoteDao().findAll().size();
    }

    public void voteTheme(Vote vote) {
        DaoFactory.getFactory().getVoteDao().create(vote);
    }

    public List<ThemeTransfer> getAllVotings() {
        List<ThemeTransfer> listThemeTransfer = new ArrayList<>();
        List<Theme> listThemes = DaoFactory.getFactory().getThemeDao().findAll();
        for (Theme theme : listThemes) {
            double average = DaoFactory.getFactory().getVoteDao().averageVotes(theme);
            ThemeTransfer themeTransfer = new ThemeTransfer(theme.getName(), average);
            listThemeTransfer.add(themeTransfer);
        }
        return listThemeTransfer;
    }
}
