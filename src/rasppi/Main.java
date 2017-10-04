package rasppi;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.time.LocalTime;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 *
 * Main state machine for the program
 */
public class Main extends Application {
    private boolean running;

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Clock_fxml.fxml"));

        Scene scene = new Scene(root, 480, 320);

        stage.setTitle("Rasp Pi");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent arg0) {
                running = false;
                stage.close();
            }
        });

        // runClock();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
