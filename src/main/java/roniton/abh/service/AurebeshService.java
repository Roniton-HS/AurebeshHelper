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

    /**
     * @param inputBox TextField with user input
     * @param toTranslateBox TextField with text that needs to be translated by the user
     * select a random new word to be translated
     * clears user input
     * removes red error border
     */
    public void nextWord(TextField inputBox, TextField toTranslateBox){
        inputBox.setText("");
        int i = random.nextInt(Constants.words.size());
        String nextWord = Constants.words.get(i);
        toTranslateBox.setText(nextWord);
        inputBox.getStyleClass().remove("wrongInputBox");
    }

    /**
     * @param inputBox TextField where backSpace was used on
     * removes the rightmost char of a String
     */
    public void backSpace(TextField inputBox){
        String text = inputBox.getText();
        if (!text.isEmpty()){
            text = text.substring(0, text.length() -1);
            inputBox.setText(text);
        }
    }

    /**
     * @param input text that needs to be converted
     * @return a text where every special character was replaced with its corresponding String
     */
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

    /**
     * @param inputField TextField where text needs to be added
     * @param actionEvent Event that was fired when a letter button was pressed
     * @return old text + new character
     * mainly handles the "space" input and converts it to an actual space
     */
    public String letterInput(TextField inputField,ActionEvent actionEvent){
        Button b = (Button) actionEvent.getSource();
        String newText;
        if (b.getText().equals("space")){
            newText = inputField.getText() + " ";
        }else {
            newText = inputField.getText() + b.getText();
        }
        return newText;
    }
}
