package Controller;
import animation.Render;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import sample.GameObject;
import sample.Time;

public class GameController {
    Render render;
    @FXML
    AnchorPane anchor;
        Duration x;
        public Label tim = new Label();
    private GameObject gameObject;
    @FXML
    void initialize() {
        Time time = new Time();
        time.runTimer();
        tim.setLayoutX(100);
        tim.setLayoutY(100);
        Button btn = new Button("",new ImageView("pause.png"));
        btn.setLayoutX(75);
        btn.setLayoutY(-75);
        Image image = new Image(("x red.png"));
        Label x1 = new Label("",new ImageView("X.png"));
        x1.setLayoutX(75);
        x1.setLayoutY(-100);
        Label x2 = new Label("",new ImageView("X.png"));
        x2.setLayoutX(105);
        x2.setLayoutY(-100);
        Label x3 = new Label("",new ImageView("X.png"));
        x3.setLayoutX(135);
        x3.setLayoutY(-100);
        render = new Render();
        final Boolean[] t = {true};
        SequentialTransition sequentialTransition = new SequentialTransition();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            gameObject = render.createObject();
            Canvas canvas =gameObject.getCanvas();
            anchor.getChildren().addAll(canvas);
            PathTransition pathTransition = render.generateTransitions(gameObject);
            sequentialTransition.getChildren().add(pathTransition);
            sequentialTransition.play();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
            anchor.getChildren().addAll(tim,btn,x1,x2,x3);
            btn.setOnAction(me->{
                if(t[0]) {
                    x1.setGraphic(new ImageView(image));
                    t[0] =false;
                    timeline.pause();
                    sequentialTransition.pause();
                    x = sequentialTransition.getCurrentTime();}
                else{
                    t[0] =true;
                    timeline.playFrom(x);
                    sequentialTransition.playFrom(x);

                }
            });
    }
}