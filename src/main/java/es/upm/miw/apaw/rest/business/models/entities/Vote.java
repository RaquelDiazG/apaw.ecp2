package es.upm.miw.apaw.rest.business.models.entities;

public class Vote {

    private int id;

    private int vote;

    private Theme theme;

    public Vote() {
    }

    public Vote(int id, int vote, Theme theme) {
        this.id = id;
        this.vote = vote;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public int getVote() {
        return vote;
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Vote [id=" + id + ", vote=" + vote + ", theme=" + theme + "]";
    }

}
