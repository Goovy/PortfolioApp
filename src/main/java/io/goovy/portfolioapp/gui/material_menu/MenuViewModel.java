package io.goovy.portfolioapp.gui.material_menu;

import com.google.common.eventbus.Subscribe;
import de.saxsys.mvvmfx.InjectScope;
import de.saxsys.mvvmfx.ViewModel;
import io.goovy.portfolioapp.App;
import io.goovy.portfolioapp.gui.scope.MenuScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuViewModel implements ViewModel {
    private static final Logger LOG = LoggerFactory.getLogger(MenuViewModel.class);

    public static final String SHOW_HIDE_MENU = "ShowHide_Navigation_Menu";

    @InjectScope
    MenuScope menuScope;

    public void initialize() {
        // On souscrit aux notifications de la touche Alt
        App.getKeyEventBus().register(this);
    }

    public void notifyShowHideSidePane() {
        menuScope.publish(MenuScope.SIDE_PANE);
    }

    @Subscribe
    public void altKeyPressedEvent(String event) {
        if (event.equals("AltKeyPressed")) {
            LOG.debug("Received event Alt key pressed");
            publish(SHOW_HIDE_MENU);
        }
    }
}