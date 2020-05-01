import Controller.GameController;
import Logic.GameLevels.Easy;
import Logic.GameLevels.LevelState;
import Logic.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        Model model = new Model();
        LevelState easyLevelState = new Easy();
        loader.setLocation(getClass().getResource("Background.fxml"));
        GameController gameController = new GameController(model);
        loader.setController(gameController);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

