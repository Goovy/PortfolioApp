package io.goovy.portfolioapp.gui.about;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AboutView implements FxmlView<AboutViewModel> {
    private Stage aboutDialogStage;

    public Label version;

    @InjectViewModel
    private AboutViewModel viewModel;

    public void initialize() {
        version.textProperty().bind(viewModel.versionNumberProperty());
    }

    public void setStage(Stage dialogStage) {
        this.aboutDialogStage = dialogStage;
    }

    public void close(ActionEvent actionEvent) {
        aboutDialogStage.close();
    }
}