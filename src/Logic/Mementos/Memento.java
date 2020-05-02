package Logic.Mementos;

import Logic.FileAccess.FileWrite;
import Logic.Model;

import javax.xml.parsers.ParserConfigurationException;

public class Memento {
    private Model model;
    private int highScore;

    public Memento(Model model,int highScore){
        this.highScore = highScore;
        this.model = new Model(model.getLives(),model.getScore(),model.getProjectors());
    }

    public Model getModel() {
        return model;
    }

    public int getHighScore(){return highScore;}

    public void saveModel() throws ParserConfigurationException {
        FileWrite fileWrite = new FileWrite("file.xml");
        fileWrite.saveModel(this.model,this.highScore);
    }
}
