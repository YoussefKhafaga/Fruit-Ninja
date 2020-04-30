package animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    private Label tim;
    private int counter ;
    private Timeline timeline;

    public StopWatch(Label tim) {
        this.tim = tim;
        this.counter = 60;
    }
  public void start(){
       timeline = new Timeline(new KeyFrame(Duration.seconds(1),e->{
          tim.setText(""+counter);
          counter--;
      }));
      timeline.setCycleCount(counter+1);
      timeline.play();
  }

    public Timeline getTimeline() {
        return timeline;
    }
}
