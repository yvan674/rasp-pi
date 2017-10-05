package rasppi;

import clock.Clock;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * controller module allows for all the actions that relate to the FXML
 */
public class ClockController {
    @FXML private Button expandButton;
    @FXML private Pane rightPane;

    // clock properties
    @FXML public static StringProperty time = new SimpleStringProperty("00:00");
    @FXML public static StringProperty date = new SimpleStringProperty("");
    @FXML public static StringProperty day = new SimpleStringProperty("");

    @FXML static Text Time;

    // right pane pressedState
    private static boolean pressedState = false;

    // time setting
    public static StringProperty timeProperty(){
        return ClockController.time;
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
        return dateProperty().get();
    }
    public void setDate(Date now) {
        dateProperty().set(Clock.Date(now));
    }

    // day setting
    public static StringProperty dayProperty() {
        return ClockController.day;
    }
    public String getDay() {
        return dayProperty().get();
    }
    public void setDay(Date now) {
        dayProperty().set(Clock.Day(now));
    }

    @FXML
    protected void expandButtonPressed (ActionEvent event) {
        /* action for when the expand button is pressed */
        // sets the current state
        pressedState = !pressedState;

        // if it's pressed, then unpress. Else, press it in
        Transitions.rightPaneTransition(expandButton, rightPane, pressedState);
    }

    @FXML
    public void initialize() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event -> {
            Date now = new Date();
            setDay(now);
            setDate(now);
            Time.setText(clock.Clock.getClock());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
