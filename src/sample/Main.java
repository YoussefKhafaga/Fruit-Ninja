package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        ObjectFactory factory = new ObjectFactory();
        GameObject factory1 = factory.createObject(4);
        Memento memento = new Memento();
        memento.Load();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
