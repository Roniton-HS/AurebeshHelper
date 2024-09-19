package roniton.abh.controller;

import javafx.event.ActionEvent;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import roniton.abh.App;
import roniton.abh.Constants;

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

    public void onLearn() {
        app.show("/learn");
    }
}
