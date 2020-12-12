package application;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import java.util.Random;
import javafx.scene.media.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.event.Event;
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

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	final String ISHI_SCREEN = "C:\\Users\\ishik\\Downloads\\color_screen.png";
	final String SACH_SCREEN = "/Users/sachleenkaur/Downloads/ASSETS/color_screen.png";
	final String ISHI_STAR = "C:\\Users\\ishik\\Downloads\\starf.png";
	final String SACH_STAR = "/Users/sachleenkaur/Downloads/ASSETS/starf.png";
	private static final String filepath="C:\\Users\\ishik\\OneDrive\\Desktop\\obj.txt";
	ArrayList<Object> components=new ArrayList<>();
	static int mode=0;
	static float speed = 5;
	static int width = 20;
	static int height = 35;
	static int stars=0;
	static int x=0;
	static int y=0;
	static int cornersize = 25;
	static ColorSwitch colorSwitch = new ColorSwitch(10,20);
	static List<List<Rectangle>> mega=new ArrayList<>();
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
    	public void tick(GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q,Button Start,Stage primaryStage, ArrayList<ImageView> starlist,ColorSwitch cs,Square sq,Cross cr,Diamond d,Scene scene2,ArrayList<Object> comp) throws FileNotFoundException {
    		//speed++;
    		Pane rt = new Pane();

            Button E = new Button("SAVE & EXIT GAME");
            E.setMaxWidth(200);
            E.setLayoutX(70);
            E.setLayoutY(500);
            E.setOnAction(event -> Platform.exit());
           E.setOnAction(new EventHandler() {


				@Override
				public void handle(Event arg0) {
					ArrayList<Integer> balls= new ArrayList<>();
					try {						 
			            FileInputStream fileOut = new FileInputStream(filepath);
			            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
			            balls= (ArrayList<Integer>)objectOut.readObject();
			            balls.add((int)ball.circle.getCenterY());
			            
			            objectOut.close();
			            System.out.println("The Object  was succesfully read to a file");
			            fileOut.close();
			            objectOut.close();
			            
			 
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
					
					
					try {
						 
						FileOutputStream fi = new FileOutputStream(new File(filepath));
			            ObjectOutputStream oi = new ObjectOutputStream(fi);
			           
			            oi.writeObject(balls);
			            oi.close();
			            System.out.println("done");
			            fi.close();
			            
			 
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }


		          //  objectOut.close();
//					comp.add(gc);
//					comp.add(mega.get(0));
//					comp.add(mega.get(1));
//					comp.add(ball);
//					comp.add(q);
//					comp.add(starlist);
//					comp.add(cs);
//					comp.add(sq);
//					comp.add(cr);
//					comp.add(d);
					Platform.exit();
					
				}
            });

            Button Load = new Button("RESUME GAME");
            Load.setLayoutX(280);
            Load.setLayoutY(500);
            Load.setMaxWidth(200);
            Load.setOnAction(event -> primaryStage.setScene(scene2));
            
            E.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");
            Load.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");

            rt.getChildren().add(E);
            rt.getChildren().add(Load);
            BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream(ISHI_SCREEN),500,750,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                      BackgroundSize.DEFAULT);

            rt.setBackground(new Background(myBI));

            Scene scene3 = new Scene(rt, 500, 750);

		    		Start.setOnAction(event ->  primaryStage.setScene(scene3));
    		
		    		
		   if (primaryStage.getScene()==scene2) {
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
    					//System.out.println(q.arc1.getStartAngle());
		    			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
		    			mega.get(1).get(0).setX(mega.get(1).get(0).getX()-30);
		    			q.arc1.setStartAngle(q.arc1.getStartAngle()+3);
		    			q.arc2.setStartAngle(q.arc2.getStartAngle()+3);
		    			q.arc3.setStartAngle(q.arc3.getStartAngle()+3);
		    			q.arc4.setStartAngle(q.arc4.getStartAngle()+3);
		    			if (q.arc4.getStartAngle()>=360) {
		    				q.arc4.setStartAngle(q.arc4.getStartAngle()-360);
		    			}
		    			if (q.arc1.getStartAngle()>=360) {
		    				q.arc1.setStartAngle(q.arc1.getStartAngle()-360);
		    			}
		    			if (q.arc2.getStartAngle()>=360) {
		    				q.arc2.setStartAngle(q.arc2.getStartAngle()-360);
		    			}
		    			if (q.arc3.getStartAngle()>=360) {
		    				q.arc3.setStartAngle(q.arc3.getStartAngle()-360);
		    			}
		    			
//		    			if (cr.l.getStartX()!=cr.l.getEndX()) {
//		    				cr.l.setStartX(cr.l.getEndX());
//		    				cr.l.setStartY(cr.l.getStartY()+15);
//		    				help_rotate = 0;
//		    			}
//		    			else {
//		    				cr.l.setStartX(300);
//							cr.l.setStartY(cr.l.getStartY()-15);
//							help_rotate = 1;
//		    			}
//
//		    			if (cr.l2.getStartY()!=cr.l2.getEndY()) {
//							cr.l2.setEndY(cr.l2.getStartY());
//							cr.l2.setEndX(cr.l2.getEndX()+15);
//							help_rotate = 0;
//						}
//						else {
//							cr.l2.setEndY(cr.l2.getEndY()-50);
//							cr.l2.setEndX(cr.l2.getEndX()-15);
//							help_rotate = 1;
//						}
//
//						if (cr.l3.getStartX()!=cr.l3.getEndX()) {
//							cr.l3.setEndX(cr.l3.getStartX());
//							cr.l3.setEndY(cr.l3.getEndY()-15);
//							help_rotate = 0;
//						}
//						else {
//							cr.l3.setEndX(200);
//							cr.l3.setEndY(cr.l3.getEndY()+15);
//							help_rotate = 1;
//						}
//						if (cr.l4.getStartY()!=cr.l4.getEndY()) {
//							cr.l4.setStartY(cr.l4.getEndY());
//							cr.l4.setStartX(cr.l4.getStartX()-15);
//							help_rotate = 0;
//						}
//						else {
//							cr.l4.setStartY(cr.l4.getStartY() + 50);
//							cr.l4.setStartX(cr.l4.getStartX()+15);
//							help_rotate = 1;
//						}
//
//						if(help_rotate == 1){
//							Paint temp1 = cr.l.getStroke();
//							Paint temp2 = cr.l2.getStroke();
//							Paint temp3 = cr.l3.getStroke();
//							Paint temp4 = cr.l4.getStroke();
//							cr.l.setStroke(temp2);
//							cr.l2.setStroke(temp3);
//							cr.l3.setStroke(temp4);
//							cr.l4.setStroke(temp1);
//						}


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
		    		Color temp1 = (Color)sq.rectangle.getFill();
					sq.rectangle.setFill(sq.rectangle2.getFill());
					sq.rectangle2.setFill(sq.rectangle3.getFill());
					sq.rectangle3.setFill(sq.rectangle4.getFill());
					sq.rectangle4.setFill(temp1);
//					Color temp1 = (Color)sq.square1().getFill();
//					Color temp2 = (Color)sq.square2().getFill();
//					Color temp3 = (Color)sq.square3().getFill();
//					Color temp4 = (Color)sq.square4().getFill();
//
//					sq.square1().setFill(temp2);
//					sq.square2().setFill(temp3);
//					sq.square3().setFill(temp4);
//					sq.square4().setFill(temp1);

    		gc.setFill(Color.web("061731",1.0));
    		gc.fillRect(0, 0, width * cornersize, height * cornersize);

    		gc.setFill(Color.web("F8FDE7",1.0));
    		Font f=Font.font("Proxima Nova",FontWeight.BOLD, (double)27);
    		gc.setFont(f);
    		gc.fillText(" " + stars, 40, 30);

    		Color cc = Color.WHITE;

//COLORSWITCH
//			sq.square1().setFill(sq.square2().getFill());
//			sq.square2().setFill(sq.square3().getFill());
//			sq.square3().setFill(sq.square4().getFill());
//			sq.square4().setFill(sq.square1().getFill());
    		cs.color=rand.nextInt(3)+1;
    		if (cs.color==1) {
    			cs.cir().setFill(Color.web("61D8A2",1.0));
    		//	sq.rectangle2.setFill(Color.web("61D8A2",1.0));
    			//gc.fillOval(240, 200, 30 , 30 );
    		}
    		if (cs.color==2) {
    			cs.cir().setFill(Color.web("ED476F",1.0));
    		//	sq.rectangle2.setFill(Color.web("ED476F",1.0));
    			//gc.fillOval(240, 200, 30 , 30 );
    		}
    		if (cs.color==3) {
    			cs.cir().setFill(Color.web("FAD167",1.0));
    		//	sq.rectangle2.setFill(Color.web("FAD167",1.0));
    			//gc.fillOval(240, 200, 30 , 30 );
    		}
    		if (cs.color==4) {
    			cs.cir().setFill(Color.web("368BB2",1.0));
    		//	sq.rectangle2.setFill(Color.web("368BB2",1.0));
    			//gc.fillOval(240, 200, 30 , 30 );
    		}

    		if (ball.circle.getCenterY()>mega.get(0).get(0).getY()-30 && ball.circle.getCenterY()<mega.get(0).get(0).getY()+30) {
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
                		for (int i=0;i<5;i++) {
                			ImageView iv=starlist.get(i);
                		iv.setY(iv.getY()+2);}
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
            
//switching

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
    		for (int i=0;i<5;i++) {
    			ImageView iv=starlist.get(i);
        		if (iv.getY()-ball.circle.getCenterY()<30 && iv.getY()-ball.circle.getCenterY()>0 ) {
        			stars++;
        		}
    			
    		}

    		
    		int rotatecircle=(int)(q.arc1.getRadiusX()+q.arc1.getCenterY());
    		if (ball.circle.getCenterY()<rotatecircle+10 && ball.circle.getCenterY()<rotatecircle+10) {
    			//ball.circle.setFill(Color.AQUA);
    			if (q.arc1.getStartAngle()>180 && q.arc1.getStartAngle()<360) {
    				//ball.circle.setFill(q.arc1.getStroke());
    				//System.out.println("q1 "+q.arc1.getStartAngle());
    				//System.out.println(ball.circle.getFill());
    				//System.out.println(q.arc1.getStroke());
    				String s1=ball.circle.getFill().toString();
    				String s2=q.arc1.getStroke().toString();
    				if (!s1.equals(s2)) {

    					
    					gameOver=true;
    				}
    			}
    			else if (q.arc2.getStartAngle()>180 && q.arc2.getStartAngle()<360) {
    			//	ball.circle.setFill(q.arc2.getStroke());
    				//System.out.println("q2 "+q.arc2.getStartAngle());
    				//System.out.println(ball.circle.getFill());
    				//System.out.println(q.arc2.getStroke());
    				String s1=ball.circle.getFill().toString();
    				String s2=q.arc2.getStroke().toString();
    				if (!s1.equals(s2)) {

    					gameOver=true;
    				}
    			}
    			else if (q.arc3.getStartAngle()>180 && q.arc3.getStartAngle()<360) {
    				//ball.circle.setFill(q.arc3.getStroke());
    				//System.out.println("q3 "+q.arc3.getStartAngle());
    				//System.out.println(ball.circle.getFill());
    				//System.out.println(q.arc3.getStroke());
    				String s1=ball.circle.getFill().toString();
    				String s2=q.arc3.getStroke().toString();
    				if (!s1.equals(s2)) {

    					gameOver=true;
    				}
    			}
    			else if (q.arc4.getStartAngle()>180 && q.arc4.getStartAngle()<360) {
    			//	ball.circle.setFill(q.arc4.getStroke());
    				//System.out.println(ball.circle.getFill());
    				//System.out.println("q4 "+q.arc4.getStartAngle());
    			//	System.out.println(q.arc4.getStroke());
    				String s1=ball.circle.getFill().toString();
    				String s2=q.arc4.getStroke().toString();
    				if (!s1.equals(s2)) {

    					gameOver=true;
    				}
    			}
    			
    			
    		}
    		//ball.circle.getCenterY()
//    		if (d.l2.getStartY()>0 && d.l2.getStartY()<100) 
    		if(mega.get(0).get(0).getY()>580 ){
    			//ball.circle.setFill(Color.AQUA);
    			//primaryStage.setScene(scene2);
        		for (int i = obstacle.size() - 1; i >= 0; i--) {

        			mega.get(0).get(i).setY(d.l2.getStartY()-150);
        			mega.get(1).get(i).setY(d.l2.getStartY()-150);
        		}}
    		
    		for (int i=0;i<5;i++) {
    			ImageView iv=starlist.get(i);
        		if(iv.getY()>ball.circle.getCenterY() && mega.get(0).get(0).getY()<0){
        			//ball.circle.setFill(Color.AQUA);
        			//primaryStage.setScene(scene2);
        			iv.setY(mega.get(0).get(0).getY()-150);
     }
    			
    		}

//    		
    		if(cs.cir().getCenterY()>580){
    			//ball.circle.setFill(Color.AQUA);
    			//primaryStage.setScene(scene2);
    			cs.cir().setCenterY(starlist.get(0).getY()-100);
}
    		if(q.arc1.getCenterY()>580 && q.arc2.getCenterY()>580 && q.arc3.getCenterY()>580 && q.arc4.getCenterY()>580){
    			//ball.circle.setFill(Color.AQUA);
    			//primaryStage.setScene(scene2);
    			q.arc1.setCenterY(cs.cir().getCenterY()-200);
    			q.arc2.setCenterY(cs.cir().getCenterY()-200);
    			q.arc3.setCenterY(cs.cir().getCenterY()-200);
    			q.arc4.setCenterY(cs.cir().getCenterY()-200);
 }
//    		
    		if(d.l4.getStartY()>580 && d.l.getStartY()>580 && d.l2.getStartY()>580 && d.l3.getStartY()>580){
    			//ball.circle.setFill(Color.AQUA);
    			speed=speed-(float)speed/5;
    			//primaryStage.setScene(scene2);
    			d.l.setStartY(sq.rectangle3.getY()-150);
    			d.l.setEndY(sq.rectangle3.getY()-200);
    			d.l2.setStartY(sq.rectangle3.getY()-200);
    			d.l2.setEndY(sq.rectangle3.getY()-200);
    			
    			d.l3.setStartY(sq.rectangle3.getY()-150);
    			d.l3.setEndY(sq.rectangle3.getY()-200);
    			d.l4.setStartY(sq.rectangle3.getY()-150);
    			d.l4.setEndY(sq.rectangle3.getY()-150);
 }
    		if(sq.rectangle3.getY()>580 && sq.rectangle.getY()>580 && sq.rectangle2.getY()>580 && sq.rectangle4.getY()>580){
    			//ball.circle.setFill(Color.AQUA);
    			//primaryStage.setScene(scene2);
    			sq.rectangle4.setY(q.arc1.getCenterY()-200);
    			sq.rectangle.setY(q.arc1.getCenterY()-300);
    			sq.rectangle2.setY(q.arc1.getCenterY()-300);
    			sq.rectangle3.setY(q.arc1.getCenterY()-300);
//    			d.l.setEndY(-450);
//    			d.l2.setStartY(-450);
//    			d.l2.setEndY(-450);
//    			
//    			d.l3.setStartY(-400);
//    			d.l3.setEndY(-450);
//    			d.l4.setStartY(-400);
//    			d.l4.setEndY(-400);
//    			q.arc2.setCenterY(-400);
//    			q.arc3.setCenterY(-400);
//    			q.arc4.setCenterY(-400);
    		}
        		

        		
    			
    		
    		

//    		if (gameOver) {
//
//    			boolean b=false;
//    			gc.setFill(Color.web("e63946",1.0));
//    			gc.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 50));
//    			gc.fillText("GAME OVER", 110, 75);
//
//    			b=true;
//    			int i=0;
//    			while (i!=100000) {
//    			ball.circle.setCenterY(ball.circle.getCenterY()-10);
//    			i++;
//				}
//    			return;
//    		}
    		int help=0;
    		help=1;




    	}}

    }

	public static List<Rectangle> generate() {
		 List<Rectangle> Linear = new ArrayList<>();
		 final int inipos=400;
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
			
			
	    	Space sm=new Space();
	        Button Start = new Button("START GAME");
	        //Start.setOnAction(event ->  primaryStage.setScene(scene2));
	        Start.setOnAction(new EventHandler() {
	
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					
					try {
						ball b=new ball();
						if (mode==1) {
				            FileInputStream fileOut = new FileInputStream(filepath);
				            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
				            ArrayList<Integer> balls= (ArrayList<Integer>)objectOut.readObject();
				            
				            
				            objectOut.close();
				            System.out.println(balls.get(0));
				            fileOut.close();
				            objectOut.close();
							
							b.circle.setCenterY(balls.get(0));
						}

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
					      
					     ArrayList<ImageView> starlist=new ArrayList<>();
					     for (int i=0;i<5;i++) {
					    	 ImageView p=s.star();
					    	 starlist.add(p);
					     }
						
						Square sq=new Square();
						Quad q=new Quad();
						Diamond d=new Diamond();
						Cross cr=new Cross();
						var root = new Pane();
						Canvas c = new Canvas(width * cornersize, height * cornersize);

						GraphicsContext gc = c.getGraphicsContext2D();
						//ball b=new ball(width/3,height/3);
//						for (int i=0;i<components.size();i++) {
//							root.getChildren().add(components.get(i));
//						}
						
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
						
						//b.circle.setCenterY(pr1);
						root.getChildren().add(b.circle);
						
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
						List<Rectangle> obstacle = generate();
						List<Rectangle> obstacle2 = generate();
						for (int i=0;i<20;i++) {
							root.getChildren().add(obstacle.get(i));
						}
						for (int i=0;i<20;i++) {
							root.getChildren().add(obstacle2.get(i));
						}
//						ArrayList<Rectangle> obs1=(ArrayList<Rectangle>)components.get(1);
//						for (int i=0;i<20;i++) {
//							root.getChildren().add(obs1.get(i));
//							
//						}
//						
//						ArrayList<Rectangle> obs2=(ArrayList<Rectangle>)components.get(2);
//						for (int i=0;i<20;i++) {
//							root.getChildren().add(obs2.get(i));
//							
//						}

						mega.add(obstacle);
						mega.add(obstacle2);
						ImageView s1= starlist.get(1);
						ImageView s2= starlist.get(2);
						ImageView s3= starlist.get(3);
						s1.setY(q.arc1.getCenterY()-20);
						s2.setY(sq.rectangle4.getY()-67);
						s3.setY(cr.l2.getEndY()-50);
						for (int i=0;i<5;i++) {
							ImageView p=starlist.get(i);
						root.getChildren().add(p);
						}
						Scene scene2 = new Scene(root, 500, 600);
				        
						
						new AnimationTimer() {
							long lastTick = 0;

							public void handle(long now) {
								if (lastTick == 0) {
									lastTick = now;
									try {
										sp.tick(gc,obstacle,b,q,Start,primaryStage,starlist,cs,sq,cr,d,scene2,components);
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									return;
								}

								if (now - lastTick > 100000000*(speed-1)) {
									lastTick = now;
									try {
										sp.tick(gc,obstacle,b,q,Start,primaryStage,starlist,cs,sq,cr,d,scene2,components);
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
								}
							}

						}.start();


						

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

						primaryStage.setScene(scene2);
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}});
	        Start.setId("shiny-orange");
	        Start.setMaxWidth(150);

	        StackPane rt = new StackPane();
	        Game g=new Game();
	      // g.SetUp(rt,scene2,primaryStage);      
	        Button Exit = new Button("EXIT GAME");

	        Exit.setOnAction(event -> Platform.exit());
	        
	        Exit.setId("shiny-orange");
	        Exit.setMaxWidth(150);

	        Button Load = new Button("LOAD GAME");
	     //   Load.setOnAction(event ->  primaryStage.setScene(scene2));
	        Load.setOnAction(new EventHandler() {
	
				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					
					try {
						
						var root = new Pane();
							ball b=new ball();
							
					            FileInputStream fileOut = new FileInputStream(filepath);
					            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
					            ArrayList<Integer> balls= (ArrayList<Integer>)objectOut.readObject();
					            
					            
					            objectOut.close();
					            System.out.println(balls.get(0));
					            fileOut.close();
					            objectOut.close();
								
								//b.circle.setCenterY(balls.get(0));
							//	root.getChildren().add(b.circle);

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
						      
						     ArrayList<ImageView> starlist=new ArrayList<>();
						     for (int i=0;i<5;i++) {
						    	 ImageView p=s.star();
						    	 starlist.add(p);
						     }
							
							Square sq=new Square();
							Quad q=new Quad();
							Diamond d=new Diamond();
							Cross cr=new Cross();
							
							Canvas c = new Canvas(width * cornersize, height * cornersize);

							GraphicsContext gc = c.getGraphicsContext2D();

							
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
							
							//b.circle.setCenterY(pr1);
							b.circle.setCenterY(balls.get(0));
						root.getChildren().add(b.circle);
							
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
							List<Rectangle> obstacle = generate();
							List<Rectangle> obstacle2 = generate();
							for (int i=0;i<20;i++) {
								root.getChildren().add(obstacle.get(i));
							}
							for (int i=0;i<20;i++) {
								root.getChildren().add(obstacle2.get(i));
							}
//							ArrayList<Rectangle> obs1=(ArrayList<Rectangle>)components.get(1);
//							for (int i=0;i<20;i++) {
//								root.getChildren().add(obs1.get(i));
//								
//							}
//							
//							ArrayList<Rectangle> obs2=(ArrayList<Rectangle>)components.get(2);
//							for (int i=0;i<20;i++) {
//								root.getChildren().add(obs2.get(i));
//								
//							}

							mega.add(obstacle);
							mega.add(obstacle2);
							ImageView s1= starlist.get(1);
							ImageView s2= starlist.get(2);
							ImageView s3= starlist.get(3);
							s1.setY(q.arc1.getCenterY()-20);
							s2.setY(sq.rectangle4.getY()-67);
							s3.setY(cr.l2.getEndY()-50);
							for (int i=0;i<5;i++) {
								ImageView p=starlist.get(i);
							root.getChildren().add(p);
							}
							Scene scene2 = new Scene(root, 500, 600);
					        
							
							new AnimationTimer() {
								long lastTick = 0;

								public void handle(long now) {
									if (lastTick == 0) {
										lastTick = now;
										try {
											sp.tick(gc,obstacle,b,q,Start,primaryStage,starlist,cs,sq,cr,d,scene2,components);
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										}
										return;
									}

									if (now - lastTick > 100000000*(speed-1)) {
										lastTick = now;
										try {
											sp.tick(gc,obstacle,b,q,Start,primaryStage,starlist,cs,sq,cr,d,scene2,components);
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										}
									}
								}

							}.start();


							

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

							primaryStage.setScene(scene2);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}});

	        Load.setId("shiny-orange");
	        Load.setMaxWidth(150);


	        FileInputStream input = new FileInputStream(ISHI_STAR);
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

	        rt.getChildren().addAll(vbox,imageView,t,t2);
	        
	        
	        BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream(ISHI_SCREEN),500,750,false,true),
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
