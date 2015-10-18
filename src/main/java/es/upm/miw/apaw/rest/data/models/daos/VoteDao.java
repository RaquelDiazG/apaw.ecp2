package es.upm.miw.apaw.rest.data.models.daos;

import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {

    public List<Vote> findByTheme(Theme theme);
}
