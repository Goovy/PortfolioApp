package io.goovy.portfolioapp.gui.dashboard;

import com.jfoenix.effects.JFXDepthManager;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.scene.layout.StackPane;

public class DashboardView implements FxmlView<DashboardViewModel> {

    public StackPane stat01Pane;
    @InjectViewModel
    private DashboardViewModel viewModel;

    public void initialize() {
        JFXDepthManager.setDepth(stat01Pane, 1);
    }
}