package sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;


public class Main extends Application {
    Label scorelabel;
    Label l2;
    Button btn;
    int score,index;
    Stage primaryStage;
    Ellipse bird;
    Rectangle ground;
    ArrayList<Rectangle> columns;
    int W=800,H=700;
    int ticks,ymotion;
    Group root;
    boolean gameOver;
    Label l;
    LinearGradient ld;
    IntegerStringConverter str;
    Timeline tim;
    Scene scene;
    Image cloud;
    ImageView cloudv;
    int X,Y;
    DropShadow ds1;
    void addColumn()
    {
        int space=300;
        int width=100;
        int height=50+(int)(Math.random()*300);


        columns.add(new Rectangle(W+width+(columns.size()*200),H-height-120,width,height));
        columns.add(new Rectangle(W+width+(columns.size()-1)*200,0,width,H-height-space));

    }
    void Collision(){
        for(Rectangle column:columns)
        {
            if((column.getBoundsInParent().intersects(bird.getBoundsInParent())))
            {
                gameOver=true;
                if(bird.getCenterX()<=column.getX())
                    bird.setCenterX(column.getX()-2*bird.getRadiusX()+10);
                else
                {
                    if(column.getY()!=0)
                    {
                        bird.setCenterY(column.getY()-2*bird.getRadiusY());
                    }
                    else if(bird.getCenterY()>column.getHeight()){
                        bird.setCenterY(column.getHeight());
                    }
                }
            }


        }
        if(bird.getCenterY()>H-120||bird.getCenterY()<0)
        {
            gameOver=true;

        }

        if(gameOver)
        {
            bird.setCenterY(H-120-bird.getRadiusY());
            l.setText("GameOver\n   Score:"+str.toString(score/2));
            l.setFont(new Font("Arial",50));
            l.setLayoutX(primaryStage.getWidth()/2-130);
            l.setLayoutY(primaryStage.getHeight()/2-50);
            l.setTextFill(Color.ORANGE);


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
    void start1()
    {

        bird.setCenterX(W/2-10);
        bird.setCenterY(H/2-10);
        gameOver=false;
        ymotion=0;
        score=0;
        scorelabel.setText("Score"+str.toString(score));
        root.getChildren().remove(btn);
        root.getChildren().removeAll(columns);
        columns.clear();
        int i=0;
        while(i<20)
        {
            addColumn();
            i++;
        }
        l2.setText("Press UP key to start!!");
        l2.setFont(new Font("Arial",50));
        l2.setLayoutX(primaryStage.getWidth()/2-250);
        l2.setLayoutY(primaryStage.getHeight()/2-100);
        l2.setTextFill(Color.RED);


        tim.pause();
        root.getChildren().add(l2);

        scene.setOnKeyReleased(k -> {
            String code = k.getCode().toString();
            if(code=="UP")
            {

                root.getChildren().addAll(columns);
                root.getChildren().remove(l2);
                tim.play();

            }
        });
    }

    @Override
    public void start(Stage window) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("sample.fxml");
        loader.setLocation(xmlUrl);
        Parent root_ = loader.load();
        root = new Group();

        primaryStage = window;
        primaryStage.setScene(new Scene(root_));
        primaryStage.show();

        primaryStage.setTitle("Flappy Bird");
        primaryStage.setHeight(H);
        primaryStage.setWidth(W);
        primaryStage.setResizable(false);

        //root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Shadow for bird
        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(Color.GREY);
        //shadow for button
        DropShadow ds2 = new DropShadow();
        ds1.setOffsetY(4.0f);
        ds1.setOffsetX(4.0f);
        ds1.setColor(Color.BLACK);

        Image img=new Image(new FileInputStream("/Users/sachleenkaur/Downloads/flappy_assets/birdFrame0.png"));
        ImagePattern ip=new ImagePattern(img);


        cloud=new Image(new FileInputStream("/Users/sachleenkaur/Downloads/flappy_assets/cloud.png"));
        cloudv=new ImageView(cloud);
        X=W+(int)cloud.getWidth();
        cloudv.setX(X);
        Y=10+(int)(Math.random()*100);
        cloudv.setY(Y);

        bird=new Ellipse();
        bird.setFill(ip);
        bird.setRadiusX((img.getWidth()/2)+2);
        bird.setRadiusY((img.getHeight()/2)+2);
        bird.setCenterX(W/2-10);
        bird.setCenterY(H/2-10);
        bird.setEffect(ds1);

        index=0;
        ymotion=0;

        str=new IntegerStringConverter();

        l=new Label();
        l2=new Label();
        scorelabel=new Label();
        //scorelabel.setText("Score"+str.toString(score));
        scorelabel.setFont(new Font("Arial",20));

        ld=new LinearGradient(0.0, 0.0, 1.0, 0.0, true,
                CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.GREY),
                new Stop(1.0, Color.BLACK));

        columns=new ArrayList<Rectangle>();

        ground=new Rectangle(0,H-120,W,120);
        ground.setFill(Color.DARKGREEN);

        tim=new Timeline();
        tim.setCycleCount(Animation.INDEFINITE);


        gameOver=false;

        btn = new Button();
        btn.setText("Restart");
        btn.setTranslateX(350);
        btn.setTranslateY(600);
        btn.setPrefSize(100,50);
        btn.setTextFill(Color.BLUE);
        btn.setFont(new Font("Arial",20));
        btn.setEffect(ds2);

        KeyFrame kf=new KeyFrame(Duration.millis(20),e -> {

            ticks++;
            if(ticks%2==0&&ymotion<15)
            {
                ymotion=ymotion+2;

            }
            X=X-2;
            cloudv.setX(X);
            if(X<(0-(int)cloud.getWidth()))
            {
                X=W+(int)cloud.getWidth();
                cloudv.setX(X);
                Y=10+(int)(Math.random()*100);
                cloudv.setY(Y);
            }
            int y=(int)bird.getCenterY()+ymotion;
            bird.setCenterY(y);
            scene.setOnKeyReleased(k -> {
                String code = k.getCode().toString();
                if(code=="UP")
                {
                    Jump();
                }
            });
            Collision();
            if(gameOver)
            {

                if(!(root.getChildren().contains(l)))
                    root.getChildren().addAll(l,btn);
                btn.setOnMouseClicked(k ->
                {
                    root.getChildren().remove(l);
                    start1();

                });

            }



        });

        KeyFrame kf2 = new KeyFrame(Duration.millis(20),e->{

            for(int i=0;i<columns.size();i++)
            {


                Rectangle column=columns.get(i);
                column.setFill(ld);
                column.setEffect(ds1);
                column.setX((column.getX()-5));

                if(column.getY()==0&&bird.getCenterX()+bird.getRadiusX()>column.getX()+column.getWidth()/2-5&&bird.getCenterX()+bird.getRadiusX()<column.getX()+column.getWidth()/2+5)
                {
                    score++;
                    scorelabel.setText("Score:"+str.toString(score/2));
                    scorelabel.setTextFill(Color.DARKBLUE);
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

        root.getChildren().add(cloudv);
        root.getChildren().addAll(scorelabel);
        root.getChildren().add(ground);
        root.getChildren().add(bird);

        scene=new Scene(root);
        scene.setFill(Color.LIGHTBLUE);
        start1();


        primaryStage.setScene(scene);
        primaryStage.setHeight(H);
        primaryStage.setWidth(W);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

