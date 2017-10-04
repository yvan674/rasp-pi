package rasppi;

import clock.Clock;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 */
public class Controller {
    @FXML private Button expandButton;
    @FXML private Pane rightPane;
    @FXML private static StringProperty time = new SimpleStringProperty("00:00");
    @FXML private static StringProperty date = new SimpleStringProperty("");
    @FXML private static StringProperty day = new SimpleStringProperty("");

    // right pane pressedState
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

    // date setting
    public static StringProperty dateProperty() {
        return date;
    }
    public String getDate(){
        return date.get();
    }
    public void setDate(Date now) {
        date.set(Clock.Date(now));
    }

    // day setting
    public static StringProperty dayProperty() {
        return day;
    }
    public String getDay() {
        return day.get();
    }
    public void setDay(Date now) {
        day.set(Clock.Date(now));
    }

    @FXML
    protected void expandButtonPressed (ActionEvent event) {
        /* action for when the expand button is pressed */
        // sets the current state
        pressedState = !pressedState;

        // if it's pressed, then unpress. Else, press it in
        rightPaneTransition(expandButton, rightPane, pressedState);
    }

    private void rightPaneTransition(Button button, Pane pane, boolean state) {
        /* Transition to move the right pane of the clock. */
        // button rotation transition object
        RotateTransition rotate = new RotateTransition(Duration.millis(150), button);
        rotate.setInterpolator(Interpolator.EASE_BOTH);

        // pane translate transition object
        TranslateTransition move = new TranslateTransition(Duration.millis(150), pane );
        move.setInterpolator(Interpolator.EASE_BOTH);
        if (state) {
            // rotate it
            rotate.setFromAngle(0);
            rotate.setToAngle(180);

            // move it
            move.setByX(-100);
        } else {
            // rotate it back
            rotate.setFromAngle(180);
            rotate.setToAngle(0);

            // move it back
            move.setByX(100);

        }
        rotate.play();
        move.play();
    }
}
