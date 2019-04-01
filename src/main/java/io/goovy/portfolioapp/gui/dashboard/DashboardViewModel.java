package io.goovy.portfolioapp.gui.dashboard;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DashboardViewModel implements ViewModel {

    private IntegerProperty nbActivePortfolioProperty = new SimpleIntegerProperty();

    public static final String REFRESH_DATA = "refresh the view";

    public void initialize() {
    }

    public IntegerProperty getNbActivePortfolioProperty() {
        nbActivePortfolioProperty.set((int) (Math.random()*10));
        return nbActivePortfolioProperty; }

    public void refresh02() {
        publish(REFRESH_DATA);
    }
}