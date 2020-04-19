package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Path;

public abstract class GameObject {
    private Canvas canvas;
    public abstract String getType();
    public Canvas getCanvas() {
        return this.canvas;
    }


}
