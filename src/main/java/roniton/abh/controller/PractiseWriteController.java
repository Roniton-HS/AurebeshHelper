package roniton.abh.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;
import roniton.abh.service.AurebeshService;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Practise Writing")
public class PractiseWriteController {
    @Inject
    AurebeshService aurebeshService;
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
        aurebeshService.nextWord(inputBox, toTranslateBox);
    }

    public void onReturn() {
        app.show("/menu");
    }

    public void onLetterInput(ActionEvent actionEvent) {
        String output = inputBox.getText() + aurebeshService.buttonInput(actionEvent);
        inputBox.setText(output);
    }

    public void onBackSpace() {
        aurebeshService.backSpace(inputBox);
    }

    public void onNext() {
        if (!inputBox.getText().isEmpty() && inputBox.getText().equals(toTranslateBox.getText())){
            // word are matching
            aurebeshService.nextWord(inputBox, toTranslateBox);
        }else {
            // words don't match
            inputBox.getStyleClass().add("wrongInputBox");
        }
    }

    public void onSkip() {
        aurebeshService.nextWord(inputBox, toTranslateBox);
    }
}
