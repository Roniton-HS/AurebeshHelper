package roniton.abh.service;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import roniton.abh.Constants;

import javax.inject.Inject;
import java.util.Random;

public class AurebeshService {

    @Inject
    public AurebeshService() {
    }

    final Random random = new Random();

    public void nextWord(TextField inputBox, TextField toTranslateBox){
        inputBox.setText("");
        int i = random.nextInt(Constants.words.size());
        String nextWord = Constants.words.get(i);
        toTranslateBox.setText(nextWord);
        inputBox.getStyleClass().remove("wrongInputBox");
    }

    public void backSpace(TextField inputBox){
        String text = inputBox.getText();
        if (!text.isEmpty()){
            text = text.substring(0, text.length() -1);
            inputBox.setText(text);
        }
    }

    public String convertText(String input){
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            output.append(switch (c) {
                case 'ç' -> "ch";
                case 'æ' -> "ae";
                case 'ë' -> "eo";
                case 'þ' -> "kh";
                case 'ñ' -> "ng";
                case 'Ø' -> "oo";
                case 'ß' -> "sh";
                case 'ð' -> "th";
                default -> c;
            });
        }
        return String.valueOf(output);
    }
}
