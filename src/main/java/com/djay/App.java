package com.djay;

import com.djay.gui.MainView;
import com.djay.gui.MainViewModel;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyph;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.MvvmFX;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App extends MvvmfxGuiceApplication {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void initMvvmfx() throws Exception {

    }

    @Override
    public void startMvvmfx(javafx.stage.Stage stage) throws Exception {
        LOG.debug("L'application démarre");

        // Ajout du paquet de resources par defaut pour l'i18n
        ResourceBundle resourceBundle = ResourceBundle.getBundle("default");
        MvvmFX.setGlobalResourceBundle(resourceBundle);
        stage.setTitle(resourceBundle.getString("window.title"));

        // Ajout d'une icone d'application
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/appIcon.png")));

        // Chargement de la vue principale
        final ViewTuple<MainView, MainViewModel> main = FluentViewLoader.fxmlView(MainView.class).load();
        JFXDecorator jfxDecorator = new JFXDecorator(stage, main.getView());
        // pour ne pas cacher la barre de tache windows quand maximisé
        jfxDecorator.setCustomMaximize(true);
        // pour ajouter une icone à gauche du titre. Le SVG est défini en css par l'atttribut --fx-shape.
        jfxDecorator.setGraphic(new SVGGlyph());
        Scene rootScene = new Scene(jfxDecorator);

        // Ajout d'une feuille de style
        rootScene.getStylesheets().add("/css/material-ui.css");
        rootScene.getStylesheets().add("/css/main.css");

        stage.setScene(rootScene);
        stage.show();
    }

    @Override
    public void stopMvvmfx() throws Exception {

    }
}
