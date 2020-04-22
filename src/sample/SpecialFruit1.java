package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;

import java.util.Random;

public class SpecialFruit1 extends GameObject {
    private int scoreIncrease;
    private  Canvas canvas;

    public SpecialFruit1() {
        canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(new Image("banana.png"),0,0,40,40);
    }

    @Override
    public String getType() {
        return "SpecialFruit1";
    }
}
