package animation;

import Logic.GameObject;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Projector {
    private Timeline timeline;
    private PathTransition pathTransition;
    private GameObject gameObject;
    private Render render;

    public Projector() {
        this.render = new Render();
    }

    public void generateTimeLine(AnchorPane anchor) {
        timeline = new Timeline(new KeyFrame(Duration.millis(4500),e->{
        gameObject = render.createObject();
        pathTransition = render.generateTransitions(gameObject);
        pathTransition.setDelay(Duration.seconds(2));
        pathTransition.play();
        anchor.getChildren().addAll(gameObject.getCanvas());
        }));
    }
    public void fade() {
        Canvas canvas = gameObject.getCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(gameObject.getSlicedImage(), 0, 0, 40, 40);
        gameObject.setCanvas(canvas);
        FadeTransition ft = new FadeTransition(Duration.millis(2000), canvas);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.play();
        ft.setOnFinished(e->{
            canvas.setVisible(false);
            canvas.setDisable(true);
        });
    }
    public void playTimeLine(){

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
