package es.upm.miw.apaw.rest.business.views;

public class ThemeTransfer {

    private String themeName;

    private double average;

    public ThemeTransfer(String themeName, double average) {
        this.themeName = themeName;
        this.average = average;
    }

    @Override
    public String toString() {
        return "ThemeTransfer [themeName=" + themeName + ", average=" + average + "]";
    }

}
