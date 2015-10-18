package es.upm.miw.apaw.rest.business.controllers;

import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;
import es.upm.miw.apaw.rest.business.views.TransferObjectTheme;
import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;

public class BusinessControllerThemeManager {

    public TransferObjectTheme getAll() {
        List<String> themes = DaoFactory.getFactory().getThemeDao().findAllNames();
        return new TransferObjectTheme(themes);
    }

    public void create(Theme theme) {
        System.out.println(DaoFactory.getFactory());
        DaoFactory.getFactory().getThemeDao().create(theme);
    }

    public int nextId() {
        return DaoFactory.getFactory().getThemeDao().findAll().size();
    }
}
