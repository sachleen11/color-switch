package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.sun.javafx.application.PlatformImpl.exit;

public class Main extends Application {
    int width = 500;
    int height = 500;

    public void exitGame(){
        return;
    }

    protected void SetUp(Pane mainPage) throws Exception{
        Font gamefont = Font.font(30);

        Button Start = new Button("START GAME");
        Start.setFont(gamefont);
        Start.setOnAction(event -> exit());
        Start.setId("shiny-orange");
        Start.setMaxWidth(160);


        Button Exit = new Button("EXIT GAME");
        Exit.setFont(gamefont);
        Exit.setOnAction(event -> exit());
        Exit.setId("shiny-orange");
        Exit.setMaxWidth(160);

        FileInputStream input = new FileInputStream("/Users/sachleenkaur/sem3/ap/color-switch/star.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setTranslateX(-210);
        imageView.setTranslateY(-340);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setPreserveRatio(true);

        Text t = new Text();
        //String t = "BEST SCORE";
        t.setText("7");
        t.setFont(new Font("Verdana",20));
        t.setFill(Color.WHITE);
        t.setTranslateX(-180);
        t.setTranslateY(-338);

        Text t2 = new Text();
        //String t = "BEST SCORE";
        t2.setText("BEST SCORE: 7");
        t2.setFont(new Font("Verdana",20));
        t2.setFill(Color.WHITE);
        t2.setTranslateX(160);
        t2.setTranslateY(-340);
        //Group img = new Group(imageView);

        VBox vbox = new VBox(40,Start, Exit);

        vbox.setTranslateX(170);
        vbox.setTranslateY(500);

        mainPage.getChildren().addAll(vbox,imageView,t,t2);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane root = new StackPane();
        SetUp(root);
        root.setId("pane");
        Scene scene = new Scene(root, 500, 750);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        //Scene s_img = new Scene(img, 500,600);
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(scene);
        //primaryStage.setScene(s_img);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
