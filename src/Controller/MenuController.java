package Controller;

import javafx.animation.RotateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private AnchorPane anchor ;
    @FXML
    private Button btn1 = new Button("",new ImageView("boom.png"));
    @FXML
    private Button btn2 ;
    @FXML
    private ImageView watermelonbtn=new ImageView("watermelon.png");
    @FXML
    private ImageView strawberrybtn=new ImageView("strawberry.png");
    @FXML
    private ImageView bombbtn=new ImageView("bomb.png");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // btn1 = new Button("",new ImageView("boom.png"));
        btn1.setGraphic(new ImageView("watermelon.png"));
        btn2.setGraphic(new ImageView("watermelon.png"));
        RotateTransition rotateTransition = new RotateTransition(Duration.INDEFINITE,btn1);
        rotateTransition.setByAngle(180);
        rotateTransition.play();
        RotateTransition rotateTransition1 = new RotateTransition(Duration.INDEFINITE,btn2);
        rotateTransition1.setByAngle(180);
        rotateTransition1.play();
        Image image1 = new Image("blade.jpg");
        anchor.setCursor(new ImageCursor( image1 ,  20, 20));
        btn1.setOnDragDetected(event -> {
            btn1.setGraphic(new ImageView("watermelonSliced.png"));
            //main.start(Scene scene1);
        });
        btn2.setOnDragDetected(event -> {
            btn2.setGraphic(new ImageView("watermelonSliced.png"));
        });
    /* Image image = new Image("watermelon.png");
    gc1.drawImage(image,0,0);
    gc2.drawImage(image,0,0);
    gc3.drawImage(image,0,0);*/
    }
}