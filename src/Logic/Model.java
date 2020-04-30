package Logic;

import animation.Projector;

import java.util.ArrayList;

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
