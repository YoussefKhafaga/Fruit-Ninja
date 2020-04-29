package animation;

import javafx.animation.PathTransition;
import javafx.scene.canvas.Canvas;

import javafx.util.Duration;
import Logic.GameObject;
import Logic.ObjectFactory;

import java.util.Random;

public class Render {
    private ObjectFactory objectFactory;
    private PathFactory pathFactory;

    public Render() {
        objectFactory = new ObjectFactory();
        pathFactory = new PathFactory();
    }

    public GameObject createObject() {
        Random random = new Random();
        GameObject gameObject = objectFactory.createObject(random.nextInt(7));
        return gameObject;
    }

    public PathTransition generateTransitions(GameObject gameObject, Double duration) {
        PathFactory randomPath = new PathFactory();
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(randomPath.generatePath());
        Canvas canvas = gameObject.getCanvas();
        canvas.setVisible(true);
        pathTransition.setNode(canvas);
        pathTransition.setDuration(Duration.millis(duration));
        return pathTransition;
    }


}
