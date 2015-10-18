package es.upm.miw.apaw.rest.business.controllers;

import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;

public class BusinessControllerTheme {

    public List<String> getAllThemes() {
        return DaoFactory.getFactory().getThemeDao().findAllNames();
    }

    public void createTheme(Theme theme) {
        DaoFactory.getFactory().getThemeDao().create(theme);
    }

    public int nextIdTheme() {
        return DaoFactory.getFactory().getThemeDao().findAll().size();
    }

    public Theme getTheme(String name) {
        return DaoFactory.getFactory().getThemeDao().findByName(name);
    }

}
