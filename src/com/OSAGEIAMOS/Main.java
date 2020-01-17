package com.OSAGEIAMOS;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.*;

public class Main extends Application {
    public static void main(String[] args) {
//        System.out.println("Sup bitches!");
        launch(args);
    }

    public void start(Stage s) {
        //Sets the title of the window created
        s.setTitle("OSAGEIAMOS");

        //Initialising the base group to act as the root node for the elements which go in the window
        Group root = new Group();
        Scene scene = new Scene(root);
        s.setScene(scene);

        //Adding a canvas which is where the graphics of the game will be drawn to
        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);

        //TODO: Figure out what the f*** this actually means
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Filling the graphics context with "stuff" to draw to the canvas
        gc.setFill(Color.BLACK);
//        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        Font f = Font.font("Arial", FontWeight.BOLD, 48);
        gc.setFont(f);
//        gc.fillText("Sup, Bitches!", 100, 100);
//        gc.strokeText("Sup, Bitches!", 100, 100);

        //Start the game loop
        loop(gc);

        //"Paint" the canvas with the updated context
        s.show();
    }

    public void loop(GraphicsContext gc) {
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            int counter = 0;

            public void handle(long currentNanoTime){
                //Time.deltaTime();
                double t = (currentNanoTime - startNanoTime) / 10000000000.0;
                //Display current frame per second
                counter = (++counter) % 60;
                //clear screen
                gc.clearRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                //Show text
                gc.fillText(Integer.toString(counter), 250, 250);
            }
        }.start();
    }
}
