package io.goovy.portfolioapp.gui.main_content;

import com.jfoenix.controls.JFXTabPane;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import io.goovy.portfolioapp.gui.dashboard.DashboardView;
import javafx.application.Platform;
import javafx.scene.control.Tab;

public class ContentView implements FxmlView<ContentViewModel> {

    public JFXTabPane tabPane;

    @InjectViewModel
    private ContentViewModel viewModel;

    public void initialize() {
        // Par défaut, affiche le dashboard en tant que premier onglet
        final ViewTuple dashboard = FluentViewLoader.fxmlView(DashboardView.class).load();
        tabPane.getTabs().add(new Tab("Dashboard", dashboard.getView()));
    }

    public void addTab() {
        tabPane.getTabs().add(null);
    }
}