package animation;

import Logic.GameObject;
import Logic.GameLevels.Level;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Projector {
    private Timeline timeline;
    private PathTransition pathTransition;
    private GameObject gameObject;
    private Duration pause;
    private Level level;

    public Projector() {

    }

    public void generateTimeLine(AnchorPane anchor,Double delay,Double duration) {
        timeline = new Timeline(new KeyFrame(Duration.millis(duration + delay), e -> {
            Render render = new Render();
            gameObject = render.createObject();
            pathTransition = render.generateTransitions(gameObject,duration);
            pathTransition.setDelay(Duration.millis(delay));
            anchor.getChildren().addAll(gameObject.getCanvas());
            pathTransition.play();
            pathTransition.setOnFinished(f-> {
                anchor.getChildren().remove(gameObject.getCanvas());
            });
        }));
    }

    public void fade(AnchorPane anchorPane) {
        Canvas canvas = gameObject.getCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(gameObject.getSlicedImage(), 0, 0, 40, 40);
        gameObject.setCanvas(canvas);
        FadeTransition ft = new FadeTransition(Duration.millis(2000), canvas);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.play();
        ft.setOnFinished(e -> {
            anchorPane.getChildren().remove(canvas);
        });
    }

    public Duration getPause() {
        return pause;
    }

    public void setPause(Duration pause) {
        this.pause = pause;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public PathTransition getPathTransition() {
        return pathTransition;
    }

    public void setPathTransition(PathTransition pathTransition) {
        this.pathTransition = pathTransition;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
