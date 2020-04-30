package Logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class FatalBomb extends GameObject{
    private Image slicedImage;
Player p=new Player();
    public FatalBomb(String st1,String st2) {
        super(st1,st2);
    }

    @Override
    public String getType() {
        return "FatalBomb";
    }
public void scoreincrease(){
        if (isSliced()){
            p.decreaseLives();
        }
}
}
