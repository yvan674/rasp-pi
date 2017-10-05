package clock;

import clock.Clock;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import rasppi.Transitions;

import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * controller module allows for all the actions that relate to the FXML
 */
public class ClockController {
    @FXML private Button expandButton;
    @FXML private Pane rightPane;

    // clock and date variables
    @FXML private Text Time;
    @FXML private Text Day;
    @FXML private Text Date;

    // right pane pressedState
    private static boolean pressedState = false;


    @FXML
    protected void expandButtonPressed (ActionEvent event) {
        /* action for when the expand button is pressed */
        // sets the current state
        pressedState = !pressedState;

        // if it's pressed, then un-press. Else, press it in
        rasppi.Transitions.rightPaneTransition(expandButton, rightPane, pressedState);
    }

    @FXML
    public void initialize() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event -> {
            // set date variable
            Date now = new Date();

            // set values for the clock in the app
            Time.setText(Clock.getClock());
            Day.setText(Clock.Day(now));
            Date.setText(Clock.Date(now));
        }), new KeyFrame(Duration.seconds(1))
        );
        // make the animation play indefinitely
        timeline.setCycleCount(Animation.INDEFINITE);

        // play the animation
        timeline.play();
    }

}
