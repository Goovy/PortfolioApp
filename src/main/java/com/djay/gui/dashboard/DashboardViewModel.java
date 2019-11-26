package com.djay.gui.dashboard;

import de.saxsys.mvvmfx.ViewModel;

import java.util.Random;

public class DashboardViewModel implements ViewModel {

    public static String REFRESH_DATA = "Refresh data message";

    public void refreshInstrumentSimulation() {
        // Nous simulons par l'appel à cette methode un traitement long
        // Une fois terminé, nous envoyons une notification à la vue
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publish(REFRESH_DATA, new Random().nextInt(100) + 10);
    }

    public String getOpenPositions() {
        Integer simulatedNb = new Random().nextInt(20);
        return simulatedNb + " positions actives.";
    }
}
