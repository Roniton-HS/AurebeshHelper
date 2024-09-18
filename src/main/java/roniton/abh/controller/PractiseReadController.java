package roniton.abh.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnInit;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

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
    public PractiseReadController() {
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

    public void onNext() {
        if (inputBox.getText().equals(toTranslateBox.getText())){
            // word are matching
            nextWord();
        }else {
            // words don't match
            inputBox.getStyleClass().add("wrongInputBox");
        }
    }

    private void nextWord(){
        inputBox.setText(null);
        int i = random.nextInt(words.size());
        String nextWord = words.get(i);
        toTranslateBox.setText(nextWord);
        inputBox.getStyleClass().remove("wrongInputBox");
    }

    public void onSkip() {
        nextWord();
    }
}
