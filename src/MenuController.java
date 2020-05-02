//import Scenes;

import Logic.FileAccess.FileRead;
import Logic.Mementos.Model;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.ParseException;


public class MenuController implements Initializable {
    private AudioClip game = new AudioClip(this.getClass().getResource("fruitninja.mp3").toString());
    private AudioClip slice = new AudioClip(this.getClass().getResource("slice.wav").toString());
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView watermelon;
    @FXML
    private ImageView strawberry;
    @FXML
    private ImageView bomb;
    private GameController gameController ;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        Image image1 = new Image("cartoon.png");
        anchor.setCursor(new ImageCursor( image1 ,50, 50));
        game.setCycleCount(-1);
        game.play();
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                anchor.startFullDrag();
            }
        });
        watermelon.setOnDragDetected(event -> {
             slice.play();
            try {
                startClassic();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        strawberry.setOnDragDetected(event -> {
             slice.play();
            try {
                startArcade();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bomb.setOnDragDetected(event -> {
            slice.play();
            try {
                    startLoad();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        });
    }

    private void startArcade() throws IOException {
            game.stop();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("background.fxml"));
            Stage stage = (Stage) anchor.getScene().getWindow();
            gameController = new GameController("Arcade");
            loader.setController(gameController);
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

    }
    private void startClassic() throws IOException {
        game.stop();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("background.fxml"));
        Stage stage = (Stage) anchor.getScene().getWindow();
        gameController = new GameController("Classic");
        loader.setController(gameController);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    private void startLoad() throws IOException {
        game.stop();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("background.fxml"));
        Stage stage = (Stage) anchor.getScene().getWindow();
        gameController = new GameController("Load");
        loader.setController(gameController);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}