package io.goovy.portfolioapp.gui.main;

import com.jfoenix.controls.JFXDrawer;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import io.goovy.portfolioapp.gui.main_content.ContentView;
import io.goovy.portfolioapp.gui.material_navigation.NavigationView;

public class MainView implements FxmlView<MainViewModel> {

    public JFXDrawer drawer;

    @InjectViewModel
    private MainViewModel viewModel;

    public void initialize() {
        final ViewTuple navigationView = FluentViewLoader.fxmlView(NavigationView.class).load();
        drawer.setSidePane(navigationView.getView());
        drawer.setOverLayVisible(false);
        // traitement des messages du controller
        viewModel.subscribe(MainViewModel.SIDE_PANE, (k,v) -> openCloseSidePane());
        // Affichage du conteneur qui contient le contenu ou aussi appelé contenant
        final ViewTuple contentView = FluentViewLoader.fxmlView(ContentView.class).load();
        drawer.setContent(contentView.getView());
    }

    private void openCloseSidePane() {
        if (drawer.isClosed() || drawer.isClosing()) {
            drawer.open();
        } else {
            drawer.close();
        }
    }
}