package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DangerousBomb extends GameObject{
    private Canvas canvas;


    public DangerousBomb() {
        canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(new Image("dangerousbomb.png"),0,0,40,40);
    }

    @Override
    public String getType() {
        return "DangerousBomb";
    }
}
