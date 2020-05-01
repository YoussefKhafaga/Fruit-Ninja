package Logic.Mementos;

import Logic.Model;

public class Player {
    private Model model;
    private int HighScore;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }
    public void restore(){}
}
