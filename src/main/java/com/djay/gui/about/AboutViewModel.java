package com.djay.gui.about;

import com.djay.App;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AboutViewModel implements ViewModel {
    private StringProperty versionNumber = new SimpleStringProperty();
    private StringProperty buildDate = new SimpleStringProperty();

    public void initialize() {
        versionNumber.setValue("Version: " + App.APP_VERSION);
        buildDate.setValue("Build: " + App.APP_BUILD);
    }

    public StringProperty versionNumberProperty() {
        return  versionNumber;
    }

    public StringProperty buildDateProperty() {
        return buildDate;
    }
}