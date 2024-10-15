package roniton.abh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;
import roniton.abh.service.AurebeshService;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Practise Reading")
public class PractiseReadController {
    @FXML
    TextField inputBox;
    @FXML
    TextField toTranslateBox;
    @Inject
    App app;
    @Inject
    AurebeshService aurebeshService;
    @Inject
    public PractiseReadController() {
    }

    @OnRender
    void render(){
        aurebeshService.nextWord(inputBox, toTranslateBox);
    }

    public void onReturn() {
        app.show("/menu");
    }

    public void onNext() {
        if (!inputBox.getText().isEmpty() && inputBox.getText().equals(toTranslateBox.getText())){
            // word are matching
            aurebeshService.nextWord(inputBox, toTranslateBox);
        }else {
            // words don't match
            if (!inputBox.getStyleClass().contains("wrongInputBox")){
                inputBox.getStyleClass().add("wrongInputBox");
            }
        }
    }

    public void onSkip() {
        aurebeshService.nextWord(inputBox, toTranslateBox);
    }
}
