package Logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public  abstract class GameObject {
    private Canvas canvas;
    private boolean isSliced;
    private Image slicedImage;

    public GameObject(String image1 , String image2){
        this.canvas = new Canvas(40,40);
        this.isSliced = false;
        GraphicsContext gc = this.getCanvas().getGraphicsContext2D();
        gc.drawImage(new Image(image1),0,0,40,40);
        slicedImage = new Image(image2);
    }
    public Canvas getCanvas() {
        return this.canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Image getSlicedImage() {
        return slicedImage;
    }

    public void setSlicedImage(Image slicedImage) {
        this.slicedImage = slicedImage;
    }

    public void setSliced(boolean bool) {
        this.isSliced=bool;
    }

    public boolean isSliced() {
        return this.isSliced;
    }

    public abstract String getType();
    public abstract void scoreincrease();


}
