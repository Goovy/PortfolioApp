package io.goovy.portfolioapp;

import com.google.common.eventbus.EventBus;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.svg.SVGGlyph;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.MvvmFX;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.guice.MvvmfxGuiceApplication;
import io.goovy.portfolioapp.gui.main.MainView;
import io.goovy.portfolioapp.gui.main.MainViewModel;
import io.goovy.portfolioapp.service.KeyListener;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;
import java.util.logging.Level;

/**
 * Entry point of the application
 */
public class App extends MvvmfxGuiceApplication {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    // EventBus using Guava
    private static EventBus eventBus = new EventBus("Key_Pressed_event_bus");

    public static EventBus getKeyEventBus() {
        return eventBus;
    }

    public static void main (String[] args) {
        launch(args);
    }

    /**
     * Start the key listener to fire event when the Alt key is pressed
     */
    private static void startKeyListener() {
        // Get the logger for "org.jnativehook" and set the level to off.
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            LOG.error("The key listener could not be initialized.");
            LOG.error(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyListener());
    }

    @Override
    public void initMvvmfx() throws Exception {

    }

    @Override
    public void startMvvmfx(Stage stage) throws Exception {
        LOG.debug("L'application démarre!");

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

        startKeyListener();
    }

    @Override
    public void stopMvvmfx() throws Exception {
        System.exit(1);
    }
}
