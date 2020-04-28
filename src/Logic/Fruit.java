package Logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public class Fruit extends GameObject {
    private String name;

    public Fruit(String image1 , String image2,String name) {
        super(image1,image2);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
        public String getType () {
            return "Fruit";
        }

    }
