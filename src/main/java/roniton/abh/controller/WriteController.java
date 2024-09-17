package roniton.abh.controller;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fulib.fx.annotation.controller.Controller;
import org.fulib.fx.annotation.controller.Title;
import org.fulib.fx.annotation.event.OnDestroy;
import org.fulib.fx.annotation.event.OnInit;
import org.fulib.fx.annotation.event.OnRender;
import roniton.abh.App;

import javax.inject.Inject;

@Controller
@Title("AurebeshHelper - Writing")
public class WriteController {
    @FXML
    TextField textbox_input;
    @FXML
    TextField textbox_output;
    @Inject
    App app;

    ChangeListener<String> changeListener = (observableValue, oldVal, newVal) -> {
        if (newVal.isEmpty()) {
            textbox_output.getStyleClass().add("aurebeshOutputFieldEmpty");
        } else {
            textbox_output.getStyleClass().remove("aurebeshOutputFieldEmpty");
        }
        textbox_output.setText(newVal);
    };

    @Inject
    public WriteController() {
    }

    @OnInit
    void init() {

    }

    @OnRender
    void render() {
        textbox_output.setFocusTraversable(false);
        textbox_input.textProperty().addListener(changeListener);
    }

    @OnDestroy
    void destroy() {
        textbox_input.textProperty().removeListener(changeListener);
    }

    public void onReturn() {
        app.show("/menu");
    }
}
