package roniton.abh.controller;

import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import roniton.abh.App;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Menu")
public class MenuController {
    @Inject
    App app;

    @Inject
    public MenuController() {
    }

    public void onRead() {
        app.show("/read");
    }

    public void onWrite() {
        app.show("/write");
    }

    public void onPractiseRead() {
        app.show("/practiseRead");
    }

    public void onPractiseWrite() {
        app.show("/practiseWrite");
    }
}
