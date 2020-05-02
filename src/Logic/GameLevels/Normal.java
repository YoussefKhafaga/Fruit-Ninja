package Logic.GameLevels;

public class Normal implements LevelState {
    private Double delay;
    private Double duration;
    public Normal(){
        this.delay=400.0;
        this.duration=4500.0;
    }
    @Override
    public Double getDelay() {
        return this.delay;
    }

    @Override
    public Double getDuration() {
        return this.duration;
    }

}
