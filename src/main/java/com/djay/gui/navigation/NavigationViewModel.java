package com.djay.gui.navigation;

import com.google.inject.Inject;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;

public class NavigationViewModel implements ViewModel {
    @Inject
    private NotificationCenter notificationCenter;

    public static final String MAIN_CONTENT = "ADD TAB IN MAIN CONTENT";

    public static final String DASHBOARD = "Dashboard";
    public static final String PORTFOLIOS = "Portfolios";
    public static final String INSTRUMENTS = "Instruments";

    public void addMainContent(String tabType) {
        notificationCenter.publish(MAIN_CONTENT, tabType);
    }
}
