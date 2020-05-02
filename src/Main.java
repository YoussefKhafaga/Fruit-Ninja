import Controller.GameController;
import Logic.FileAccess.FileRead;
import Logic.FileAccess.FileWrite;
import Logic.Mementos.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static FileRead fileRead = new FileRead("file.xml");
    public static int highScore =  fileRead.getHighScore();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        fileRead = new FileRead("file.xml");
        FileWrite fileWrite = new FileWrite("file.xml");
        Model model = new Model();
        loader.setLocation(getClass().getResource("Background.fxml"));
        GameController gameController = new GameController(model,"Classic",50);
        loader.setController(gameController);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
         launch(args);
    }



}

