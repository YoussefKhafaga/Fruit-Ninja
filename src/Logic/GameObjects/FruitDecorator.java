package Logic.GameObjects;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class FruitDecorator extends GameObject {
    protected Fruit fruit;
    public FruitDecorator(Fruit fruit) {
        super();
        this.fruit = fruit;
    }
    public Canvas getCanvas() {
        return this.fruit.getCanvas();
    }

    public void setCanvas(Canvas canvas) {
        this.fruit.setCanvas(canvas);
    }

    public Image getSlicedImage() {
        return fruit.getSlicedImage();
    }

    public void setSlicedImage(Image slicedImage) {
        this.fruit.setSlicedImage(slicedImage);
    }

    public void setSliced(boolean bool) {
        this.fruit.setSliced(bool);
    }

    public boolean isSliced() {
        return this.fruit.isSliced();
    }
}
