package animation;

import javafx.animation.PathTransition;
import javafx.scene.canvas.Canvas;

import javafx.util.Duration;
import Logic.GameObjects.GameObject;
import Logic.GameObjects.ObjectFactory;

import java.util.Random;

public class Render {
    private ObjectFactory objectFactory;
    private PathFactory pathFactory;
    private static Render render = new Render();

    private Render() {
        objectFactory = new ObjectFactory();
        pathFactory = new PathFactory();
    }

    public static Render getInstance() {
        if (render == null) {
            render = new Render();
        }
        return render;
    }

    public GameObject createObject(String mode) {
        int x ;
        Random random = new Random();
        if(mode.equals("Arcade")){
            x = random.nextInt(3);
        }else {
            x = random.nextInt(11)%7;
        }
        GameObject gameObject = objectFactory.createObject(x);
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
