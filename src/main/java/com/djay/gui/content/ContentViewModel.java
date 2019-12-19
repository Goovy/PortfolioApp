package com.djay.gui.content;

import com.djay.gui.navigation.NavigationViewModel;
import com.djay.gui.scope.ContentScope;
import com.djay.gui.scope.MenuScope;
import com.google.inject.Inject;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ScopeProvider;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.notifications.NotificationCenter;

public class ContentViewModel implements ViewModel {
    @Inject
    NotificationCenter notificationCenter;

    public static final String ACTION_ADD_COMPONENT ="Add component in the view";

    public void initialize() {
        notificationCenter.subscribe(NavigationViewModel.MAIN_CONTENT, (k, v) -> {
            if (v.length==1 && v[0] instanceof String) {
                String tabType = (String) v[0];
                addTab(tabType);
            }
        });
    }

    private void addTab(String tabType) {
        publish(ACTION_ADD_COMPONENT, tabType);
    }
}
