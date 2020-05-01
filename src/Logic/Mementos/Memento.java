package Logic.Mementos;

import Logic.Model;

public class Memento {
    private Model model;

    public Memento(Model model){
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}
