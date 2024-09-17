package roniton.abh.controller;

import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnInit;
import roniton.abh.App;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelber - Menu")
public class MenuController {
    @Inject
    App app;

    @Inject
    public MenuController() {
    }

    @OnInit
    void init(){

    }

    public void onRead() {
    }

    public void onWrite() {

    }

    public void onPractiseRead() {
    }

    public void onPractiseWrite() {
    }
}
