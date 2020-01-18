package com.OSAGEIAMOS;

import com.OSAGEIAMOS.Input.Input;
import com.sun.prism.Graphics;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Base extends Application {
    private static com.OSAGEIAMOS.Input.Input Input;
    private static final Logger Log = Logger.getLogger(Main.class.getName());

    public void start(Stage s) {
        initialiseWindow(s, "OSAGEIAMOS", 1024, 768);
    }

    private void initialiseWindow(Stage s, String title, int width, int height) {
        //Sets the title of the window created
        s.setTitle(title);

        //Initialising the base group to act as the root node for the elements which go in the window
        Group root = new Group();
        Scene scene = new Scene(root);
        s.setScene(scene);

        //Adding a canvas which is where the graphics of the game will be drawn to
        Canvas canvas = new Canvas(width, height);
        root.getChildren().add(canvas);

        //TODO: Figure out what the f*** this actually means
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Filling the graphics context with "stuff" to draw to the canvas
        gc.setFill(Color.BLACK);
        Font f = Font.font("Arial", FontWeight.BOLD, 30);
        gc.setFont(f);

        Input = new Input();
        setEventHandlers(s.getScene());

        //Start the game loop
        setupLoop(gc);

        //"Paint" the canvas with the updated context
        s.show();
    }

//    public void loop(GraphicsContext gc) {
//        final long startNanoTime = System.nanoTime();
//
//        new AnimationTimer() {
//            int counter = 0;
//
//            public void handle(long currentNanoTime) {
//                double t = (currentNanoTime - startNanoTime) / 10000000000.0;
//                //Display current frame per second
//                counter = (++counter) % 60;
//                //clear screen
//                gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
//                //Show text
//                gc.fillText(Integer.toString(counter), 250, 250);
//            }
//        }.start();
//    }

    private void setupLoop(GraphicsContext gc) {
        //Get the current time at this point in the execution
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double time = (currentNanoTime - startNanoTime) / 10000000000.0;
                Update();
                Render(gc);
            }
        }.start();
    }

    public void Update() {

    }

    public void Render(GraphicsContext gc) {

    }

    private void setEventHandlers(Scene s) {
        //Set event handler for KeyPressed
        s.addEventHandler(KeyEvent.KEY_PRESSED, (keyEvent -> {
            Input.SetKeyPressed(keyEvent.getCode());
            Log.log(Level.INFO, keyEvent.getCode().toString());
        }));
        //Set event handler for KeyTyped
        s.addEventHandler(KeyEvent.KEY_TYPED, keyEvent -> {
            Input.SetKeyTyped(keyEvent.getCode());
            Log.log(Level.INFO, keyEvent.getCode().toString());
        });
        //Set event handler for KeyUp
        s.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            Input.SetKeyUp(keyEvent.getCode());
            Log.log(Level.INFO, keyEvent.getCode().toString());
        });
    }
}
