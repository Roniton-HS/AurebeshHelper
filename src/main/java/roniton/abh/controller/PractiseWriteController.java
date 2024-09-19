package roniton.abh.controller;

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
import java.util.List;
import java.util.Random;

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

    final Random random = new Random();
    final List<String> words = List.of("hello there", "sheev palpatine", "obi-Wan kenobi", "lightsaber", "force",
            "han solo", "skywalker", "yoda", "x-wing", "high ground", "darth vader", "darth maul", "naboo", "coruscant",
            "alderaan", "death star", "han shot first", "jabba", "mustafar", "mandalorian", "grogu", "captain rex",
            "commander cody", "general grievous", "battle droid", "i am the senate", "unlimited power", "hyper drive",
            "blaster", "clone", "kamino", "stormtrooper", "tarkin", "kit fisto", "darth bane", "geonosis",
            "droid factory", "thermal detonator", "strike me down", "old republic", "sith", "jedi", "revan");

    @OnRender
    void render(){
        nextWord();
    }

    public void onReturn() {
        app.show("/menu");
    }

    public void onLetterInput(ActionEvent actionEvent) {
        Button b = (Button) actionEvent.getSource();
        String input = b.getText();
        String output = inputBox.getText();
        output += switch (input) {
            case "ç" -> "ch";
            case "æ" -> "ae";
            case "ë" -> "eo";
            case " " -> ' ';
            case "ñ" -> "ng";
            case "Ø" -> "oo";
            case "ß" -> "sh";
            case "Æ" -> "th";
            case "space" -> " ";
            default -> input;
        };
        inputBox.setText(output);
    }

    private void nextWord(){
        inputBox.setText("");
        int i = random.nextInt(words.size());
        String nextWord = words.get(i);
        toTranslateBox.setText(nextWord);
        inputBox.getStyleClass().remove("wrongInputBox");
    }

    public void backSpace() {
        String text = inputBox.getText();
        if (!text.isEmpty()){
            text = text.substring(0, text.length() -1);
            inputBox.setText(text);
        }
    }

    public void onNext() {
        if (!inputBox.getText().isEmpty() && inputBox.getText().equals(toTranslateBox.getText())){
            // word are matching
            nextWord();
        }else {
            // words don't match
            inputBox.getStyleClass().add("wrongInputBox");
        }
    }

    public void onSkip() {
        nextWord();
    }
}
