package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Fruit extends GameObject {
    private int scoreIncrease;
    private Canvas canvas;
    private String name;

    public Fruit() {
        canvas = new Canvas(40,40);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                gc.drawImage(new Image("strawberry.png"), 0, 0, 40, 40);
                name = "Strawberry";
                break;
            case 1:
                gc.drawImage(new Image("watermelon.png"), 0, 0, 40, 40);
                name = "watermelon";
                break;
            case 2:
                gc.drawImage(new Image("banana.png"), 0, 0, 40, 40);
                name = "banana";
                break;
        }
    }
    public Canvas getCanvas() {
        return this.canvas;
    }

    public String getName() {
        return name;
    }

    @Override
        public String getType () {
            return "Fruit";
        }

    }
