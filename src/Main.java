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
        AnchorPane root = FXMLLoader.<AnchorPane>load(getClass().getResource("Background.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getRoot().requestFocus();
         URL resource = getClass().getResource("fruitninja.mp3");
         Media media = new Media(resource.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }

}

