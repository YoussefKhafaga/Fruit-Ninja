package animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Timer {
    private Label tim;
    private int counter ;
    private Timeline timeline;

    public Timer(Label tim) {
        this.tim = tim;
        this.counter = 60;
    }
    public void startCountDown(){
       timeline = new Timeline(new KeyFrame(Duration.seconds(1),e->{
          tim.setText(""+counter);
          counter--;
      }));
      timeline.setCycleCount(counter+1);
      timeline.play();
  }

    public void startStopWatch(){

    }

    public Timeline getTimeline() {
        return timeline;
    }
}
