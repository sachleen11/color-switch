package application;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import java.util.Random;
import javafx.scene.media.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.shape.Arc;
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

class gameElements{
	int position;
	int getPosition() {
		return 0;
	}
	void setPosition() {

	}
	void disappear() {}
	void action() {}

}

class staticElements extends gameElements{
	int size;
	int getSize() {
		return 0;
	}
	void setSize() {

	}
}

class dynamicElements extends gameElements{
	int size;
	int speed;
}

class obstacle extends dynamicElements{

	int getsize(){
		return 0;
	}
	void setsize(){

	}
	Color getcolor() {
		return Color.BLACK;

	}
	void setcolor(){

	}
	int getspeed() {
		return 0;
	}
	void setspeed() {

	}
	void display() {

	}

}

class Player{
	int stars;
}



public class Main extends Application {

	static int speed = 5;
	static int width = 20;
	static int height = 35;
	static int stars=0;
	static int x=0;
	static int y=0;
	static int cornersize = 25;
	static ColorSwitch colorSwitch = new ColorSwitch(10,20);
	static List<List<Rectangle>> mega= new ArrayList<List<Rectangle>>();
	static Dir direction = Dir.left;
	static boolean gameOver = false;
	static ArcTo arcTo;

	static Random rand = new Random();


	public enum Dir {
		left, right, up, down
	}

    public void exitGame(){

        return;
    }

    class space{
    	int position=550;
    	public void tick(GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q,Button Start,Stage primaryStage, ImageView iv,ColorSwitch cs,Square sq,Cross cr,Diamond d) throws FileNotFoundException {
    		//speed++;
    		
    		
    		for (int i = obstacle.size() - 1; i >= 1; i--) {

    			mega.get(0).get(i).setX(mega.get(0).get(i - 1).getX());
    			//mega.get(0).get(i).setY(mega.get(0).get(i - 1).getY()+1);
    			//mega.get(0).get(i).setY(mega.get(0).get(i).getY()+1);
    			mega.get(1).get(i).setX(mega.get(1).get(i - 1).getX());
    			//mega.get(1).get(i).setY(mega.get(1).get(i).getY()+1);
    		}
//    		
//			for (int i=0;i<mega.get(0).size();i++) {
//				mega.get(1).get(0).setY(mega.get(1).get(0).getY()+1);
//				mega.get(0).get(0).setY(mega.get(0).get(0).getY()+1);
//			}

            Pane rt = new Pane();

            Button E = new Button("SAVE & EXIT GAME");
            E.setMaxWidth(200);
            E.setLayoutX(70);
            E.setLayoutY(500);
            E.setOnAction(event -> Platform.exit());

            Button Load = new Button("RESUME GAME");
            Load.setLayoutX(280);
            Load.setLayoutY(500);
            Load.setMaxWidth(200);
            E.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");
            Load.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");

            rt.getChildren().add(E);
            rt.getChildren().add(Load);
            BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\color_screen.png"),500,750,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                      BackgroundSize.DEFAULT);

            rt.setBackground(new Background(myBI));

            Scene scene3 = new Scene(rt, 500, 750);

		    		Start.setOnAction(event ->  primaryStage.setScene(scene3));
		    		boolean loop=true;
		    		switch (direction) {
		    		case up:

		    			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
		    			mega.get(1).get(0).setX(mega.get(1).get(0).getX()-30);
		    			
		        		for (int i = obstacle.size() - 1; i >= 0; i--) {

		        			mega.get(0).get(i).setY(mega.get(0).get(i).getY()+1);
		        			mega.get(1).get(i).setY(mega.get(1).get(i).getY()+1);
		        		}
		    			//mega.get(1).get(0).setY(mega.get(1).get(0).getY()+5);
		    			
		    			
		    			int i=(int)ball.circle.getCenterY();
		    			i=i-30;
		    			ball.circle.setCenterY(i);
		    			q.arc1.setStartAngle(q.arc1.getStartAngle()+45);
		    			q.arc2.setStartAngle(q.arc2.getStartAngle()+45);
		    			q.arc3.setStartAngle(q.arc3.getStartAngle()+45);
		    			q.arc4.setStartAngle(q.arc4.getStartAngle()+45);
		    			q.arc1.setCenterY(q.arc1.getCenterY()+1);
		    			q.arc2.setCenterY(q.arc2.getCenterY()+1);
		    			q.arc3.setCenterY(q.arc3.getCenterY()+1);
		    			q.arc4.setCenterY(q.arc4.getCenterY()+1);

    			break;
    			case down:

		    			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
		    			mega.get(1).get(0).setX(mega.get(0).get(0).getX()-30);
		    			int j=(int)ball.circle.getCenterY();
		    			j=j+30;
		    			ball.circle.setCenterY(j);

    			break;
    			case left:

		    			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
		    			mega.get(1).get(0).setX(mega.get(1).get(0).getX()-30);
		    			q.arc1.setStartAngle(q.arc1.getStartAngle()+30);
		    			q.arc2.setStartAngle(q.arc2.getStartAngle()+30);
		    			q.arc3.setStartAngle(q.arc3.getStartAngle()+30);
		    			q.arc4.setStartAngle(q.arc4.getStartAngle()+30);

    		      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
    		          @Override
    		          public void handle(MouseEvent e) {
    		  			int i=(int)ball.circle.getCenterY();
    					i=i-30;
    					ball.circle.setCenterY(i);
    		          }
    		       };

    			break;


    		}

    		gc.setFill(Color.web("061731",1.0));
    		gc.fillRect(0, 0, width * cornersize, height * cornersize);

    		gc.setFill(Color.web("F8FDE7",1.0));
    		Font f=Font.font("Proxima Nova",FontWeight.BOLD, (double)27);
    		gc.setFont(f);
    		gc.fillText(" " + stars, 40, 30);

    		Color cc = Color.WHITE;


    		cs.color=rand.nextInt(3)+1;
    		if (cs.color==1) {
    			cs.cir().setFill(Color.web("61D8A2",1.0));
    			
    			//gc.fillOval(240, 200, 30 , 30 );
    		}
    		if (cs.color==2) {
    			cs.cir().setFill(Color.web("ED476F",1.0));

    			//gc.fillOval(240, 200, 30 , 30 );
    		}
    		if (cs.color==3) {
    			cs.cir().setFill(Color.web("FAD167",1.0));

    			//gc.fillOval(240, 200, 30 , 30 );
    		}
    		if (cs.color==4) {
    			cs.cir().setFill(Color.web("368BB2",1.0));

    			//gc.fillOval(240, 200, 30 , 30 );
    		}

    		if (ball.circle.getCenterY()==710) {
    		for (int i=0;i<mega.get(0).size();i++) {
    			if (mega.get(0).get(i).getX()==240) {
    				String s1=ball.circle.getFill().toString();
    				String s2=mega.get(0).get(i).getFill().toString();
    				if (!s1.equals(s2)) {

    					gameOver=true;
    				}
    			}
    		}}

    		if (ball.circle.getCenterY()==20) {
    			gameOver=true;
    		}

    		if (mega.get(0).get(19).getX()==480) {
    			mega.get(1).get(0).setX(510);
    		}
    		if (mega.get(1).get(19).getX()==480) {
    			mega.get(0).get(0).setX(510);
    		}

    		if (ball.circle.getCenterY()==620) {
    			stars++;

    		}
//			primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
//				if (key.getCode() == KeyCode.Z) {
//
//
//					 ball.circle.setCenterY(ball.cir().getCenterY()-3);
//
//				}
//
//
//			});
            primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
            {//fctor:13
                public void handle(MouseEvent event) 
                {	//System.out.println(ball.cir().getCenterY());
                	//position-=5;
                	//int pos=(int)ball.cir().getCenterY();
                	if (ball.circle.getCenterY()>410) {
                    ball.circle.setCenterY(ball.cir().getCenterY()-2.3);}
                   // int pos2=(int)ball.cir().getCenterY();
                    
                	else if (ball.circle.getCenterY()<410) {
                    	//System.out.println("ji");
                		 //ball.circle.setCenterY(ball.cir().getCenterY()-3);
                		for (int i = obstacle.size() - 1; i >= 0; i--) {

                			mega.get(0).get(i).setY(mega.get(0).get(i).getY()+2);
                			mega.get(1).get(i).setY(mega.get(1).get(i).getY()+2);
                		}
                		iv.setY(iv.getY()+2);
                		cs.cir().setCenterY(cs.cir().getCenterY()+2);
                		
		    			q.arc1.setCenterY(q.arc1.getCenterY()+2);
		    			q.arc2.setCenterY(q.arc2.getCenterY()+2);
		    			q.arc3.setCenterY(q.arc3.getCenterY()+2);
		    			q.arc4.setCenterY(q.arc4.getCenterY()+2);
		    			//q.arc1.setCenterY(q.arc1.getCenterY()+2);
		    			sq.rectangle.setY(sq.rectangle.getY()+2);
		    			sq.rectangle2.setY(sq.rectangle2.getY()+2);
		    			sq.rectangle3.setY(sq.rectangle3.getY()+2);
		    			sq.rectangle4.setY(sq.rectangle4.getY()+2);
		    			cr.l.setStartY(cr.l.getStartY()+2);
		    			cr.l.setEndY(cr.l.getEndY()+2);
		    			cr.l2.setStartY(cr.l2.getStartY()+2);
		    			cr.l2.setEndY(cr.l2.getEndY()+2);
		    			cr.l3.setStartY(cr.l3.getStartY()+2);
		    			cr.l3.setEndY(cr.l3.getEndY()+2);
		    			cr.l4.setStartY(cr.l4.getStartY()+2);
		    			cr.l4.setEndY(cr.l4.getEndY()+2);
		    			d.l.setStartY(d.l.getStartY()+2);
		    			d.l.setEndY(d.l.getEndY()+2);
		    			d.l2.setStartY(d.l2.getStartY()+2);
		    			d.l2.setEndY(d.l2.getEndY()+2);
		    			d.l3.setStartY(d.l3.getStartY()+2);
		    			d.l3.setEndY(d.l3.getEndY()+2);
		    			d.l4.setStartY(d.l4.getStartY()+2);
		    			d.l4.setEndY(d.l4.getEndY()+2);
//		    			sq.rectangle2.setY(sq.rectangle2.getY()+2);
//		    			sq.rectangle3.setY(sq.rectangle3.getY()+2);
//		    			sq.rectangle4.setY(sq.rectangle4.getY()+2);


		    			
                    }

                }
            });
            
           // ball.circle.setCenterY(position);
            //mega.get(0).get(1).getY()>400
            if (ball.circle.getCenterY()<550) {
            	//System.out.println("ji");
            	
//                if (ball.cir().getCenterY()<400) {
//                	//System.out.println("ji");
//            		for (int i = obstacle.size() - 1; i >= 0; i--) {
//
//            			mega.get(0).get(i).setY(mega.get(0).get(i).getY()+1);
//            			mega.get(1).get(i).setY(mega.get(1).get(i).getY()+1);
//            		}
//                	//ball.circle.setCenterY(ball.cir().getCenterY()+3);
//                }
                
//                else {
               	ball.circle.setCenterY(ball.cir().getCenterY()+3);
//                }
            }
            


    		if (ball.circle.getCenterY()<cs.cir().getCenterY()+30 && ball.circle.getCenterY()>cs.cir().getCenterY()-30
    				) {
    			ball.color=colorSwitch.color;
    			//ball.circle.setFill(Color.web("61D8A2",1.0));
    			if (cs.color==1) {
    				ball.circle.setFill(Color.web("61D8A2",1.0));
    			}
    			if (cs.color==2) {
    				ball.circle.setFill(Color.web("ED476F",1.0));
    			}
    			if (cs.color==3) {
    				ball.circle.setFill(Color.web("FAD167",1.0));
    			}
    			if (cs.color==4) {
    				ball.circle.setFill(Color.web("368BB2",1.0));
    			}
    		}

    		if (gameOver) {

    			boolean b=false;
    			gc.setFill(Color.web("e63946",1.0));
    			gc.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 50));
    			gc.fillText("GAME OVER", 110, 75);

    			b=true;
    			int i=0;
    			while (i!=100000) {
    			ball.circle.setCenterY(ball.circle.getCenterY()-10);
    			i++;
				}
    			return;
    		}
    		int help=0;
    		help=1;




    	}

    }

	public static List<Rectangle> generate(GraphicsContext gc) {
		 List<Rectangle> Linear = new ArrayList<>();
		 int j=30;
		 for (int i=0;i<5;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j);
				r.setY(400);
				r.setWidth(30);
				r.setHeight(30);
				r.setFill(Color.web("ED476F",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		j=j+30;
}
		 for (int i=5;i<10;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j);
				r.setY(400);
				r.setWidth(30);
				r.setHeight(30);
				r.setFill(Color.web("61D8A2",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		j=j+30;
}
		 for (int i=10;i<15;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j);
				r.setY(400);
				r.setWidth(30);
				r.setHeight(30);
				r.setFill(Color.web("FAD167",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		j=j+30;
}
		 for (int i=15;i<20;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j);
				r.setY(400);
				r.setWidth(30);
				r.setHeight(30);
				r.setFill(Color.web("368BB2",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		j=j+30;
}

		return Linear;
	}



	public void start(Stage primaryStage) throws FileNotFoundException{
		try {

			Circle ball = new Circle(x, Color.DARKSLATEBLUE);
			Star s=new Star();
			Stardeco d1=new Stardeco();

			DropShadow dropShadow = new DropShadow();
			dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
			dropShadow.setColor(Color.PERU);
		      dropShadow.setHeight(5);

		      dropShadow.setWidth(5);
		      dropShadow.setRadius(5);
		      dropShadow.setOffsetX(3);
		      dropShadow.setOffsetY(2);

		      dropShadow.setSpread(5);
			ImageView p=s.star();
			Square sq=new Square();
			Quad q=new Quad();
			Diamond d=new Diamond();
			Cross cr=new Cross();
			var root = new Pane();
			Canvas c = new Canvas(width * cornersize, height * cornersize);

			GraphicsContext gc = c.getGraphicsContext2D();
			ball b=new ball(width/3,height/3);
			root.getChildren().add(c);
			root.getChildren().add(cr.line1());
			root.getChildren().add(cr.line2());
			root.getChildren().add(cr.line3());
			root.getChildren().add(cr.line4());
//
			root.getChildren().add(d.line1()); //right
			root.getChildren().add(d.line2());  //top
			root.getChildren().add(d.line3()); //left
			root.getChildren().add(d.line4());  //bottm

			root.getChildren().add(b.circle);
			root.getChildren().add(p);
			root.getChildren().add(d1.star());

			space sp=new space();
	        Button Start = new Button("PAUSE",d1.pause());
	        Start.setLayoutX(400);
	        Start.setLayoutY(9);
	        Start.setStyle("-fx-background-color: #061731;-fx-text-fill: #f1faee ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold");
	         root.getChildren().add(Start);
	        ColorSwitch cs=new ColorSwitch(200,250);
	        root.getChildren().add(cs.cir());
			root.getChildren().add(q.arc1());
			root.getChildren().add(q.arc2());
			root.getChildren().add(q.arc3());

			root.getChildren().add(q.arc4());
			root.getChildren().add(sq.square1()); //rm
			root.getChildren().add(sq.square2()); //lm
			root.getChildren().add(sq.square3()); //top
			root.getChildren().add(sq.square4());
			List<Rectangle> obstacle = generate(gc);
			List<Rectangle> obstacle2 = generate(gc);
			for (int i=0;i<20;i++) {
				root.getChildren().add(obstacle.get(i));
			}
			for (int i=0;i<20;i++) {
				root.getChildren().add(obstacle2.get(i));
			}

			mega.add(obstacle);
			mega.add(obstacle2);

			new AnimationTimer() {
				long lastTick = 0;

				public void handle(long now) {
					if (lastTick == 0) {
						lastTick = now;
						try {
							sp.tick(gc,obstacle,b,q,Start,primaryStage,p,cs,sq,cr,d);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						return;
					}

					if (now - lastTick > 1000000000 / speed-20) {
						lastTick = now;
						try {
							sp.tick(gc,obstacle,b,q,Start,primaryStage,p,cs,sq,cr,d);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}

			}.start();


			Scene scene2 = new Scene(root, 500, 600);

			scene2.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
				if (key.getCode() == KeyCode.W) {


					direction = Dir.up;

				}

				if (key.getCode() == KeyCode.A) {
					direction = Dir.left;
				}
				if (key.getCode() == KeyCode.S) {
					direction = Dir.down;
				}
				if (key.getCode() == KeyCode.D) {
					direction = Dir.right;
				}

			});

	        StackPane rt = new StackPane();
	        Game g=new Game();
	       g.SetUp(rt,scene2,primaryStage);
	        BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\color_screen.png"),500,750,false,true),
	                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	                  BackgroundSize.DEFAULT);


	        rt.setBackground(new Background(myBI));

	        rt.setId("pane");
	        Scene scene = new Scene(rt, 500, 750);

	        scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());

	        primaryStage.setTitle("Color Switch");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void gravity(ball ball) {
		int g=5;
		while (ball.circle.getCenterY()<800)
		ball.circle.setCenterY(ball.circle.getCenterY()+10);
		}

	public static void main(String[] args) {
		launch(args);
	}
}
