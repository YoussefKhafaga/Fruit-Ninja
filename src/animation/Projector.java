package animation;

import Logic.GameObjects.GameObject;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Projector {
    private PathTransition pathTransition;
    private GameObject gameObject;
    private Duration pause;

    public Projector(Double delay,Double duration , String mode) {
        Render render = Render.getInstance();
        gameObject = render.createObject(mode);
        pathTransition = render.generateTransitions(gameObject,duration);
        pathTransition.setDelay(Duration.millis(delay));
        pathTransition.play();
    }

    public Projector() {

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
