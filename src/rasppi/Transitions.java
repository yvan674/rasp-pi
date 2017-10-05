package rasppi;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by Yvan on 4.10.17.
 * Copyright (C) 2017.
 */
public class Transitions {
    static void rightPaneTransition(Button button, Pane pane, boolean state) {
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
