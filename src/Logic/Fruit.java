package Logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Fruit extends GameObject {
    private String type;

    public Fruit(String st1 , String st2) {
        super(st1,st2);
        this.type = st1;
    }

    @Override
        public String getType () {
            return this.type;
        }

    }
