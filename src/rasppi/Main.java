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
/*
    private void runClock() {
        boolean running = true;
        new Thread() {
            public void run() {
                long last = System.nanoTime();

                while (running) {
                    double delta = 0;
                    long now = System.nanoTime();
                    delta += (now - last) / 1000000000.0;
                    last = now;

                    while (delta >= 1) {
                        int[] time = new int[2];
                        time[0] = LocalTime.now().getHour();
                        time[1] = LocalTime.now().getMinute();
                        // time to string
                        StringBuilder build = new StringBuilder();
                        build.append(time[0]);
                        build.append(":");
                        build.append(time[1]);
                        Controller.setTime(build.toString());
                        System.out.println(build.toString());
                    }
                }
            }
        }.start();
    }
    */
    public static void main(String[] args) {
        launch(args);
    }
}
