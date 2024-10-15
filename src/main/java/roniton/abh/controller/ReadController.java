package roniton.abh.controller;

import javafx.beans.value.ChangeListener;
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
@Title("AurebeshHelper - Reading")
public class ReadController {
    @FXML
    TextField inputField;
    @FXML
    TextField outputField;
    @Inject
    App app;
    @Inject
    AurebeshService aurebeshService;

    @Inject
    public ReadController() {
    }

    @OnRender
    void render() {
        inputField.textProperty().addListener(changeListener);
    }

    final ChangeListener<String> changeListener = (observableValue, oldVal, newVal) -> outputField.setText(aurebeshService.convertText(newVal));

    public void onReturn() {
        app.show("/menu");
    }

    public void onLetterInput(ActionEvent actionEvent) {
        inputField.setText(aurebeshService.letterInput(inputField, actionEvent));
    }

    public void onBackSpace() {
        aurebeshService.backSpace(inputField);
    }
}
