package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Path;

import java.util.Random;

public class FatalBomb extends GameObject{
    private Canvas canvas;

    public FatalBomb() {
        canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(new Image("fatalbomb.png"),0,0,40,40);
    }

    @Override
    public String getType() {
        return "FatalBomb";
    }
}
