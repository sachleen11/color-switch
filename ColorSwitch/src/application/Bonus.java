package application;


import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import java.util.Random;
import javafx.scene.media.*;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javafx.scene.shape.Arc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;







public class Bonus {
    Label scorelabel;
    Label l2;
    Button restart;
    int score,index;
   // Stage primaryStage;
    Ellipse ball;
    ArrayList<Rectangle> columns;
    int W=500,H=650;
    int ticks,ymotion;
    Pane root = new Pane();
    boolean gameOver;
    Label l;
    LinearGradient obstacle_fill;
    IntegerStringConverter str;
    Timeline tim;
    Scene scene;
    int X,Y;
    Image star;
    DropShadow ds1;
    ImageView starv;
    ImageView starv2;
    ImageView starv3;
    Rectangle game_over_pop;
    double X_top;
    double Y_top;
    double X_bottom;
    double Y_bottom;
    

    void addColumn() throws FileNotFoundException {

        int space=200;
        int width=100;
        int height=50+(int)(Math.random()*300);


        Rectangle t1 = new Rectangle(W+width+(columns.size()*200),H-height,width,height);
        columns.add(t1);
        columns.add(new Rectangle(W+width+(columns.size()-1)*200,0,width,H-height-space));


    }
    void Collision(){
        for(Rectangle column:columns)
        {
            if((column.getBoundsInParent().intersects(ball.getBoundsInParent())))
            {
                gameOver=true;
                if(ball.getCenterX()<=column.getX())
                    ball.setCenterX(column.getX()-2*ball.getRadiusX()+10);
                else
                {
                    if(column.getY()!=0)
                    {
                        ball.setCenterY(column.getY()-2*ball.getRadiusY());
                    }
                    else if(ball.getCenterY()>column.getHeight()){
                        ball.setCenterY(column.getHeight());
                    }
                }
            }


        }
        if(ball.getCenterY()>H||ball.getCenterY()<0)
        {
            gameOver=true;

        }

        if(gameOver)
        {

            ball.setCenterY(H-25-ball.getRadiusY());
            /**/
            l.setText("Game Over\n  Score : "+str.toString(score/2));
            l.setFont(new Font("Proxima Nova",20));
            l.setLayoutX(500/2-30);
            l.setLayoutY(650/2-30);

            l.setTextFill(Color.web("041433",1.0));

        }
    }

    void Jump(){

        if(!gameOver){
            if(ymotion>0){
                ymotion=0;
            }
            ymotion=ymotion-10;
        }



    }
    void start1() throws FileNotFoundException {

        ball.setCenterX(W/2-10);
        ball.setCenterY(H/2-10);
        gameOver=false;
        ymotion=0;
        score=0;
        scorelabel.setText("Score"+str.toString(score));
        root.getChildren().remove(restart);
        root.getChildren().removeAll(columns);
        columns.clear();
        int i=0;
        while(i< 50)
        {
            addColumn();
            i++;
        }
        l2.setText("PLAY!");
        l2.setFont(new Font("Proxima Nova",50));
        l2.setLayoutX(500/2 - 50);
        l2.setLayoutY(650/2 - 100);
        l2.setTextFill(Color.WHITESMOKE);


        tim.pause();
        root.getChildren().add(l2);

        scene.setOnKeyReleased(k -> {
            String code = k.getCode().toString();
            if(code=="SPACE")
            {

                root.getChildren().addAll(columns);
                //root.getChildren().
                root.getChildren().remove(l2);
                tim.play();

            }
        });
    }
    
    
    public void startbonus(Stage primaryStage, Scene scene1) throws IOException{

    	root.setStyle("-fx-background-color:#061731");
//        primaryStage.setTitle("Color Switch: Jump Mode");
//        primaryStage.setHeight(H);
//        primaryStage.setWidth(W);
//        primaryStage.setResizable(false);

        Image img=new Image(new FileInputStream("C:\\\\Users\\\\ishik\\\\Downloads\\\\starf.png"));
        ImagePattern ip=new ImagePattern(img);

        star = new Image(new FileInputStream("C:\\\\Users\\\\ishik\\\\Downloads\\\\starf.png"));
        starv=new ImageView(star);
        starv.setFitHeight(15);
        starv.setFitWidth(15);
        X = W+(int)star.getWidth();
        starv.setX(X);
        Y = 10+(int)(Math.random()*100);
        starv.setY(Y);
        Button b=new Button("Exit");
        b.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				primaryStage.setScene(scene1);
				
			}});
      //  star = new Image(new FileInputStream("/Users/sachleenkaur/Downloads/flappy_assets/starf.png"));
        starv2=new ImageView(star);
        starv2.setFitHeight(15);
        starv2.setFitWidth(15);
        X = W+(int)star.getWidth() + 300;
        starv2.setX(X);
        Y = 140+(int)(Math.random()*100);
        starv2.setY(Y);

       // star = new Image(new FileInputStream("/Users/sachleenkaur/Downloads/flappy_assets/starf.png"));
        starv3=new ImageView(star);
        starv3.setFitHeight(15);
        starv3.setFitWidth(15);
        X = W+(int)star.getWidth() + 500;
        starv3.setX(X);
        Y = 140+(int)(Math.random()*100);
        starv3.setY(Y);

        ball=new Ellipse();
        ball.setFill(ip);
        ball.setRadiusX((img.getWidth()/12)+2);
        ball.setRadiusY((img.getHeight()/12)+2);
        ball.setCenterX(W/2-10);
        ball.setCenterY(H/2-10);

        index=0;
        ymotion=0;

        str=new IntegerStringConverter();

        l=new Label();
        l2=new Label();
        scorelabel=new Label();
        //scorelabel.setText("Score"+str.toString(score));
        scorelabel.setFont(new Font("Proxima Nova",20));

        Stop[] stop = {new Stop(0.5, Color.web("c0c0c0",1.0)),
                new Stop(1, Color.web("1f7a8c",1.0))//,
        };


        obstacle_fill = new LinearGradient(0, 1, 0, 0, true, CycleMethod.REFLECT, stop);
        columns=new ArrayList<Rectangle>();


        tim=new Timeline();
        tim.setCycleCount(Animation.INDEFINITE);


        gameOver=false;

        restart = new Button();
        restart.setText("Try Again");
        restart.setId("shiny-orange2");
        restart.setTranslateX(primaryStage.getWidth()/2- 40);
        restart.setTranslateY(primaryStage.getHeight()/2 + 20);



        KeyFrame kf=new KeyFrame(Duration.millis(20),e -> {

            ticks++;
            if(ticks%2==0&&ymotion<15)
            {
                ymotion=ymotion+2;

            }
            X=X-2;
            starv.setX(X);
            if(X<(0-(int)star.getWidth()))
            {
                X = W+(int)star.getWidth();
                starv.setX(X-100);
                Y=10+(int)(Math.random()*100);
                starv.setY(Y);
            }
            starv2.setX(X - 300);
            if(X<(0-(int)star.getWidth()))
            {
                X = W+(int)star.getWidth();
                starv2.setX(X);
                Y=10+(int)(Math.random()*100);
                starv2.setY(Y);
            }
            starv3.setX(X + 300);
            if(X<(0-(int)star.getWidth()))
            {
                X = W+(int)star.getWidth();
                starv3.setX(X+100);
                Y=10+(int)(Math.random()*100);
                starv3.setY(Y);
            }
            int y=(int)ball.getCenterY()+ymotion;
            ball.setCenterY(y);
            scene.setOnKeyReleased(k -> {
                String code = k.getCode().toString();
                if(code=="SPACE")
                {
                    Jump();
                }
            });
            Collision();
            if(gameOver)
            {

                if(!(root.getChildren().contains(l))) {

                    game_over_pop = new Rectangle();
                    game_over_pop.setX(primaryStage.getWidth()/2-130);
                    game_over_pop.setY(primaryStage.getHeight()/2-50);
                    game_over_pop.setWidth(300);
                    game_over_pop.setHeight(130);
                    game_over_pop.setFill(Color.WHITESMOKE);
                    game_over_pop.setStroke(Color.GREY);
                    game_over_pop.setStrokeWidth(5.0);
                    root.getChildren().add(game_over_pop);
                    root.getChildren().addAll(l, restart, b);
                }
                restart.setOnMouseClicked(k ->
                {
                    root.getChildren().remove(l);
                    root.getChildren().remove(game_over_pop);
                    try {
                        start1();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                });

            }
        });


        KeyFrame kf2 = new KeyFrame(Duration.millis(20),e->{

            for(int i=0;i<columns.size();i++)
            {


                Rectangle column=columns.get(i);
                column.setFill(obstacle_fill);
                column.setX((column.getX()-5));

                if(column.getY()==0&&ball.getCenterX()+ball.getRadiusX()>column.getX()+column.getWidth()/2-5&&ball.getCenterX()+ball.getRadiusX()<column.getX()+column.getWidth()/2+5)
                {
                    score++;
                    scorelabel.setText("Score "+str.toString(score/2));
                    scorelabel.setTextFill(Color.WHITESMOKE);
                }

            }

            for(int i=0;i<columns.size();i++)
            {

                Rectangle column=columns.get(i);

                if((column.getX()+column.getWidth())<0)
                {
                    columns.remove(i);
                }
            }

        });

        tim.getKeyFrames().addAll(kf,kf2);



        root.getChildren().add(starv);
        root.getChildren().add(starv2);
        root.getChildren().add(starv3);
        root.getChildren().addAll(scorelabel);
        root.getChildren().add(ball);

        scene=new Scene(root,500, 600);
        scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
        scene.setFill(Color.web("041433",1.0));
        start1();


        primaryStage.setScene(scene);
//        primaryStage.setHeight(H);
//        primaryStage.setWidth(W);
        primaryStage.show();
    	
    	
    	
    }
    
    

}
