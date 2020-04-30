package Logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DangerousBomb extends GameObject{
    private boolean isSliced;
    Player p=new Player();


    public DangerousBomb(String st1,String st2) {
        super(st1,st2);
    }

    @Override
    public String getType() {
        return "DangerousBomb";
    }

    @Override
    public void scoreincrease() {
        if (isSliced()){
            p.decreaseLives();
        }
    }
}
