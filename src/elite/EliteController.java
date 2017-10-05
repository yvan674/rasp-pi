package elite;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Yvan on 4.10.17.
 * Copyright (C) 2017.
 */
public class EliteController {
    // FXML button declarations
    @FXML private Button closeButton;
    @FXML private Button superCruiseButton;
    @FXML private Button mapButton;
    @FXML private Button universalButton;
    @FXML private Button abortButton;
    @FXML private Button fsdButton;
    @FXML private Button dockButton;
    @FXML private Button repairButton;


    @FXML
    public void closeButtonPressed() throws IOException{
        /* action for when the close button is pressed */

        // if it's pressed, change the scene
        // get the current stage
        Stage stage = (Stage) closeButton.getScene().getWindow();

        // set new root to have the elite fxml file
        Parent root = FXMLLoader.load(getClass().getResource("../clock/Clock_fxml.fxml"));

        // create the new scene with the new fxml file
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //debug
        System.out.println("Close button pressed");
    }

    // all the buttons
    @FXML
    public void superCruisePressed() {
        // todo

        // debug
        System.out.println("Supercruise");
    }
    @FXML
    public void mapPressed() {
        // todo

        // debug
        System.out.println("Map");
    }
    @FXML
    public void universalPressed() {
        // todo

        // debug
        System.out.println("Universal Cartographics");
    }
    @FXML
    public void abortPressed() {
        // todo

        // debug
        System.out.println("Abort");
    }
    @FXML
    public void fsdPressed() {
        // todo

        // debug
        System.out.println("FSD");
    }
    @FXML
    public void systemPressed() {
        // todo

        // debug
        System.out.println("System Map");
    }
    @FXML
    public void dockPressed() {
        // todo

        // debug
        System.out.println("Dock");
    }
    @FXML
    public void repairPressed() {
        // todo

        // debug
        System.out.println("Repair");
    }

}
