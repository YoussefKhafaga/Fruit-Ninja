package Logic.GameLevels;

public class Easy implements Level {
    private Double delay;
    private Double duration;
    public Easy(){
        this.delay = 200.0;
        this.duration = 5000.0;
    }
    @Override
    public Double getDelay() {
        return this.delay;
    }

    @Override
    public Double getDuration() {
        return this.duration;
    }

    @Override
    public void setDelay(Double decrease) {

    }

    @Override
    public void setDuration(Double duration) {

    }
}
