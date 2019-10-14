package com.djay.gui.menu;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.inject.Inject;

public class MenuView implements FxmlView<MenuViewModel> {

    @InjectViewModel
    private MenuViewModel menuViewModel;

    @Inject
    Stage primaryStage;


    public void quit(ActionEvent actionEvent) {
        primaryStage.close();
    }

    public void about(ActionEvent actionEvent) {
    }
}
