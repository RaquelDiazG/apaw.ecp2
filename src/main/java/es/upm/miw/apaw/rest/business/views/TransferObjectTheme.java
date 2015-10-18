package es.upm.miw.apaw.rest.business.views;

import java.util.List;

public class TransferObjectTheme {

    private List<String> listThemes;

    public TransferObjectTheme(List<String> themes) {
        listThemes = themes;
    }

    @Override
    public String toString() {
        return listThemes.toString();
    }

}
