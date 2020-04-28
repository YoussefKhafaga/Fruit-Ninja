package Controller;

import Logic.GameObject;
import animation.Projector;
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
import java.util.ArrayList;
import java.util.ResourceBundle;


public class GameController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane anchor;
    @FXML
    Label Score;
    @FXML
    Button exit;
    @FXML
    Button save;
    @FXML
    HBox settings;
    private Projector [] projectors = {
            new Projector()
    };
    Duration x;
    Duration y;

    public void keyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            settings.setDisable(false);
            settings.setVisible(true);
            for (Projector projector : projectors) {
                projector.getTimeline().pause();
                projector.getPathTransition().pause();
                x = projector.getTimeline().getCurrentTime();
                y = projector.getPathTransition().getCurrentTime();
            }
        }
    }

    private int i = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                keyPressed(event);
            }
        });

       // for(Projector projector : projectors){
        Projector projector = new Projector();
            projector.generateTimeLine(anchor, 200.0,5001.0);
            Timeline timeline = projector.getTimeline();
            projectors[0]=projector;
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.playFrom(Duration.seconds(4));
            anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    slice(event,projector);
                }
            });
      //  }

        exit.setOnAction(e -> resumeGame());
        save.setOnAction(e -> saveGame());
    }

    private void slice(MouseEvent event, Projector projector) {
        anchor.startFullDrag();
        GameObject gameObject = projector.getGameObject();
        gameObject.getCanvas().setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                gameObject.getCanvas().setDisable(true);
                gameObject.setSliced(true);
                Score.setText("Score : " + ++i);
                projector.getPathTransition().stop();
                projector.fade(anchor);
            }
        });
    }

    private void checkObject(GameObject gameObject) {
        if (!gameObject.isSliced()) {
            String type = gameObject.getType();
            if (type.equals("watermelon.png") || type.equals("strawberry.png") || type.equals("Banana.png")) ;
        }

    }

    private void resumeGame() {
        settings.setDisable(true);
        settings.setVisible(false);
        for (Projector projector : projectors) {
            Timeline timeline = projector.getTimeline();
            timeline.playFrom(x);
            projector.getPathTransition().playFrom(y);
            System.out.println(x);
            System.out.println(y);
        }
    }

    private void saveGame() {

    }


}

