package Controller;

import Logic.GameObject;
import animation.TimeLineWrapper;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class GameController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane anchor;
    @FXML
    Label Score;
    @FXML
    Button resume;
    @FXML
    Button save;
    @FXML
    HBox pause;
    private TimeLineWrapper [] timeLineWrappers = new TimeLineWrapper[1];

    @FXML
    public void keyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            for(TimeLineWrapper timeLineWrapper : timeLineWrappers){
                timeLineWrapper.getTimeline().pause();
                timeLineWrapper.getPathTransition().pause();
            }
        }
    }
    private int i = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TimeLineWrapper timeLineWrapper = new TimeLineWrapper();
        timeLineWrappers[0] = timeLineWrapper;
        timeLineWrapper.generateTimeLine(anchor);
        Timeline timeline = timeLineWrapper.getTimeline();
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slice(event, timeLineWrapper);
            }
        });
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFrom(Duration.seconds(4));


    }

    private void slice(MouseEvent event, TimeLineWrapper timeLineWrapper) {
        anchor.startFullDrag();
        GameObject gameObject = timeLineWrapper.getGameObject();
        gameObject.getCanvas().setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                gameObject.getCanvas().setDisable(true);
                gameObject.setSliced(true);
                Score.setText("Score : " + ++i);
                timeLineWrapper.getPathTransition().stop();
                timeLineWrapper.fade();
            }
        });
    }

    private void checkObject(GameObject gameObject) {
        if (!gameObject.isSliced()) {
            String type = gameObject.getType();
            if (type.equals("watermelon.png") || type.equals("strawberry.png") || type.equals("Banana.png")) ;
        }

    }

    private void saveGame() {

    }


}

