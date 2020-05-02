package Logic.GameObjects;

import Logic.Mementos.Model;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

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
    public void slice(Model model, Timeline gameTimeLine) {
        model.setScore(model.getScore()+1);
        this.getCanvas().setDisable(true);
        this.setSliced(true);
    }

    @Override
    public void checkObject(Model model) {
        if (!isSliced()) model.setLives(model.getLives()-1);
    }

}



