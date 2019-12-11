package com.djay.gui.menu;

import com.djay.gui.scope.MenuScope;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;

public class MenuViewModel implements ViewModel {

    @InjectScope
    MenuScope menuScope;

    public void notifyShowHideSidePane() {
        menuScope.publish(MenuScope.SIDE_PANE);
    }
}
