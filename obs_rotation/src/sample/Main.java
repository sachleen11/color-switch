package sample;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;


import java.io.File;
import java.io.FileNotFoundException;

public class Main extends Application{

    Rectangle rectangle = new Rectangle();
    Rectangle rectangle2 = new Rectangle();
    Rectangle rectangle3 = new Rectangle();
    Rectangle rectangle4 = new Rectangle();


    void tick(){
        rectangle.setX();
    }

    int speed = 5;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {


        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(10);
        rectangle.setHeight(100);
        rectangle.setFill(Color.web("ED476F",1.0));

        rectangle2.setX(100);
        rectangle2.setY(100);
        rectangle2.setWidth(100);
        rectangle2.setHeight(10);
        rectangle2.setFill(Color.web("61D8A2",1.0));

        rectangle3.setX(200);
        rectangle3.setY(100);
        rectangle3.setWidth(10);
        rectangle3.setHeight(100);
        rectangle3.setFill(Color.web("FAD167",1.0));

        rectangle4.setX(100);
        rectangle4.setY(200);
        rectangle4.setWidth(110);
        rectangle4.setHeight(10);
        rectangle4.setFill(Color.web("368BB2",1.0));


        //Configuring Group and Scene
        Group root = new Group(rectangle,rectangle2,rectangle3,rectangle4);
        //root.getChildren().add(rectangle);
        //root.getChildren().add(rectangle2);
        //root.getChildren().add(rectangle3);
        //root.getChildren().add(rectangle4);

        Scene scene = new Scene(root,500,600, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotate Transition example");
        primaryStage.show();

        new AnimationTimer() {
            long lastTick = 0;

            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    tick();
                    return;
                }

                if (now - lastTick > 1000000000 / speed-20) {
                    lastTick = now;
                    tick();
                }
            }

        }.start();

    }



    public static void main(String[] args) {
        launch(args);
    }

}