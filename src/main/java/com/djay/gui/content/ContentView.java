package com.djay.gui.content;

import com.djay.gui.dashboard.DashboardView;
import com.djay.gui.instruments.InstrumentsView;
import com.djay.gui.navigation.NavigationViewModel;
import com.djay.gui.portfolios.PortfolioView;
import com.jfoenix.controls.JFXTabPane;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import sun.reflect.misc.ReflectUtil;

public class ContentView implements FxmlView<ContentViewModel> {
    public JFXTabPane tabPane;

    @InjectViewModel
    private ContentViewModel viewModel;

    public void initialize() {
        // Charge un onglet par defaut
        final ViewTuple dashboard = FluentViewLoader.fxmlView(DashboardView.class).load();
        tabPane.getTabs().add(new Tab("Dashboard", dashboard.getView()));

        // Ecoute l"evenement pour ajouter un nouvel onglet
        viewModel.subscribe(ContentViewModel.ACTION_ADD_COMPONENT, (key, payload) -> {
                    String tabType = (String) payload[0];
                    Parent tabView = null;
                    switch (tabType) {
                        case NavigationViewModel.DASHBOARD:
                            tabView = FluentViewLoader.fxmlView(DashboardView.class).load().getView();
                            break;
                        case NavigationViewModel.INSTRUMENTS:
                            tabView = FluentViewLoader.fxmlView(InstrumentsView.class).load().getView();
                            break;
                        case NavigationViewModel.PORTFOLIOS:
                            tabView = FluentViewLoader.fxmlView(PortfolioView.class).load().getView();
                            break;
                    }
                    if (tabView!=null) {
                        Parent finalTabView = tabView;
                        Platform.runLater(()-> {
                            Tab newTab = new Tab(tabType, finalTabView);
                            tabPane.getTabs().add(newTab);
                            tabPane.getSelectionModel().select(newTab);
                        });
                    }
                }
        );
    }
}
