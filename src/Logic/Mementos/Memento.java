package Logic.Mementos;

import Logic.Model;

public class Memento {
    private Model model;
    private int highScore;

    public Memento(Model model,int highScore){
        this.highScore = highScore;
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
    public int getHighScore(){return highScore;}
}
