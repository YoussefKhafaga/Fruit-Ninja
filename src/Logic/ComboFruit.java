package Logic;

import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class ComboFruit extends FruitDecorator{
    public ComboFruit(Fruit fruit) {
        super(fruit);
    }

    @Override
    public String getType() {
        return "ComboFruit";
    }

    @Override
    public void slice(Model model, Timeline gameTimeLine, Duration duration) {
        model.setScore(model.getScore()+10);
        this.getCanvas().setDisable(true);
        this.setSliced(true);
    }

    @Override
    public void checkObject(Model model) {
        this.fruit.checkObject(model);
    }
}

