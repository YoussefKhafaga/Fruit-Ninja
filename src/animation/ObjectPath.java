package animation;

import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

import java.util.Random;

public class ObjectPath {
    private PathTransition pathTransition;
    private Duration duration;

    public ObjectPath() {
    }

    public PathTransition pathGenerator() {
        Random random = new Random();
        int x = random.nextInt(4);
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        QuadCurveTo quadCurveTo = new QuadCurveTo();
        switch (x) {
            case 0:
                moveTo.setX(350);
                moveTo.setY(450);
                quadCurveTo = new QuadCurveTo(350,
                        -400 , 600, 450);
                break;
            case 1:
                moveTo.setX(600);
                moveTo.setY(450);
                quadCurveTo = new QuadCurveTo(350,
                        -400 , 100, 450);
                break;
            case 2:
                moveTo.setX(500);
                moveTo.setY(450);
                quadCurveTo = new QuadCurveTo(450,
                        -200, 300, 450);
                break;
            case 3:
                moveTo.setX(350);
                moveTo.setY(450);
                quadCurveTo = new QuadCurveTo(450,
                        -150, 600, 450);
                break;
        }
        path.getElements().addAll(moveTo, quadCurveTo);
        pathTransition = new PathTransition();
        pathTransition.setPath(path);
        return pathTransition;
    }
    public PathTransition getPathTransition() {
        return pathTransition;
    }

    public void setPathTransition(PathTransition pathTransition) {
        this.pathTransition = pathTransition;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
