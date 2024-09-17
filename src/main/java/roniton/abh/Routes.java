package roniton.abh;
import org.fulib.fx.annotation.Route;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import roniton.abh.controller.MenuController;

@Singleton
public class Routes {
    @Route("menu")
    @Inject
    Provider<MenuController> menu;

    @Inject
    public Routes() {
    }
}
