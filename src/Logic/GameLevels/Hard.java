package Logic.GameLevels;

public class Hard implements LevelState {
    private Double delay;
    private Double duration;

    public Hard() {
        this.delay = 200.0;
        this.duration = 4000.0;
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
