package io.goovy.portfolioapp.gui.material_navigation;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;

public class NavigationView implements FxmlView<NavigationViewModel> {

    @InjectViewModel
    private NavigationViewModel viewModel;

    public void initialize() {

    }

    public void showDashboard(ActionEvent actionEvent) {
    }

    public void showPortfolios(ActionEvent actionEvent) {
    }

    public void showInstruments(ActionEvent actionEvent) {
    }
}