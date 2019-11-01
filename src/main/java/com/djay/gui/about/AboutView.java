package com.djay.gui.about;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.inject.Inject;

public class AboutView implements FxmlView<AboutViewModel> {

    public Label version;
    public Label build;
    private Stage aboutDialog;

    @InjectViewModel
    private AboutViewModel viewModel;

    public void initialize() {
        version.textProperty().bindBidirectional(viewModel.versionNumberProperty());
        build.textProperty().bindBidirectional(viewModel.buildDateProperty());
    }

    public void close() {
        aboutDialog.close();
    }

    public void setStage(Stage dialogStage) {
        this.aboutDialog = dialogStage;
    }
}
