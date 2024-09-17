package roniton.abh.controller;

import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnInit;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelber - Menu")
public class MenuController {

    @Inject
    public MenuController() {
    }

    @OnInit
    void init(){
        System.out.println("a");
    }

}
