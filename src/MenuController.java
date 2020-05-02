//import Scenes;

import Logic.FileAccess.FileRead;
import Logic.Mementos.Model;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.text.ParseException;


public class MenuController implements Initializable {
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
//        URL resource = getClass().getResource("slice");
//        Media media = new Media(resource.toString());
//        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        anchor.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                anchor.startFullDrag();
            }
        });
        watermelon.setOnDragDetected(event -> {
            // mediaPlayer.play();
            try {
                startClassic();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        strawberry.setOnDragDetected(event -> {
            // mediaPlayer.play();
            try {
                startArcade();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bomb.setOnDragDetected(event -> {
            try {
                    startLoad();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        });
    }

    private void startArcade() throws IOException {
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