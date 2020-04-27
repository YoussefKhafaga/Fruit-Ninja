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
    private Projector[] projectors = new Projector[1];

    @FXML
    public void keyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
                settings.setDisable(false);
                settings.setVisible(true);
            for(Projector projector : projectors){
                projector.getTimeline().pause();
                projector.getPathTransition().pause();
                projector.setPause(projector.getPathTransition().getCurrentTime());
            }
        }
    }
    private int i = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Projector projector = new Projector();
        projectors[0] = projector;
        projector.generateTimeLine(anchor);
        Timeline timeline = projector.getTimeline();
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slice(event, projector);
            }
        });
        timeline.playFrom(Duration.seconds(4));
        timeline.setCycleCount(-1);
        exit.setOnAction(e->exitGame());
        save.setOnAction(e->saveGame());

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
                projector.fade();
            }
        });
    }

    private void checkObject(GameObject gameObject) {
        if (!gameObject.isSliced()) {
            String type = gameObject.getType();
            if (type.equals("watermelon.png") || type.equals("strawberry.png") || type.equals("Banana.png")) ;
        }

    }
    private void exitGame(){
        settings.setDisable(true);
        settings.setVisible(false);
        for(Projector projector : projectors){
            projector.getTimeline().play();
            projector.getPathTransition().playFrom(projector.getPause());
        }
    }

    private void saveGame() {

    }


}

