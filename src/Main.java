import Controller.GameController;
import Logic.Fruit;
import Logic.GameLevels.Easy;
import Logic.GameLevels.Level;
import Logic.GameObject;
import Logic.Model;
import Logic.Player;
import animation.Render;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Model model = new Model();
        Level easyLevel = new Easy();
        loader.setLocation(getClass().getResource("Background.fxml"));
        GameController gameController = new GameController(model);
        loader.setController(gameController);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Render render = Render.getInstance();
        GameObject gameObject = new Fruit("watermelon.png","watermelonSliced.png","watermellon") ;
        PathTransition pathTransition = render.generateTransitions(gameObject,5000.0);
        Path x = (Path) pathTransition.getPath();
        MoveTo move = (MoveTo) x.getElements().get(0);
        launch(args);
    }

}

