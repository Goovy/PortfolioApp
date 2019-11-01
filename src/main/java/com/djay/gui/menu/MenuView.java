package com.djay.gui.menu;

import com.djay.gui.about.AboutView;
import com.djay.gui.about.AboutViewModel;
import com.djay.util.DialogHelper;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.inject.Inject;

public class MenuView implements FxmlView<MenuViewModel> {

    @InjectViewModel
    private MenuViewModel menuViewModel;

    @Inject
    Stage primaryStage;


    public void quit() {
        primaryStage.close();
    }

    public void about() {
        ViewTuple<AboutView, AboutViewModel> aboutView = FluentViewLoader.fxmlView(AboutView.class).load();
        aboutView.getView().getStylesheets().add("/css/dialog.css");
        Stage dialogStage = DialogHelper.showDialog(aboutView.getView(), primaryStage, StageStyle.TRANSPARENT);
        aboutView.getCodeBehind().setStage(dialogStage);
    }
}
