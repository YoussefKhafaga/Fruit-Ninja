package Controller;

import Logic.GameLevels.LevelState;
import Logic.GameLevels.Level;
import Logic.Model;
import animation.Projector;
import animation.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    @FXML
    private ImageView freeze;
    @FXML
    private ImageView life1;
    @FXML
    private ImageView life2;
    @FXML
    private ImageView life3;
    @FXML
    private ImageView gameOver;
    @FXML
    private Label timerLabel;
    @FXML
    private AnchorPane anchor;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label Score;
    @FXML
    private Button save;
    private ArrayList<Projector> projectors;
    private Timeline gameTimeLine;
    private Duration y;
    private LevelState levelState;
    private Level l ;
    private Image blade = new Image("cartoon.png");
    private Canvas c1 = new Canvas(40, 40);
    private GraphicsContext gc = c1.getGraphicsContext2D();
    private Timer timer;
    private Model model;

    @FXML
    void keyPressed(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ESCAPE)) {
            gameTimeLine.stop();
            y = gameTimeLine.getCurrentTime();
            for (Projector projector : projectors) {
                projector.getPathTransition().stop();
                projector.setPause(projector.getPathTransition().getCurrentTime());
            }
            save.setOnAction(e -> saveGame());
        }
    }

    public GameController(Model model) {
        this.projectors = model.getProjectors();
        this.l=new Level(model.getScore());
        this.model = model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchor.setCursor(new ImageCursor(blade, 20, 20));
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                anchor.startFullDrag();
            }
        });
        startGame();
        startTimer();

    }

    private void saveGame() {

    }

    private void startGame() {
        gameTimeLine = new Timeline(new KeyFrame(Duration.millis(l.getDuration() + 3* l.getDelay()), e -> {
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                int x = random.nextInt(5);
                if (x < 4) {
                    Projector projector = new Projector(i * l.getDelay(), l.getDuration());
                    PathTransition pathTransition = projector.getPathTransition();
                    projectors.add(projector);
                    anchor.getChildren().addAll(projector.getGameObject().getCanvas());
                    slice(projector);
                    pathTransition.setOnFinished(f -> {
                        projector.getGameObject().checkObject(model);
                        checkLives();
                        projectors.remove(projector);
                        anchor.getChildren().remove(projector.getGameObject().getCanvas());
                    });
                }
            }
        }));
        gameTimeLine.setCycleCount(Timeline.INDEFINITE);
        gameTimeLine.playFrom(Duration.millis(4000));
    }

    private void slice(Projector projector) {
        projector.getGameObject().getCanvas().setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                if(projector.getGameObject().getType().equals("FreezingFruit")){
                    freeze.setVisible(true);
                    Timeline freezeTimeLine = new Timeline(new KeyFrame(Duration.seconds(3.0), e ->{
                    }));
                    freezeTimeLine.play();
                    freezeTimeLine.setOnFinished(e-> freeze.setVisible(false));
                }
                model.setProjectors(projectors);
                projector.getGameObject().slice(model, gameTimeLine, y);
                Score.setText("Score : " + model.getScore());
                l.setLevelState(model.getScore());
                checkLives();
                projector.getPathTransition().stop();
                projector.fade(anchor);
                projectors.remove(projector);
            }
        });
    }

    private void endGame() {
        gameTimeLine.stop();
        timer.getTimeline().stop();
        for (Projector projector : projectors) {
            projector.getPathTransition().stop();
            projector.getGameObject().getCanvas().setDisable(true);
            projector.getGameObject().getCanvas().setVisible(false);

        }
        gameOver.setVisible(true);
        life3.setVisible(true);
        life2.setVisible(true);
        life1.setVisible(true);
    }

    private void startTimer() {
        timer = new Timer(timerLabel);
        timer.startCountDown();
        timer.getTimeline().setOnFinished(e -> {
            endGame();
        });
    }

    private void checkLives() {
        if (model.getLives() == 3) {

        } else if (model.getLives() == 2) {
            life1.setVisible(false);
        } else if (model.getLives() == 1) {
            life2.setVisible(false);
        } else if (model.getLives() == 0) {
            life3.setVisible(false);
        } else if (model.getLives() < 0) {
            endGame();
        }
    }

    private void loadGame() {
        Score.setText("" + model.getScore());
        checkLives();
        projectors = this.model.getProjectors();
        Timeline load = new Timeline(new KeyFrame(Duration.seconds(levelState.getDuration() + 3* levelState.getDelay()), e ->{
            for (int i = 0; i < projectors.size(); i++) {
                Projector projector = projectors.get(i);
                projector.getPathTransition().playFrom(projector.getPause());
                slice(projector);
                projector.getPathTransition().setOnFinished(me -> {
                    projectors.remove(projector);
                });
            }
        }));
        load.play();
        load.setOnFinished(e->{
            startGame();
        });


    }


}

