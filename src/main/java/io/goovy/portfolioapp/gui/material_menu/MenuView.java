package io.goovy.portfolioapp.gui.material_menu;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import io.goovy.portfolioapp.gui.about.AboutView;
import io.goovy.portfolioapp.gui.about.AboutViewModel;
import io.goovy.portfolioapp.util.DialogHelper;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.inject.Inject;

public class MenuView implements FxmlView<MenuViewModel> {

    @Inject
    Stage primaryStage;

    @InjectViewModel
    private MenuViewModel viewModel;

    public MenuBar menuBar;
    public VBox menuPane;

    private boolean isMenuShowed;

    public void initialize() {
        // par défaut le menu est caché et il est affiché en appuyant sur la touche Alt
        hideMenuBar();
        viewModel.subscribe(MenuViewModel.SHOW_HIDE_MENU, (k, v) -> showHideMenuBar());
    }

    private void showHideMenuBar() {
        if (isMenuShowed) {
            hideMenuBar();
        } else {
            showMenuBar();
        }
    }

    private void showMenuBar() {
        menuPane.getChildren().add(0, menuBar);
        isMenuShowed = true;
    }

    private void hideMenuBar() {
        menuPane.getChildren().remove(menuBar);
        isMenuShowed = false;
    }

    public void quit(ActionEvent actionEvent) {
        primaryStage.close();
    }

    public void about(ActionEvent actionEvent) {
        ViewTuple<AboutView, AboutViewModel> aboutView = FluentViewLoader.fxmlView(AboutView.class).load();
        aboutView.getView().getStylesheets().add("/css/dialog.css");
        Stage dialogStage = DialogHelper.showDialog(aboutView.getView(), primaryStage, StageStyle.TRANSPARENT);
        aboutView.getCodeBehind().setStage(dialogStage);
    }

    public void hamburgerClicked(MouseEvent mouseEvent) {
        viewModel.notifyShowHideSidePane();
    }
}