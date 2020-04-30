package Logic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class SpecialFruit1 extends  FruitDecorator {
Player p ;
    public SpecialFruit1(String st1,String st2) {
        super(st1,st2);
    }

    @Override
    public String getType() {
        return "SpecialFruit1";
    }
    public void scoreincrease(){
        if(isSliced()){
            p.setScore(p.getScore()+5);
        }
    }

}
