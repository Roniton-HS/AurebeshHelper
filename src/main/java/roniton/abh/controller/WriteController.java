package roniton.abh.controller;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnDestroy;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Writing")
public class WriteController {
    @FXML
    TextField textBoxInput;
    @FXML
    TextField textBoxOutput;
    @Inject
    App app;

    final ChangeListener<String> changeListener = (observableValue, oldVal, newVal) -> {
        if (newVal.isEmpty()) {
            textBoxOutput.getStyleClass().add("aurebeshOutputFieldEmpty");
        } else {
            textBoxOutput.getStyleClass().remove("aurebeshOutputFieldEmpty");
        }
        textBoxOutput.setText(newVal);
    };

    @Inject
    public WriteController() {
    }

    @OnRender
    void render() {
        textBoxOutput.setFocusTraversable(false);
        textBoxInput.textProperty().addListener(changeListener);
    }

    @OnDestroy
    void destroy() {
        textBoxInput.textProperty().removeListener(changeListener);
    }

    public void onReturn() {
        app.show("/menu");
    }
}
