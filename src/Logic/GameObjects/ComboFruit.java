package Logic.GameObjects;

import Logic.Mementos.Model;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class ComboFruit extends FruitDecorator {
    public ComboFruit(Fruit fruit) {
        super(fruit);
    }

    @Override
    public String getType() {
        return "ComboFruit";
    }

    @Override
    public void slice(Model model, Timeline gameTimeLine) {
        model.setScore(model.getScore()+10);
        this.getCanvas().setDisable(true);
        this.setSliced(true);
    }

    @Override
    public void checkObject(Model model) {
        this.fruit.checkObject(model);
    }
}

