package es.upm.miw.apaw;

import es.upm.miw.apaw.http.HttpMethod;
import es.upm.miw.apaw.http.HttpRequest;
import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;
import es.upm.miw.apaw.rest.data.models.daos.memory.DaoFactoryMemory;

public class VotingMain2 {

    public VotingMain2() {
    }

    public void voting() {
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.GET);
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void votingVoteTheme(String themeName, int value) {
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.POST);
        request.addQueryParam("action", "voteTheme");
        request.addQueryParam("themeName", themeName);
        request.addQueryParam("value", "" + value);
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void votingThemeManager() {
        HttpRequest request = new HttpRequest("LocalHost", "Voting", HttpMethod.POST);
        request.addQueryParam("action", "themeManager");
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void themeManager() {
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.GET);
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void themeManagerCreateTheme(String themeName) {
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.POST);
        request.addQueryParam("action", "createTheme");
        request.addQueryParam("themeName", themeName);
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void themeManagerVoting() {
        HttpRequest request = new HttpRequest("LocalHost", "ThemeManager", HttpMethod.POST);
        request.addQueryParam("action", "voting");
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void error() {
        HttpRequest request = new HttpRequest("LocalHost", "Error", HttpMethod.GET);
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public void errorVoting() {
        HttpRequest request = new HttpRequest("LocalHost", "Error", HttpMethod.POST);
        request.addQueryParam("action", "voting");
        System.out.println(request.toString() + "\n");

        new Client().send(request);
    }

    public static void main(String[] args) {
        DaoFactory.setFactory(new DaoFactoryMemory());
        VotingMain2 main = new VotingMain2();
        System.out.println("-------Voting--------------------------------------------------------");
        main.voting();
        System.out.println("---");
        main.votingThemeManager();
        System.out.println("-------ThemeManager--------------------------------------------------");
        main.themeManager();
        System.out.println("---");
        main.themeManagerCreateTheme("Tema1");
        System.out.println("---");
        main.themeManagerCreateTheme("Tema2");
        System.out.println("---");
        main.themeManagerVoting();
        System.out.println("-------Voting--------------------------------------------------------");
        main.votingVoteTheme("Tema1", 4);
        System.out.println("---");
        main.votingVoteTheme("Tema1", 6);
        System.out.println("---");
        main.votingVoteTheme("Tema1", 5);
        System.out.println("---");
        main.votingVoteTheme("Tema2", 5);
        System.out.println("-------Error--------------------------------------------------------");
        main.error();
        System.out.println("---");
        main.errorVoting();
    }

}
