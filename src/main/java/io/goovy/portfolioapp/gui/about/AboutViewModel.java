package io.goovy.portfolioapp.gui.about;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AboutViewModel implements ViewModel {
    private StringProperty versionNumber = new SimpleStringProperty();

    public void initialize() {
        versionNumber.setValue("Version: 1.0.0");
    }

    public StringProperty versionNumberProperty() {
        return  versionNumber;
    }
}