package com.djay.gui.content;

import com.djay.gui.dashboard.DashboardView;
import com.jfoenix.controls.JFXTabPane;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.scene.control.Tab;

public class ContentView implements FxmlView<ContentViewModel> {

    public JFXTabPane tabPane;

    public void initialize() {
        final ViewTuple dashboard = FluentViewLoader.fxmlView(DashboardView.class).load();
        tabPane.getTabs().add(new Tab("Dashboard", dashboard.getView()));
    }
}
