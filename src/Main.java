import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.GameObject;
import sample.ObjectFactory;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = FXMLLoader.<AnchorPane>load(getClass().getResource("Background.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        ObjectFactory factory = new ObjectFactory();
        GameObject factory1 = factory.createObject(4);
    }
    public static void main(String[] args) {

        launch(args);
    }

}

