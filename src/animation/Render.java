package animation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import sample.GameObject;
import sample.ObjectFactory;

import java.util.ArrayList;
import java.util.Random;

public class Render {
    private ArrayList<Timeline> timeline;
    private ObjectFactory objectFactory;

    public Render() {
        objectFactory = new ObjectFactory();
    }
    public GameObject createObject () {
            Random random = new Random();
            GameObject gameObject = objectFactory.createObject(random.nextInt(5));
            return  gameObject;
        }

    public PathTransition createPathTransition(){
        RandomPath randomPath = new RandomPath();
        PathTransition pathTransition = new PathTransition();
        pathTransition = randomPath.pathGenerator();
        return  pathTransition;
    }

    public PathTransition generateTransitions (GameObject gameObject){
        PathTransition pathTransition = createPathTransition();
        Canvas canvas = gameObject.getCanvas();
        canvas.setVisible(true);
        pathTransition.setNode(canvas);
        pathTransition.setDuration(Duration.millis(3000));

        return pathTransition;
    }



}
