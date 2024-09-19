package roniton.abh.controller;

import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import roniton.abh.App;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Learn")
public class LearnController {
    @Inject
    App app;
    @Inject
    public LearnController() {
    }

    public void onReturn() {
        app.show("/menu");
    }
}
