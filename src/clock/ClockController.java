package clock;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * controller module allows for all the actions that relate to the FXML
 */
public class ClockController {
    // right pane pressedState
    private static boolean pressedState = false;
    // clock and date variables
    @FXML
    private Text Time;
    @FXML
    private Text Day;
    @FXML
    private Text Date;
    // sidebar objects
    @FXML
    private Button expandButton;
    @FXML
    private Pane rightPane;
    @FXML
    private Button eliteButton;


    @FXML
    protected void expandButtonPressed(ActionEvent event) throws IOException {
        /* action for when the expand button is pressed */
        // sets the current state
        pressedState = !pressedState;

        // if it's pressed, then un-press. Else, press it in
        rasppi.Transitions.rightPaneTransition(expandButton, rightPane, pressedState);
    }

    @FXML
    protected void eliteButtonPressed(ActionEvent event) throws IOException {
        /* action for when the elite logo button is pressed */
        // if it's pressed, change the scene

        // reset pressed state of the expand button
        pressedState = !pressedState;

        // get the current stage
        Stage stage = (Stage) eliteButton.getScene().getWindow();

        // set new root to have the elite fxml file
        Parent root = FXMLLoader.load(getClass().getResource("../elite/Elite_fxml.fxml"));

        // create the new scene with the new fxml file
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void sleepButtonPressed(ActionEvent event) {
        // todo

        //debug
        System.out.println("Sleep button pressed");
    }
    @FXML
    public void initialize() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event -> {
            // set date variable
            Date now = new Date();

            // set values for the clock in the app
            Time.setText(Clock.getTime(now));
            Day.setText(Clock.getDay(now));
            Date.setText(Clock.getDate(now));
        }), new KeyFrame(Duration.seconds(1))
        );
        // make the animation play indefinitely
        timeline.setCycleCount(Animation.INDEFINITE);

        // play the animation
        timeline.play();
    }

}
