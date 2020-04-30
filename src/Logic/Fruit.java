package Logic;

import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.Random;

public class Fruit extends GameObject {
    private String type;

    public Fruit(String image1, String image2, String name) {
        super(image1, image2);
        this.type = name;
    }


    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void slice(Model model, Timeline gameTimeLine, Duration duration) {
        model.setScore(model.getScore()+1);
        this.getCanvas().setDisable(true);
        this.setSliced(true);
    }

    @Override
    public void checkObject(Model model) {
        if (!isSliced()) model.setLives(model.getLives()-1);
    }

}



