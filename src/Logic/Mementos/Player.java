package Logic.Mementos;

import Logic.GameObjects.ObjectFactory;
import Logic.Model;
import animation.PathFactory;
import animation.Render;
import com.sun.org.apache.xpath.internal.operations.Mod;

public class Player {
    private Model model;
    private int HighScore;

    private Player() {
        model = new Model();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }
}
