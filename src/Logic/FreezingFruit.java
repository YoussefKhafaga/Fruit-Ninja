package Logic;

import animation.Projector;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class FreezingFruit extends FruitDecorator {

    public FreezingFruit(Fruit fruit) {
        super(fruit);
    }

    @Override
    public String getType() {
        return "FreezingFruit";
    }

    @Override
    public void slice(Model model, Timeline gameTimeLine, Duration duration) {
        this.getCanvas().setDisable(true);
        this.setSliced(true);
        duration = gameTimeLine.getCurrentTime();
        gameTimeLine.pause();
        for (Projector projector : model.getProjectors()) {
            projector.getPathTransition().pause();
            projector.setPause(projector.getPathTransition().getCurrentTime());
        }
        Timeline freeze = new Timeline(new KeyFrame(Duration.seconds(3.0), e ->{}));
        freeze.play();
        Duration finalDuration = duration;
        freeze.setOnFinished(e -> {
            gameTimeLine.playFrom(finalDuration);
            for (Projector projector : model.getProjectors()) {
                projector.getPathTransition().playFrom(projector.getPause());
            }
        });

    }

    @Override
    public void checkObject(Model model) {
        this.fruit.checkObject(model);
    }
}
