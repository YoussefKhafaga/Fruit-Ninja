import Controller.GameController;
import Logic.GameLevels.Easy;
import Logic.GameLevels.Level;
import Logic.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.net.URL;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Player player = new Player();
        Level easyLevel = new Easy();
        loader.setLocation(getClass().getResource("Background.fxml"));
        GameController gameController = new GameController(player,easyLevel);
        loader.setController(gameController);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getRoot().requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }

}

