package es.upm.miw.apaw.rest.data.models.daos;

import java.util.List;

import es.upm.miw.apaw.rest.business.models.entities.Theme;

public interface ThemeDao extends GenericDao<Theme, Integer> {

    public Theme findByName(String name);

    public List<String> findAllNames();
}
