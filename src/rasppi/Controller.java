package rasppi;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

import java.util.Arrays;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 */
public class Controller {
    @FXML private Button expandButton;
    @FXML private Pane rightPane;
    @FXML public static StringProperty time = new SimpleStringProperty("00:00");
    private static boolean pressedState = false;

    public static StringProperty timeProperty(){
        return time;
    }
    public String getTime(){
        return timeProperty().get();
    }
    public static void setTime(String newString) {
        timeProperty().set(newString);
    }

    @FXML
    protected void expandButtonPressed (ActionEvent event) {
        // sets the current state
        pressedState = !pressedState;

        // if it's pressed, then unpress. Else, press it in
        if (pressedState) {
            expandButton.getTransforms().add(new Rotate(180, 25, 25));
            rightPane.getTransforms().add(new Translate(-100, 0));
        } else {
            expandButton.getTransforms().remove(0);
            rightPane.getTransforms().remove(0);
        }
    }
}
