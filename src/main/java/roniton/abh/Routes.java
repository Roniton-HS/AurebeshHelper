package roniton.abh;
import org.fulib.fx.annotation.Route;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import roniton.abh.controller.*;

@Singleton
public class Routes {
    @Route("menu")
    @Inject
    Provider<MenuController> menu;

    @Route("read")
    @Inject
    Provider<ReadController> read;

    @Route("write")
    @Inject
    Provider<WriteController> write;

    @Route("practiseRead")
    @Inject
    Provider<PractiseReadController> practiseRead;

    @Route("practiseWrite")
    @Inject
    Provider<PractiseWriteController> practiseWrite;

    @Inject
    public Routes() {
    }
}
