package application;

import java.io.FileInputStream;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {
    protected void SetUp(Pane mainPage, Scene scene2, Stage primaryStage) throws Exception{

        Button Start = new Button("START GAME");
        Start.setOnAction(event ->  primaryStage.setScene(scene2));
        Start.setId("shiny-orange");
        Start.setMaxWidth(150);

        Button Exit = new Button("EXIT GAME");

        Exit.setOnAction(event -> Platform.exit());
        Exit.setId("shiny-orange");
        Exit.setMaxWidth(150);

        Button Load = new Button("LOAD GAME");
        Load.setOnAction(event ->  primaryStage.setScene(scene2));
        Load.setId("shiny-orange");
        Load.setMaxWidth(150);


        FileInputStream input = new FileInputStream("C:\\Users\\ishik\\Downloads\\starf.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(-210);
        imageView.setTranslateY(-340);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);

        Text t = new Text();
        t.setText("7");
        t.setFont(Font.font("Proxima Nova",FontWeight.BOLD,20));
        t.setFill(Color.WHITE);
        t.setTranslateX(-180);
        t.setTranslateY(-338);

        Text t2 = new Text();
        t2.setText("BEST SCORE: 7");
        t2.setFont(Font.font("Proxima Nova",FontWeight.BOLD,20));
        t2.setFill(Color.WHITE);
        t2.setTranslateX(160);
        t2.setTranslateY(-340);

        VBox vbox = new VBox(20,Start,Load, Exit);

        vbox.setTranslateX(170);
        vbox.setTranslateY(500);

        mainPage.getChildren().addAll(vbox,imageView,t,t2);
    }
}
