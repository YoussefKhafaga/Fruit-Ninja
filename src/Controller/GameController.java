package Controller;

import animation.Render;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.GameObject;


public class GameController {
    Render render;

    @FXML
    AnchorPane anchor;
    @FXML
Label Score ;
        Duration x;
        int i=0;

    private GameObject gameObject;
    @FXML
    void initialize() {
        Button btn = new Button("pause");
        Button btn1 = new Button("unpause");
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        btn1.setLayoutX(250);
        btn1.setLayoutY(200);
        render = new Render();
        SequentialTransition sequentialTransition = new SequentialTransition();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            gameObject = render.createObject();
            Canvas canvas =gameObject.getCanvas();
            anchor.getChildren().addAll(canvas);
            PathTransition pathTransition = render.generateTransitions(gameObject);
            sequentialTransition.getChildren().add(pathTransition);
            sequentialTransition.play();
          canvas.setOnDragDetected(new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent event) {
                  canvas.startFullDrag();
                  canvas.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
                      @Override
                      public void handle(MouseDragEvent event) {
                           Score.setText("Score : "+ i++);
                      }
                  });

              }
          });

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
            anchor.getChildren().addAll(btn,btn1);
            btn.setOnAction(me->{
                timeline.pause();
                sequentialTransition.pause();
                x = sequentialTransition.getCurrentTime();
            });
            btn1.setOnAction(mee->{
                timeline.playFrom(x);
                sequentialTransition.playFrom(x);
            });
    }

}

