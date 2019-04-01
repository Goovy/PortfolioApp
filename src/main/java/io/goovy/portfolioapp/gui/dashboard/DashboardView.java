package io.goovy.portfolioapp.gui.dashboard;

import com.jfoenix.effects.JFXDepthManager;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DashboardView implements FxmlView<DashboardViewModel> {

    public StackPane stat01Pane;
    public Label nbActivePortfolioText;

    @InjectViewModel
    private DashboardViewModel viewModel;

    public void initialize() {
        JFXDepthManager.setDepth(stat01Pane, 1);
        viewModel.subscribe(viewModel.REFRESH_DATA, (k, payload) -> refreshFromController());
    }


    /**
     * Refresh le nombre de portfolios actifs par appel de la vue au controlleur
     * @param actionEvent
     */
    public void refresh01(ActionEvent actionEvent) {
        nbActivePortfolioText.setText(viewModel.getNbActivePortfolioProperty().get() + " portefeuilles actifs.");
    }

    public void refresh02(ActionEvent actionEvent) {
        viewModel.refresh02();
    }

    /**
     * Refresh le nombre de portfolios par notification du controlleur
     */
    private void refreshFromController() {
        nbActivePortfolioText.setText(viewModel.getNbActivePortfolioProperty().get() + " portefeuilles actifs.\n(Depuis le controlleur)");
    }
}