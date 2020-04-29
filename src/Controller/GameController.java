package Controller;

import Logic.GameLevels.Level;
import Logic.GameObject;
import Logic.Player;
import animation.Projector;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
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
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Label Score;
    @FXML
    private Button exit;
    @FXML
    private Button save;
    @FXML
    private HBox settings;
    private ArrayList<Projector> projectors = new ArrayList<>();
    private Timeline gameTimeLine;
    private Duration y;
    private Player player;
    private Level level;

    @FXML
    void keyPressed(KeyEvent event) {
        System.out.println(1234);
        settings.setDisable(false);
        settings.setVisible(true);
        if (event.getCode().equals(KeyCode.ESCAPE)) {
            gameTimeLine.stop();
            y = gameTimeLine.getCurrentTime();
            for (Projector projector : projectors) {
                projector.getPathTransition().stop();
                projector.setPause(projector.getPathTransition().getCurrentTime());
            }
            exit.setOnAction(e -> resumeGame());
            save.setOnAction(e -> saveGame());
        }
    }

    public GameController(Player player, Level level) {
        this.player = player;
        this.level = level;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                anchor.startFullDrag();
            }
        });
        gameTimeLine = new Timeline(new KeyFrame(Duration.millis(level.getDuration() + 2 * level.getDelay()), e -> {
            for (int i = 0; i < 3; i++) {
                Projector projector = new Projector(i * level.getDelay(), level.getDuration());
                PathTransition pathTransition = projector.getPathTransition();
                projectors.add(projector);
                anchor.getChildren().addAll(projector.getGameObject().getCanvas());
                slice(projector);
                pathTransition.setOnFinished(f -> {
                    projectors.remove(projector);
                    anchor.getChildren().remove(projector.getGameObject().getCanvas());
                });

            }
        }));
        gameTimeLine.setCycleCount(Timeline.INDEFINITE);
        gameTimeLine.playFrom(Duration.millis(4000));
    }

    private void slice(Projector projector) {
        projector.getGameObject().getCanvas().setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                projector.getGameObject().getCanvas().setDisable(true);
                projector.getGameObject().setSliced(true);
                player.setScore(player.getScore() + 1);
                Score.setText("Score : " + player.getScore());
                projector.getPathTransition().stop();
                projector.fade(anchor);
            }
        });
    }

    private void checkObject(GameObject gameObject) {
        if (!gameObject.isSliced()) {
            String type = gameObject.getType();
            if (type.equals("Fruit")||type.equals("SpecialFruit"))
                player.decreseLives();
        }

    }

    private void resumeGame() {
        settings.setDisable(true);
        settings.setVisible(false);
        gameTimeLine.playFrom(y);
        for (Projector projector : projectors) {
            projector.getPathTransition().playFrom(projector.getPause());
        }
    }

    private void saveGame() {

    }


}

