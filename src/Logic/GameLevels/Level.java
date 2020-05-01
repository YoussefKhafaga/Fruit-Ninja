package Logic.GameLevels;

import Logic.Model;

public class Level {
    private LevelState levelState;
    private int score;

    public Level(int score) {
        this.score = score;
        this.setLevelState(score);
    }

    public Double getDuration() {
        return levelState.getDuration();
    }

    public Double getDelay() {
        return levelState.getDelay();
    }

    public void setLevelState(int score) {

        if (score <= 10) {
            levelState = new Easy();
        } else if (score >= 10 && score <= 20) {
            levelState = new Normal();
        } else {
            levelState = new Hard();
        }

    }
}

