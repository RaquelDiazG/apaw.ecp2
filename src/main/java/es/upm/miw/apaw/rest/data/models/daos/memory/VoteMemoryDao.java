package es.upm.miw.apaw.rest.data.models.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.models.entities.Vote;
import es.upm.miw.apaw.rest.data.models.daos.VoteDao;

public class VoteMemoryDao extends GenericMemoryDao<Vote, Integer>implements VoteDao {

    public VoteMemoryDao() {
        this.setMap(new HashMap<Integer, Vote>());
    }

    @Override
    protected Integer getId(Vote entity) {
        return entity.getId();
    }

    @Override
    public List<Vote> findByTheme(Theme theme) {
        List<Vote> votes = new ArrayList<>();
        List<Vote> votesAll = this.findAll();
        for (Vote vote : votesAll) {
            if (theme.equals(vote.getTheme())) {
                votes.add(vote);
            }
        }
        return votes;
    }

    @Override
    public double averageVotes(Theme theme) {
        double sum = 0;
        List<Vote> votesTheme = this.findByTheme(theme);
        for (Vote vote : votesTheme) {
            sum += vote.getVote();
        }
        double average = sum / votesTheme.size();
        return average;
    }

}
