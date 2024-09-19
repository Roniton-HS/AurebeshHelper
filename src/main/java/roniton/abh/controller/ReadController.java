package roniton.abh.controller;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;

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
    public ReadController() {
    }

    @OnRender
    void render() {
        inputField.textProperty().addListener(changeListener);
    }

    final ChangeListener<String> changeListener = (observableValue, oldVal, newVal) -> outputField.setText(newVal);

    public void onReturn() {
        app.show("/menu");
    }

    public void onLetterInput(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        char input = b.getText().charAt(0);
        String output = outputField.getText();
        output += switch (input) {
            case 'ç' -> "ch";
            case 'æ' -> "ae";
            case 'ë' -> "eo";
            case ' ' -> ' ';
            case 'ñ' -> "ng";
            case 'Ø' -> "oo";
            case 'ß' -> "sh";
            case 'Æ' -> "th";
            default -> input;
        };
        inputField.setText(output);
        outputField.setText(output);
    }

    public void backSpace() {
        String text = inputField.getText();
        if (!text.isEmpty()){
            text = text.substring(0, text.length() -1);
            inputField.setText(text);
            outputField.setText(text);
        }
    }
}
