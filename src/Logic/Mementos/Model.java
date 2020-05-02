package Logic.Mementos;

import animation.Projector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Model {

    private int lives;
    private int score;
    private ArrayList<Projector> projectors;

    public Model(int lives, int score, ArrayList<Projector> projectors) {
        this.lives = lives;
        this.score = score;
        this.projectors = projectors;
    }

    public Model() {
        this.lives = 3;
        this.score = 0;
        this.projectors = new ArrayList<>();

    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Projector> getProjectors() {
        return projectors;
    }

    public void setProjectors(ArrayList<Projector> projectors) {
        this.projectors = projectors;
    }

}
