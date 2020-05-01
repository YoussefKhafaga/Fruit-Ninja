package Logic.GameLevels;

public class Normal implements LevelState {
    private Double delay;
    private Double duration;
    public Normal(){
        this.delay=300.00;
        this.duration=3500.00;
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
    public void setDelay(Double delay) {

    }

    @Override
    public void setDuration(Double duration) {

    }
}
