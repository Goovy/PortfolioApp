package com.djay.gui;

import com.djay.gui.scope.MenuScope;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ScopeProvider;
import de.saxsys.mvvmfx.ViewModel;

@ScopeProvider(scopes = {MenuScope.class})
public class MainViewModel implements ViewModel {

    @InjectScope
    MenuScope menuScope;

    public static final String SIDE_PANE = "Show/Hide side pane";

    public void initialize() {
        menuScope.subscribe(MenuScope.SIDE_PANE, (k,v) -> publish(SIDE_PANE));
    }

}
