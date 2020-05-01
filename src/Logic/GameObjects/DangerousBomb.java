package Logic.GameObjects;

import Logic.Model;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class DangerousBomb extends GameObject {
    public DangerousBomb(String st1,String st2) {
        super(st1,st2);
    }

    @Override
    public String getType() {
        return "DangerousBomb";
    }

    @Override
    public void slice(Model model, Timeline gameTimeLine, Duration duration) {
        model.setLives(model.getLives()-1);
        this.getCanvas().setDisable(true);
        this.setSliced(true);
    }

    @Override
    public void checkObject(Model model) {

    }

}
