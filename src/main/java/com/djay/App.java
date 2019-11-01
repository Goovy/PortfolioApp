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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App extends MvvmfxGuiceApplication {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static String APP_VERSION = GetAppVersion();
    public static String APP_BUILD = GetAppBuild();

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

    /**
     * Lit le numéro de version de l'application
     *
     * @return le numéro de version
     */
    private static String GetAppVersion() {
        return getDataFromVersionFileAtLine(1).split("=")[1];
    }

    private static String GetAppBuild() {
        return getDataFromVersionFileAtLine(2).split("=")[1];
    }

    /**
     * Extrait les données de version de l'application depuis le fichier version.txt
     * @param nbLine numéro de ligne dans le fichier
     * @return la donnée du fichier
     */
    private static String getDataFromVersionFileAtLine(int nbLine) {
        InputStream in = App.class.getClassLoader().getResourceAsStream("version.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            int i=1;
            while (((line = br.readLine()) != null) && (i<nbLine)) {
                i++;
            }
            if (i==nbLine) {
                return line;
            }
        } catch (IOException e) {
            LOG.error("La lecture des données dans le fichier version.txt a échoué.");
        }
        return "-=-";
    }
}
