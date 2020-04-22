package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;

import java.util.Random;

public class SpecialFruit2 extends GameObject{
    private int liveIncrease;
    private Canvas canvas;

    public SpecialFruit2() {
        canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(new Image("banana.png"),0,0,40,40);
    }

    @Override
    public String getType() {
        return "SpecialFruit2";
    }
}
