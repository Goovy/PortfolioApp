package com.djay.gui;

import com.djay.gui.dashboard.DashboardView;
import com.jfoenix.controls.JFXTabPane;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.control.Tab;

public class MainView implements FxmlView<MainViewModel> {
    public JFXTabPane tabPane;

    public void initialize() {
        final ViewTuple dashboard = FluentViewLoader.fxmlView(DashboardView.class).load();
        tabPane.getTabs().add(new Tab("Dashboard", dashboard.getView()));
    }
}
