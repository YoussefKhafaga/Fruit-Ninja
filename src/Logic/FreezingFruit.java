package Logic;

import animation.Projector;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class FreezingFruit extends  FruitDecorator {
    public FreezingFruit(String st1, String st2) {
        super(st1,st2);
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
        Timeline freeze = new Timeline(new KeyFrame(Duration.seconds(3.0),e->{
            gameTimeLine.pause();
        for (Projector projector : model.getProjectors()) {
            projector.getPathTransition().stop();
            projector.setPause(projector.getPathTransition().getCurrentTime());
        }
        }));
        freeze.play();
        Duration finalDuration = duration;
        freeze.setOnFinished(e->{
            gameTimeLine.playFrom(finalDuration);
            for (Projector projector : model.getProjectors()) {
                projector.getPathTransition().playFrom(projector.getPause());
            }
        });

    }
}
