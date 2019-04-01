package io.goovy.portfolioapp.gui.material_navigation;

import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ScopeProvider;
import de.saxsys.mvvmfx.ViewModel;
import io.goovy.portfolioapp.gui.scope.MenuScope;

@ScopeProvider(scopes = {MenuScope.class})
public class NavigationViewModel implements ViewModel {

    // List of tabs
    public static final String DASHBOARD = "Dashboard";
    public static final String PORTFOLIOS = "Portfolios";
    public static final String INSTRUMENTS = "Instruments";

    @InjectScope
    private MenuScope menuScope;

    public void addMainContent(String tabType) {
        menuScope.publish(MenuScope.MAIN_CONTENT, tabType);
    }
}