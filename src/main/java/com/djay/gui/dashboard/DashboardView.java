package com.djay.gui.dashboard;

import com.jfoenix.effects.JFXDepthManager;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class DashboardView implements FxmlView<DashboardViewModel> {

    public StackPane statsPositionsPane;
    public StackPane statsInstrumentsPane;
    public Label nbActivePositionText;
    public Label nbActiveInstrumentText;

    @InjectViewModel
    DashboardViewModel viewModel;

    public void initialize() {
        // Souscrit aux messages provenant du controleur
        viewModel.subscribe(viewModel.REFRESH_DATA, (k, payload) -> {
            Integer nbInstruments = (Integer) payload[0];
            if (nbInstruments!=null) {
                refreshFromController(nbInstruments);
            }
        });

        // Effet visuel sur les panneaux de stats pour les faire resortir par defaut et les changer quand la souris passe dessus
        // pour illustrer un autre moyen de le faire qu'en css
        JFXDepthManager.setDepth(statsPositionsPane, 1);
        JFXDepthManager.setDepth(statsInstrumentsPane, 1);
        statsPositionsPane.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                changeVisualEffectPane(statsPositionsPane, 0);
            else
                changeVisualEffectPane(statsPositionsPane, 1);
        });
        statsInstrumentsPane.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                changeVisualEffectPane(statsInstrumentsPane, 0);
            else
                changeVisualEffectPane(statsInstrumentsPane, 1);
        });
    }

    private void refreshFromController(Integer nbInstruments) {
        // Le controlleur vient de notifier la vue qu'un changement a eu lieu.
        // Il est aussi possible de passer la donnée dans le contenu du message.
        nbActiveInstrumentText.setText(nbInstruments + " instruments utilisés");
    }

    public void refreshPostions(ActionEvent actionEvent) {
        nbActivePositionText.setText(viewModel.getOpenPositions());
    }

    public void refreshInstruments(ActionEvent actionEvent) {
        // Appelle le controleur pour simuler des changements de données
        viewModel.refreshInstrumentSimulation();
    }

    private void changeVisualEffectPane(StackPane pane, int level) {
        JFXDepthManager.setDepth(pane, level);
    }
}
