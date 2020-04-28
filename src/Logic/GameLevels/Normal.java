package Logic.GameLevels;

public class Normal implements Level {
    private Double delay;
    private Double duration;
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
