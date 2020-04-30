import Controller.GameController;
import Logic.FileAccess.FileRead;
import Logic.FileAccess.FileWrite;
import Logic.Fruit;
import Logic.GameLevels.Easy;
import Logic.GameLevels.Level;
import Logic.GameObject;
import Logic.Model;
import animation.Projector;
import animation.Render;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;


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
    public static void main(String[] args){
        launch(args);
    }

}

