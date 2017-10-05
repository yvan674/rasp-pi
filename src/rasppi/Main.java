package rasppi;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 *
 * Main state machine for the program
 */
public class Main extends Application {
    private boolean running;

    @Override
    public void start(Stage stage) throws Exception {
        Parent clockRoot = FXMLLoader.load(getClass().getResource("../clock/Clock_fxml.fxml"));
        //Parent eliteRoot = FXMLLoader.load(getClass().getResource("../elite/Elite_fxml.fxml"));

        Scene clock = new Scene(clockRoot, 480, 320);
        //Scene elite = new Scene(eliteRoot, 480, 320);

        stage.setTitle("Rasp Pi");
        stage.setScene(clock);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent arg0) {
                running = false;
                stage.close();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
