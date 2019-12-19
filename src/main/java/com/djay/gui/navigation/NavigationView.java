package com.djay.gui.navigation;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewModel;
import javafx.event.ActionEvent;

public class NavigationView implements FxmlView<NavigationViewModel> {

    @InjectViewModel
    private NavigationViewModel viewModel;

    public void showDashboard() {
        viewModel.addMainContent(NavigationViewModel.DASHBOARD);
    }

    public void showPortfolios() {
        viewModel.addMainContent(NavigationViewModel.PORTFOLIOS);
    }

    public void showInstruments() {
        viewModel.addMainContent(NavigationViewModel.INSTRUMENTS);
    }
}
