package io.goovy.portfolioapp.gui.main;

import io.goovy.portfolioapp.gui.scope.MenuScope;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ScopeProvider;
import de.saxsys.mvvmfx.ViewModel;

@ScopeProvider(scopes = {MenuScope.class})
public class MainViewModel implements ViewModel {
    public static final String SIDE_PANE = "Show/Hide side pane";

    @InjectScope
    MenuScope menuScope;

    public void initialize() {
        menuScope.subscribe(MenuScope.SIDE_PANE, (k,v) -> publish(SIDE_PANE));
    }
}