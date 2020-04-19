package animation;

import javafx.animation.PathTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

import java.util.Random;

public class RandomPath {

    public RandomPath() {
    }
    public PathTransition pathGenerator(){
        Random random = new Random();
        Path path = new Path();
        int x = 100+random.nextInt(200);
        int z = 400+random.nextInt(200);
        int a = 400+random.nextInt(200);
        int b = -500 + random.nextInt(100);
        int c = 400+random.nextInt(200);
        int d = 150+random.nextInt(200);
        MoveTo moveTo = new MoveTo(100, 350);
        QuadCurveTo cubicCurveTo = new QuadCurveTo(350, b, 600, 350);
        path.getElements().addAll(moveTo,cubicCurveTo);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(path);
            return pathTransition;
    }
}
