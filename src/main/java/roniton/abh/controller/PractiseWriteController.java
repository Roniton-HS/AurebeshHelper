package roniton.abh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Practise Writing")
public class PractiseWriteController {
    @Inject
    App app;
    @FXML
    TextField toTranslateBox;
    @FXML
    TextField inputBox;

    @Inject
    public PractiseWriteController() {
    }

    @OnRender
    void render(){
        toTranslateBox.setText("a");
    }

    public void onReturn() {
        app.show("/menu");
    }
}
