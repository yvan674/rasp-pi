package rasppi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 *
 * Main state machine for the program
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Clock_fxml.fxml"));

        Scene scene = new Scene(root, 480, 320);

        stage.setTitle("Rasp Pi");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
