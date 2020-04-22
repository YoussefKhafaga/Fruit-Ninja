package sample;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
    public Label tim;
    Timer timer = new Timer();
    private int i=60;
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println(i);
            tim.setText(Integer.toString(i));
            i--;
            if(i==-1) timerTask.cancel();

        }
    };
    public void runTimer(){
        timer.schedule(timerTask,60,1000);
    }
}
