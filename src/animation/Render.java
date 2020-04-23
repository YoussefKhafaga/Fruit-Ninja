package animation;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;
import Logic.GameObject;
import Logic.ObjectFactory;

import java.util.ArrayList;
import java.util.Random;

public class Render {
    private ObjectFactory objectFactory;
//    private Render render;

    public Render() {
        objectFactory = new ObjectFactory();
    }
    public GameObject createObject () {
            Random random = new Random();
            GameObject gameObject = objectFactory.createObject(random.nextInt(7));
            return  gameObject;
        }

    public PathTransition createPathTransition(){
        ObjectPath randomPath = new ObjectPath();
        PathTransition pathTransition = randomPath.pathGenerator();
        return  pathTransition;
    }

    public PathTransition generateTransitions (GameObject gameObject){
        PathTransition pathTransition = createPathTransition();
        Canvas canvas = gameObject.getCanvas();
        canvas.setVisible(true);
        pathTransition.setNode(canvas);
        pathTransition.setDuration(Duration.millis(5000));
        return pathTransition;
    }




}
