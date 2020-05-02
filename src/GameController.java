import Logic.FileAccess.FileRead;
import Logic.FileAccess.FileWrite;
import Logic.GameLevels.Level;
import Logic.Mementos.CareTaker;
import Logic.Mementos.Memento;
import Logic.Mementos.Model;
import animation.Projector;
import animation.Timer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    URL resource = getClass().getResource("slice.wav");
    Media media = new Media(resource.toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
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
    @FXML
    private Button exit;
    @FXML
    private Button restart;
    private FileRead fileRead = new FileRead("file.xml");
    private String mode;
    private ArrayList<Projector> projectors = new ArrayList<>();
    private Timeline gameTimeLine;
    private int highScore;
    private Level level;
    private Timer timer;
    private Model model;
    private CareTaker careTaker;
    public GameController(String mode){
        this.mode = mode;
        highScore = fileRead.getHighScore();
        this.model = new Model();
        careTaker = new CareTaker();
        careTaker.setCurrentMemento(new Memento(model,highScore));
    }
    private void saveGame() throws ParserConfigurationException, IOException, ParseException {
        save.setDisable(true);
        gameTimeLine.pause();
        for(Projector projector : projectors){
            projector.getPathTransition().pause();
            projector.setPause(projector.getPathTransition().getCurrentTime());
        }
        model.setProjectors(projectors);
        careTaker.setCurrentMemento(new Memento(model,highScore));
        careTaker.getCurrentMemento().saveModel();
        exitGame(0);
    }
    private void exitGame(int x) throws IOException, ParseException, ParserConfigurationException {
        if(x!=0){
            FileWrite fileWrite = new FileWrite("file.xml");
            Model model = fileRead.getSavedModel();
            fileWrite.saveModel(model,highScore);
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainMenu.fxml"));
        Stage stage = (Stage) anchor.getScene().getWindow();
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private void startGame() {
        gameTimeLine = new Timeline(new KeyFrame(Duration.millis(level.getDuration() + 3 * level.getDelay()), e -> {
            for (int i = 0; i < 4; i++) {
                Random random = new Random();
                int x = random.nextInt(10);
                if (x < 8) {
                    Projector projector = new Projector(i * level.getDelay(), level.getDuration(),mode);
                    PathTransition pathTransition = projector.getPathTransition();
                    projectors.add(projector);
                    anchor.getChildren().addAll(projector.getGameObject().getCanvas());
                    slice(projector);
                    pathTransition.setOnFinished(f -> {
                        projector.getGameObject().checkObject(model);
                        if(!mode.equals("Arcade")) checkLives();
                        projectors.remove(projector);
                        anchor.getChildren().remove(projector.getGameObject().getCanvas());
                    });
                }
            }
        }));
        gameTimeLine.setCycleCount(Timeline.INDEFINITE);
        gameTimeLine.playFrom(Duration.millis(4000));
        save.setOnAction(e->{
            try {
                saveGame();
            } catch (ParserConfigurationException | IOException | ParseException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void slice(Projector projector) {
        projector.getGameObject().getCanvas().setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                mediaPlayer.play();
                if (projector.getGameObject().getType().equals("FreezingFruit")) {
                    freeze.setVisible(true);
                    Timeline freezeTimeLine = new Timeline(new KeyFrame(Duration.seconds(3.0), e -> {
                    }));
                    freezeTimeLine.play();
                    freezeTimeLine.setOnFinished(e -> freeze.setVisible(false));
                }
                model.setProjectors(projectors);
                projector.getGameObject().slice(model, gameTimeLine);
                updateGame();
                projector.getPathTransition().stop();
                projector.fade(anchor);
                projectors.remove(projector);
            }
        });
    }

    private void endGame() {
        gameTimeLine.stop();
        if(mode.equals("Arcade"))timer.getTimeline().stop();
        for (Projector projector : projectors) {
            projector.getPathTransition().stop();
            projector.getGameObject().getCanvas().setDisable(true);
            projector.getGameObject().getCanvas().setVisible(false);

        }
        gameOver.setVisible(true);
        life3.setVisible(true);
        life2.setVisible(true);
        life1.setVisible(true);
        save.setVisible(false);
        save.setDisable(true);
        exit.setVisible(true);
        exit.setDisable(false);
        restart.setVisible(true);
        restart.setDisable(false);
    }

    private void startTimer() {
        timer = new Timer(timerLabel);
        timer.startCountDown();
        timer.getTimeline().setOnFinished(e -> {
            endGame();
        });
    }

    private void checkLives() {
        if (model.getLives() == 2) {
            life1.setVisible(false);
        } else if (model.getLives() == 1) {
            life2.setVisible(false);
        } else if (model.getLives() <= 0) {
            life3.setVisible(false);
            endGame();
        }
    }

    private void loadGame() throws ParseException {
        model = fileRead.getSavedModel();
        level = new Level(model.getScore());
        Score.setText("Score:" + model.getScore());
        checkLives();
        if(model.getProjectors().size()!=0){
            Timeline freeze = new Timeline(new KeyFrame(Duration.millis(level.getDuration() + 3* level.getDelay()), e ->{}));
            freeze.play();
            freeze.setOnFinished(e->{
                projectors = this.model.getProjectors();
                for (Projector projector : projectors) {
                    anchor.getChildren().add(projector.getGameObject().getCanvas());
                    projector.getPathTransition().playFrom(projector.getPause());
                    slice(projector);
                    projector.getPathTransition().setOnFinished(me -> {
                        projector.getGameObject().checkObject(model);
                        if(!mode.equals("Arcade")) checkLives();
                        projectors.remove(projector);
                        anchor.getChildren().remove(projector.getGameObject().getCanvas());
                    });
                }
            });
            Timeline load = new Timeline(new KeyFrame(Duration.millis(level.getDuration() + 3* level.getDelay()), e ->{}));
            load.setCycleCount(1);
            load.play();
            load.setOnFinished(e -> {
                projectors = new ArrayList<>();
                startGame();
            });
        }
        else {
            level = new Level(model.getScore());
            startGame();
        }


    }

    private void startArcade(){
        startTimer();
        life3.setVisible(false);
        life2.setVisible(false);
        life1.setVisible(false);
        save.setVisible(false);
        save.setDisable(true);
        startGame();
    }

    private void updateGame(){
        Score.setText("Score : " + model.getScore());
        level.setLevelState(model.getScore());
        if(!mode.equals("Arcade")) checkLives();
        updateHighScore();
        careTaker.setCurrentMemento(new Memento(model,highScore));

    }

    private void restartGame(){
        model = new Model();
        projectors = new ArrayList<>();
        careTaker = new CareTaker();
        Memento memento = new Memento(model,highScore);
        careTaker.setCurrentMemento(memento);
        Score.setText("Score:"+0);
        life3.setVisible(true);
        life3.setVisible(true);
        life3.setVisible(true);
        save.setVisible(true);
        save.setDisable(false);
        exit.setVisible(false);
        exit.setDisable(true);
        restart.setVisible(false);
        restart.setDisable(true);
        gameOver.setVisible(false);
        if(mode.equals("Arcade"))startArcade();
        else startGame();
    }

    private void updateHighScore() {
        if (model.getScore() > highScore) {
            timerLabel.setText("HighScore" + model.getScore());
            highScore = model.getScore();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image blade = new Image("cartoon.png");
        anchor.setCursor(new ImageCursor(blade, 40, 40));
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                anchor.startFullDrag();
            }
        });
        if (mode.equals("Arcade")) {
            this.level = new Level(20);
            startArcade();
        } else if (mode.equals("Classic")) {
            this.level =new Level(model.getScore());
            Score.setText("Score:"+model.getScore());
            timerLabel.setText("HighScore:"+highScore);
            startGame();
        }else if (mode.equals("Load")){
            timerLabel.setText("HighScore:"+highScore);
            {
                try {
                    loadGame();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
        restart.setOnAction(e->{
            restartGame();
        });
        save.setOnAction(e->{
            try {
                saveGame();
            } catch (ParserConfigurationException | IOException | ParseException ex) {
                ex.printStackTrace();
            }
        });
        exit.setOnAction(e->{
            try {
                exitGame(1);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParseException ex) {
                ex.printStackTrace();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            }
        });

    }
}

