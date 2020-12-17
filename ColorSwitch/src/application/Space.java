package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import application.Main.Dir;
import application.Main.space;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Space {
	final String ISHI_SCREEN = "C:\\Users\\ishik\\Downloads\\color_screen.png";
	final String SACH_SCREEN = "/Users/sachleenkaur/Downloads/ASSETS/color_screen.png";
	final String ISHI_STAR = "C:\\Users\\ishik\\Downloads\\starf.png";
	final String SACH_STAR = "/Users/sachleenkaur/Downloads/ASSETS/starf.png";
	private static final String ISHI_filepath="C:\\Users\\ishik\\OneDrive\\Desktop\\obj.txt";
	private static final String SACH_filepath = "/Users/sachleenkaur/Downloads/ASSETS/obj.txt";
	private static final String ISHI_quads_filepath="C:\\Users\\ishik\\OneDrive\\Desktop\\quads.txt";
	private static final String SACH_quads_filepath="/Users/sachleenkaur/Downloads/ASSETS/quads.txt";
	private static final String ISHI_sessionpoints_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\sessionpoints.txt";
	private static final String SACH_sessionpoints_filepath = "/Users/sachleenkaur/Downloads/ASSETS/sessionpoints.txt";
	private static final String ISHI_stars_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\stars.txt";
	private static final String SACH_stars_filepath = "/Users/sachleenkaur/Downloads/ASSETS/stars.txt";
	private static final String ISHI_crosses_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\crosses.txt";
	private static final String SACH_crosses_filepath = "/Users/sachleenkaur/Downloads/ASSETS/crosses.txt";
	private static final String ISHI_diamonds_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\diamonds.txt";
	private static final String SACH_diamonds_filepath = "/Users/sachleenkaur/Downloads/ASSETS/diamonds.txt";
	private static final String ISHI_squares_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\squares.txt";
	private static final String SACH_squares_filepath = "/Users/sachleenkaur/Downloads/ASSETS/squares.txt";
	private static final String ISHI_lines_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\lines.txt";
	private static final String SACH_lines_filepath = "/Users/sachleenkaur/Downloads/ASSETS/lines.txt";
	private static final String ISHI_colorswitches_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\colorswitches.txt";
	private static final String SACH_colorswitches_filepath = "/Users/sachleenkaur/Downloads/ASSETS/colorswitches.txt";
	private static final String ISHI_totalpoints_filepath = "C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt";
	private static final String SACH_totalpoints_filepath = "/Users/sachleenkaur/Downloads/ASSETS/totalpoints.txt";

	static Popup pp=new Popup();
	ArrayList<Object> components=new ArrayList<>();
	//static int mode=0;
	static float speed = 5;
	static int width = 20;
	static int height = 35;
	static boolean revive=false;
	static int stars=0;
	static int x=0;
	static int y=0;
	static int cornersize = 25;
	static ColorSwitch colorSwitch = new ColorSwitch(10,20);
	//static List<List<Rectangle>> mega=new ArrayList<>();
	static Dir direction = Dir.left;
	static boolean gameOver = false;
	static ArcTo arcTo;
	static int help_rotate=0;
	static Random rand = new Random();
	static int session=0;
	static int so=0;
	static int s2=0;
	static int s3=0;
	static int s4=0;
	static int s5=0;
	
	List<Integer> colorsw = Arrays.asList(0,0,0,0,0);

	static int loop=0;
	//static int univstar=0;
	static int reset=0;
	
	
	public void restart(List<List<Rectangle>> mega,GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q,Button Start,Stage primaryStage, ArrayList<ImageView> starlist,ColorSwitch cs,Square sq,Cross cr,Diamond d,Scene scene2,ArrayList<Object> comp){
		for (int i = obstacle.size()-1 ; i >= 0; i--) {

			mega.get(0).get(i).setY(400);
			mega.get(1).get(i).setY(400);
		}
		
		ball=new ball();
		q=new Quad();
		sq=new Square();
		cs=new ColorSwitch(0,0);
		d=new Diamond();
		cr=new Cross();
		ImageView s1= starlist.get(1);
		ImageView s2= starlist.get(2);
		ImageView s3= starlist.get(3);
		s1.setY(q.arc1.getCenterY()-20);
		s2.setY(sq.rectangle4.getY()-67);
		s3.setY(cr.l2.getEndY()-50);
		
		
	}
	
	
	public void tick(List<List<Rectangle>> mega,GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q,Button Start,Stage primaryStage, ArrayList<ImageView> starlist,ArrayList<ColorSwitch> cslist,Square sq,Cross cr,Diamond d,Scene scene2,ArrayList<Object> comp, int univstar, Scene scene) throws FileNotFoundException {
		//speed++;
		//gameOver=true;
		loop++;
   		Pane rt = new Pane();
   		//System.out.println(gameOver);
   		
        Button Exit = new Button("EXIT GAME");
        Exit.setMaxWidth(200);
        Exit.setLayoutX(290);
        Exit.setLayoutY(600);
        Exit.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");
        Exit.setOnAction(event -> primaryStage.setScene(scene));
        Exit.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				int TOTALPOINTS=stars;
				ArrayList<Integer> SESHPOINTS=new ArrayList<>();
				int prev=0;
	            FileOutputStream fiTP;
				try {
					
					
		            FileInputStream fSP = new FileInputStream(ISHI_totalpoints_filepath);
		            ObjectInputStream oSP = new ObjectInputStream(fSP);
		            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
		            if (SESHPOINTS.size()!=0) {
		            prev=SESHPOINTS.get(0);}
		            else if(SESHPOINTS.size()==0) {
		            	SESHPOINTS.add(0);
		            }
		            
		            SESHPOINTS.set(0, prev+stars);
		            
		            oSP.close();
		            System.out.println("The STARS  was succesfully read to a file");
		            fSP.close();
		            
		            
					fiTP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt"));
		            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
		            
		            oiTP.writeObject(SESHPOINTS);
		            oiTP.close();
		            System.out.println("done");
		            fiTP.close();
				
				
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reset=1;
				primaryStage.setScene(scene);

				
			}});
        rt.getChildren().add(Exit);
        
        
        Button Restart = new Button("RESTART");
        Restart.setMaxWidth(200);
        Restart.setLayoutX(110);
        Restart.setLayoutY(600);
        Restart.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");
        Restart.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				
        		int TOTALPOINTS=stars;
				ArrayList<Integer> SESHPOINTS=new ArrayList<>();
				int prev=0;
	            FileOutputStream fiTP;
				try {
					
					
		            FileInputStream fSP = new FileInputStream(ISHI_totalpoints_filepath);
		            ObjectInputStream oSP = new ObjectInputStream(fSP);
		            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
		            if (SESHPOINTS.size()!=0) {
		            prev=SESHPOINTS.get(0);}
		            else if(SESHPOINTS.size()==0) {
		            	SESHPOINTS.add(0);
		            }
		            
		            SESHPOINTS.set(0, prev+stars);
		            
		            oSP.close();
		            System.out.println("The STARS  was succesfully read to a file");
		            fSP.close();
		            
		            
					fiTP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt"));
		            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
		            
		            oiTP.writeObject(SESHPOINTS);
		            oiTP.close();
		            System.out.println("done");
		            fiTP.close();
				
				
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				reset=1;
				primaryStage.setScene(scene2);
				
			}});
        rt.getChildren().add(Restart);
        
        

        Button E = new Button("SAVE & EXIT GAME");
        E.setMaxWidth(200);
        E.setLayoutX(70);
        E.setLayoutY(500);
        //E.setOnAction(event -> Platform.exit());
       E.setOnAction(new EventHandler() {


			@Override
			public void handle(Event arg0) {
				Game g=new Game();
				g.save(mega,gc,obstacle,ball,q,Start,primaryStage,starlist,cslist,sq,cr,d,scene2,components,scene,stars);

				primaryStage.setScene(scene);
				//Platform.exit();
				
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
		   
		   if (reset==1) {
				for (int i = obstacle.size()-1 ; i >= 0; i--) {

					mega.get(0).get(i).setY(400);
					mega.get(1).get(i).setY(400);
				}
				
				ball.circle.setCenterY(580);
				q.arc1.setCenterX(250.0f);
				q.arc1.setCenterY(-5);		
				q.arc2.setCenterX(250.0f);
				q.arc2.setCenterY(-5);		
				q.arc3.setCenterX(250.0f);
				q.arc3.setCenterY(-5);		
				q.arc4.setCenterX(250.0f);
				q.arc4.setCenterY(-5);
			    sq.rectangle.setX(325);
			    sq.rectangle.setY(-400);
				sq.rectangle2.setX(175);
				sq.rectangle2.setY(-400);
				sq.rectangle3.setX(175);
				sq.rectangle3.setY(-400);	
				sq.rectangle4.setX(175);
				sq.rectangle4.setY(-250);
				cslist.get(0).c.setCenterX(250);
				cslist.get(0).c.setCenterY(200);
				d.l.setStartX(345);
				d.l.setStartY(-950);
				d.l.setEndX(320);
				d.l.setEndY(-1052);
				d.l2.setStartX(320);
				d.l2.setStartY(-952);
				d.l2.setEndX(150);
				d.l2.setEndY(-952);
				d.l3.setStartX(180);
				d.l3.setStartY(-950);
				d.l3.setEndX(150);
				d.l3.setEndY(-1050);
				d.l4.setStartX(180);
				d.l4.setStartY(-950);
				d.l4.setEndX(350);
				d.l4.setEndY(-950);
				cr.l.setStartX(350);
				cr.l.setStartY(-620);
				//l.setEndX(250);
					cr.l.setEndX(300);
				cr.l.setEndY(-670);
				
				cr.l2.setStartX(300);
				cr.l2.setStartY(-670);
				//l2.setEndX(300);
				cr.l2.setEndX(350);
				cr.l2.setEndY(-720);
				
				cr.l3.setStartX(300);
				cr.l3.setStartY(-670);
				//l3.setEndX(200);
				cr.l3.setEndX(250);
				cr.l3.setEndY(-710);
				
				cr.l4.setStartX(250);
				cr.l4.setStartY(-620);
				//l4.setEndX(250);
				cr.l4.setEndX(300);
				cr.l4.setEndY(-670);
				
				ImageView s1= starlist.get(1);
				ImageView s2= starlist.get(2);
				ImageView s3= starlist.get(3);
				ImageView s4= starlist.get(4);
				starlist.get(1).setY(q.arc1.getCenterY()-20);
				starlist.get(0).setY(235);
				starlist.get(2).setY(sq.rectangle4.getY()-80);
				starlist.get(3).setY(cr.l2.getEndY()-50);
				starlist.get(4).setY(d.l2.getEndY()-50);
				cslist.get(1).c.setCenterY(q.arc1.getCenterY()-130);
				cslist.get(0).c.setCenterY(200);
				cslist.get(2).c.setCenterY(sq.rectangle4.getY()-200);
				cslist.get(3).c.setCenterY(cr.l2.getEndY()-80);
				cslist.get(4).c.setCenterY(d.l2.getEndY()-80);
				stars=0;
				reset=0;
		   }
		for (int i = obstacle.size() - 1; i >= 1; i--) {

			mega.get(0).get(i).setX(mega.get(0).get(i - 1).getX());
			//mega.get(0).get(i).setY(mega.get(0).get(i - 1).getY()+1);
			//mega.get(0).get(i).setY(mega.get(0).get(i).getY()+1);
			mega.get(1).get(i).setX(mega.get(1).get(i - 1).getX());
			//mega.get(1).get(i).setY(mega.get(1).get(i).getY()+1);
		}
//		
//		for (int i=0;i<mega.get(0).size();i++) {
//			mega.get(1).get(0).setY(mega.get(1).get(0).getY()+1);
//			mega.get(0).get(0).setY(mega.get(0).get(0).getY()+1);
//		}

	    		//boolean loop=true;
	    		switch (direction) {

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
	    			
	    			if (loop%2==0) {
	    			
	    			if (cr.l.getStartX()!=cr.l.getEndX()) {
	    				cr.l.setStartX(cr.l.getEndX());
	    				cr.l.setStartY(cr.l.getStartY()+15);
	    				help_rotate = 0;
	    			}
	    			else {
	    				cr.l.setStartX(350);
						cr.l.setStartY(cr.l.getStartY()-15);
						help_rotate = 1;
	    			}

	    			if (cr.l2.getStartY()!=cr.l2.getEndY()) {
						cr.l2.setEndY(cr.l2.getStartY());
						cr.l2.setEndX(cr.l2.getEndX()+15);
						help_rotate = 0;
					}
					else {
						cr.l2.setEndY(cr.l2.getEndY()-50);
						cr.l2.setEndX(cr.l2.getEndX()-15);
						help_rotate = 1;
					}

					if (cr.l3.getStartX()!=cr.l3.getEndX()) {
						cr.l3.setEndX(cr.l3.getStartX());
						cr.l3.setEndY(cr.l3.getEndY()-15);
						help_rotate = 0;
					}
					else {
						cr.l3.setEndX(250);
						cr.l3.setEndY(cr.l3.getEndY()+15);
						help_rotate = 1;
					}
					if (cr.l4.getStartY()!=cr.l4.getEndY()) {
						cr.l4.setStartY(cr.l4.getEndY());
						cr.l4.setStartX(cr.l4.getStartX()-15);
						help_rotate = 0;
					}
					else {
						cr.l4.setStartY(cr.l4.getStartY() + 50);
						cr.l4.setStartX(cr.l4.getStartX()+15);
						help_rotate = 1;
					}

					if(help_rotate == 1){
						Paint temp1 = cr.l.getStroke();
						Paint temp2 = cr.l2.getStroke();
						Paint temp3 = cr.l3.getStroke();
						Paint temp4 = cr.l4.getStroke();
						cr.l4.setStroke(temp1);
						cr.l3.setStroke(temp4);
						cr.l2.setStroke(temp3);
						cr.l.setStroke(temp2);
					}
					
					if(d.l.getStartX()!= d.l.getEndX()){
						d.l.setStartX(d.l.getEndX());
						d.l.setEndY(d.l.getEndY()-20);
						d.l.setStartY(d.l.getStartY()-20);
					}
					else{
						d.l.setStartX(345);
						d.l.setEndY(d.l.getEndY()+20);
						d.l.setStartY(d.l.getStartY()+20);
					}
					if(d.l2.getStartY()!=d.l2.getEndY()-20){
						d.l2.setStartY(d.l2.getEndY()-20);
					}
					else{
						d.l2.setStartY(d.l2.getEndY());
					}
					if(d.l3.getStartX()!= d.l3.getEndX()){
						d.l3.setStartX(d.l3.getEndX());
					}
					else{
						d.l3.setStartX(180);
					}
					if(d.l4.getEndY()!=d.l4.getStartY()-20){
						d.l4.setEndY(d.l4.getStartY()-20);
						d.l4.setStartX(160);
						d.l4.setEndX(d.l4.getEndX()-30);
					}
					else{
						d.l4.setEndY(d.l4.getStartY());
						d.l4.setStartX(180);
						d.l4.setEndX(d.l4.getEndX()+30);
					}

					Paint temp1 = d.l.getStroke();
					Paint temp2 = d.l2.getStroke();
					Paint temp3 = d.l3.getStroke();
					Paint temp4 = d.l4.getStroke();
					d.l.setStroke(temp2);
					d.l2.setStroke(temp3);
					d.l3.setStroke(temp4);
					d.l4.setStroke(temp1);
					
		    		Color tempo = (Color)sq.rectangle.getFill();
					sq.rectangle.setFill(sq.rectangle2.getFill());
					sq.rectangle2.setFill(sq.rectangle3.getFill());
					sq.rectangle3.setFill(sq.rectangle4.getFill());
					sq.rectangle4.setFill(tempo);
	    			
	    			
	    			
	    			}


//		      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
//		          @Override
//		          public void handle(MouseEvent e) {
//		  			int i=(int)ball.circle.getCenterY();
//					i=i-30;
//					ball.circle.setCenterY(i);
//		          }
//		       };

			break;


		}


		gc.setFill(Color.web("061731",1.0));
		gc.fillRect(0, 0, width * cornersize, height * cornersize);

		gc.setFill(Color.web("F8FDE7",1.0));
		Font f=Font.font("Proxima Nova",FontWeight.BOLD, (double)27);
		gc.setFont(f);
		gc.fillText(" " + stars, 40, 30);

		Color cc = Color.WHITE;

//COLORSWITCH
		for (int i=0;i<5;i++) {
			ColorSwitch cs=cslist.get(i);
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
		}

		if (ball.getPosition(ball.circle)>mega.get(0).get(0).getY()-30 && ball.getPosition(ball.circle)<mega.get(0).get(0).getY()+30) {
		for (int i=0;i<mega.get(0).size();i++) {
			//session++;
			if (mega.get(0).get(i).getX()==240) {
				String s1=ball.circle.getFill().toString();
				String s2=mega.get(0).get(i).getFill().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}
			}
		}}

		   if(ball.getPosition(ball.circle)>= d.l2.getEndY()-10 && ball.getPosition(ball.circle)<= d.l2.getEndY()+10){
				String s1=ball.circle.getFill().toString();
				String s2=d.l2.getStroke().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}

		   }

		   if(ball.getPosition(ball.circle)>= d.l4.getEndY()-10 && ball.getPosition(ball.circle)<= d.l4.getEndY()+10){
				String s1=ball.circle.getFill().toString();
				String s2=d.l4.getStroke().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}

		   }

		   if(ball.getPosition(ball.circle)>= sq.rectangle4.getY()-15 && ball.getPosition(ball.circle)<= sq.rectangle4.getY()+15){
				String s1=ball.circle.getFill().toString();
				String s2=sq.rectangle4.getFill().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}

		   }
		   if(ball.getPosition(ball.circle)>= sq.rectangle3.getY()-15 && ball.getPosition(ball.circle)<= sq.rectangle3.getY()+15){
				String s1=ball.circle.getFill().toString();
				String s2=sq.rectangle3.getFill().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}
		   }


		   if(help_rotate == 0){	//when its a cross
			   if(ball.getPosition(ball.circle)>= cr.l2.getEndY() && ball.getPosition(ball.circle)<= cr.l2.getStartY())
			   { 				String s1=ball.circle.getFill().toString();
				String s2=cr.l2.getStroke().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}
	}
			   if(ball.getPosition(ball.circle)>= cr.l.getEndY() && ball.getPosition(ball.circle)<= cr.l.getStartY())
			   { 				String s1=ball.circle.getFill().toString();
				String s2=cr.l.getStroke().toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}
	}
		   }
		   else{				//when its a plus
			   if(ball.circle.getCenterY() == cr.l2.getStartY()){
				   { 				String s1=ball.circle.getFill().toString();
					String s2=cr.l2.getStroke().toString();
					if (!s1.equals(s2)) {

						gameOver=true;
					}
		}
			   }
		   }

		   
		   //line infinity
		if (mega.get(0).get(19).getX()==480) {
			mega.get(1).get(0).setX(510);
		}
		if (mega.get(1).get(19).getX()==480) {
			mega.get(0).get(0).setX(510);
		}


        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
        {//fctor:13
            public void handle(MouseEvent event) 
            {	//System.out.println(ball.cir().getCenterY());
            	//System.out.println(ball.cir().getCenterY());
            	//position-=5;
            	//int pos=(int)ball.cir().getCenterY();
            	if (ball.cir().getCenterY()>410) {
                ball.cir().setCenterY(ball.cir().getCenterY()-2.3);}
               // int pos2=(int)ball.cir().getCenterY();
                
            	else if (ball.cir().getCenterY()<410) {
                	System.out.println("ji");
                	System.out.println(ball.cir().getCenterY());
            		 //ball.circle.setCenterY(ball.cir().getCenterY()-3);
            		for (int i = obstacle.size() - 1; i >= 0; i--) {

            			mega.get(0).get(i).setY(mega.get(0).get(i).getY()+2);
            			mega.get(1).get(i).setY(mega.get(1).get(i).getY()+2);
            		}
            		for (int i=0;i<5;i++) {
            			ImageView iv=starlist.get(i);
            		iv.setY(iv.getY()+2);}
            		
            		for (int i=0;i<5;i++) {
            			
            		cslist.get(i).c.setCenterY(cslist.get(i).c.getCenterY()+2);
            		}
            		
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
//	    			sq.rectangle2.setY(sq.rectangle2.getY()+2);
//	    			sq.rectangle3.setY(sq.rectangle3.getY()+2);
//	    			sq.rectangle4.setY(sq.rectangle4.getY()+2);


	    			
                }

            }
        });
        
       // ball.circle.setCenterY(position);
        //mega.get(0).get(1).getY()>400
        if (ball.circle.getCenterY()<550) {

           	ball.circle.setCenterY(ball.cir().getCenterY()+3);

        }
        
//switching
        
        for (int i=0;i<5;i++) {
        
		if (ball.circle.getCenterY()<cslist.get(i).c.getCenterY()+30 && ball.circle.getCenterY()>cslist.get(i).c.getCenterY()-30
				) {
			ColorSwitch cs=cslist.get(i);
			//System.out.println(colorsw.get(i));
			//System.out.println(session);
			if (colorsw.get(i)<session) {
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
			colorsw.set(i,colorsw.get(i)+1);
			}
		}
		
        }
//		for (int i=0;i<5;i++) {
//			ImageView iv=starlist.get(i);
//    		if (iv.getY()-ball.circle.getCenterY()<30 && iv.getY()-ball.circle.getCenterY()>0 ) {
//    			
//    			stars++;
//    		}
//			
//		}
		
		ImageView v=starlist.get(0);
		//System.out.println(v.getY());
		//System.out.println(so);
		//System.out.println(session);
		if (v.getY()-ball.circle.getCenterY()>-30 && so<session) {
			//System.out.println("crossed");
			
			so++;
			stars++;
			v.setY(mega.get(0).get(0).getY()-150);
			univstar++;
		}
		ImageView v2=starlist.get(1);
		if (v2.getY()-ball.circle.getCenterY()>0 && s2<session) {
			s2++;
			stars++;
			univstar++;
		}
		ImageView v3=starlist.get(2);
		if (v3.getY()-ball.circle.getCenterY()>0 && s3<session) {
			s3++;
			stars++;
			univstar++;
		}
		ImageView v4=starlist.get(3);
		if (v4.getY()-ball.circle.getCenterY()>0 && s4<session) {
			s4++;
			stars++;
		}
		ImageView v5=starlist.get(4);
		if (v5.getY()-ball.circle.getCenterY()>0 && s5<session) {
			s5++;
			stars++;
			univstar++;
		}

		
		int rotatecircle=(int)(q.arc1.getRadiusX()+q.getPosition(q.arc1));
		if (ball.circle.getCenterY()<rotatecircle+10 && ball.circle.getCenterY()<rotatecircle+10) {
			//ball.circle.setFill(Color.AQUA);
			if ((q.arc1.getStartAngle()>180 && q.arc1.getStartAngle()<360) ) {
				//ball.circle.setFill(q.arc1.getStroke());
				//System.out.println("q1 "+q.arc1.getStartAngle());
				//System.out.println(ball.circle.getFill());
				//System.out.println(q.arc1.getStroke());
				String s1=ball.circle.getFill().toString();
				String s2=q.getcolor(q.arc1).toString();
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
				String s2=q.getcolor(q.arc2).toString();
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
				String s2=q.getcolor(q.arc3).toString();
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
				String s2=q.getcolor(q.arc4).toString();
				if (!s1.equals(s2)) {

					gameOver=true;
				}
			}
			
			
		}
		
		
		
		
		int rotatecircle2=(int)(-q.arc1.getRadiusX()+q.getPosition(q.arc1));
		if (ball.circle.getCenterY()<rotatecircle2+10 && ball.circle.getCenterY()<rotatecircle2+10) {
			//ball.circle.setFill(Color.AQUA);
			if ((q.arc1.getStartAngle()>0 && q.arc1.getStartAngle()<0) ) {
				//ball.circle.setFill(q.arc1.getStroke());
				//System.out.println("q1 "+q.arc1.getStartAngle());
				//System.out.println(ball.circle.getFill());
				//System.out.println(q.arc1.getStroke());
				String s1=ball.circle.getFill().toString();
				String s2=q.arc1.getStroke().toString();
				if (!s1.equals(s2)) {

					
					//gameOver=true;
				}
			}
			else if (q.arc2.getStartAngle()>0 && q.arc2.getStartAngle()<180) {
			//	ball.circle.setFill(q.arc2.getStroke());
				//System.out.println("q2 "+q.arc2.getStartAngle());
				//System.out.println(ball.circle.getFill());
				//System.out.println(q.arc2.getStroke());
				String s1=ball.circle.getFill().toString();
				String s2=q.arc2.getStroke().toString();
				if (!s1.equals(s2)) {

					//gameOver=true;
				}
			}
			else if (q.arc3.getStartAngle()>0 && q.arc3.getStartAngle()<180) {
				//ball.circle.setFill(q.arc3.getStroke());
				//System.out.println("q3 "+q.arc3.getStartAngle());
				//System.out.println(ball.circle.getFill());
				//System.out.println(q.arc3.getStroke());
				String s1=ball.circle.getFill().toString();
				String s2=q.arc3.getStroke().toString();
				if (!s1.equals(s2)) {

					//gameOver=true;
				}
			}
			else if (q.arc4.getStartAngle()>0 && q.arc4.getStartAngle()<180) {
			//	ball.circle.setFill(q.arc4.getStroke());
				//System.out.println(ball.circle.getFill());
				//System.out.println("q4 "+q.arc4.getStartAngle());
			//	System.out.println(q.arc4.getStroke());
				String s1=ball.circle.getFill().toString();
				String s2=q.arc4.getStroke().toString();
				if (!s1.equals(s2)) {

					//gameOver=true;
				}
			}
			
			
		}
		
		
		
		
		
		
		
		
		//ball.circle.getCenterY()
//		if (d.l2.getStartY()>0 && d.l2.getStartY()<100) 
		if(mega.get(0).get(0).getY()>580 ){
			speed=speed-speed/2;
			session++;
			//System.out.println(session);
			//ball.circle.setFill(Color.AQUA);
			//primaryStage.setScene(scene2);
    		for (int i = obstacle.size() - 1; i >= 0; i--) {

    			mega.get(0).get(i).setY(d.l2.getStartY()-250);
    			mega.get(1).get(i).setY(d.l2.getStartY()-250);
    		}}
		
		
			ImageView iv1=starlist.get(0);
    		if(iv1.getY()>ball.circle.getCenterY()+30 && mega.get(0).get(0).getY()<0){
    			//ball.circle.setFill(Color.AQUA);
    			//primaryStage.setScene(scene2);
    			//iv1.setY(mega.get(0).get(0).getY()-150);
 }
    		
			ImageView iv2=starlist.get(1);
    		if(iv2.getY()>ball.circle.getCenterY() ){

    			iv2.setY(q.arc1.getCenterY()-20);
 }
    		
			ImageView iv3=starlist.get(2);
    		if(iv3.getY()>ball.circle.getCenterY()){

    			iv3.setY(sq.rectangle4.getY()-67);
 }
    		ImageView iv4=starlist.get(3);
    		if(iv4.getY()>580){
    			
    			iv4.setY(cr.l2.getEndY()-200);
    		}
    		ImageView iv5=starlist.get(4);
    		if(iv5.getY()>580){
    			
    			iv5.setY(iv4.getY()-300);
    		}
			
		

//		
    	for (int i=0;i<5;i++) {
    		ColorSwitch cs=cslist.get(i);
		if(cs.c.getCenterY()>580){
			//ball.circle.setFill(Color.AQUA);
			//primaryStage.setScene(scene2);
			cs.c.setCenterY(starlist.get(i).getY()-100);
}}
		if(q.getPosition(q.arc1)>580 && q.getPosition(q.arc2)>580 && q.getPosition(q.arc2)>580 && q.getPosition(q.arc2)>580){
			//ball.circle.setFill(Color.AQUA);
			//primaryStage.setScene(scene2);
			q.arc1.setCenterY(cslist.get(0).c.getCenterY()-200);
			q.arc2.setCenterY(cslist.get(0).c.getCenterY()-200);
			q.arc3.setCenterY(cslist.get(0).c.getCenterY()-200);
			q.arc4.setCenterY(cslist.get(0).c.getCenterY()-200);
}
//		
		if(d.l4.getStartY()>580 && d.l.getStartY()>580 && d.l2.getStartY()>580 && d.l3.getStartY()>580 &&
				d.l4.getEndY()>580 && d.l.getEndY()>580 && d.l2.getEndY()>580 && d.l3.getEndY()>580){
			//ball.circle.setFill(Color.AQUA);
			
			
			//primaryStage.setScene(scene2);
			d.l.setStartY(starlist.get(3).getY()-150);
			d.l.setEndY(starlist.get(3).getY()-250);
			d.l.setStartX(345);
			d.l.setEndX(320);
			d.l2.setStartY(starlist.get(3).getY()-250);
			d.l2.setEndY(starlist.get(3).getY()-250);
			d.l2.setStartX(320);
			d.l2.setEndX(150);
			
			d.l3.setStartY(starlist.get(3).getY()-150);
			d.l3.setEndY(starlist.get(3).getY()-250);
			d.l3.setStartX(180);
			d.l3.setEndX(150);
			
			d.l4.setStartY(starlist.get(3).getY()-150);
			d.l4.setEndY(starlist.get(3).getY()-150);
			d.l4.setStartX(180);
			d.l4.setEndX(350);
}
		
		
		if(cr.l4.getStartY()>580 && cr.l.getStartY()>580 && cr.l2.getStartY()>580 && cr.l3.getStartY()>580 &&
				cr.l4.getEndY()>580 && cr.l.getEndY()>580 && cr.l2.getEndY()>580 && cr.l3.getEndY()>580){
			//ball.circle.setFill(Color.AQUA);
			speed=speed-(float)speed/5;
			//primaryStage.setScene(scene2);
			cr.l.setStartY(sq.rectangle3.getY()-100);
			cr.l.setEndY(sq.rectangle3.getY()-150);
			
			//cr.l.setStartX(300);
			cr.l.setStartX(350);
			//cr.l.setEndX(250);
			cr.l.setEndX(300);
			cr.l2.setStartY(sq.rectangle3.getY()-150);
			cr.l2.setEndY(sq.rectangle3.getY()-200);
			//cr.l2.setStartX(250);
			//cr.l2.setEndX(300);
			cr.l2.setStartX(300);
			cr.l2.setEndX(350);
			cr.l3.setStartY(sq.rectangle3.getY()-150);
			cr.l3.setEndY(sq.rectangle3.getY()-190);
			//cr.l3.setStartX(250);
			//cr.l3.setEndX(200);
			cr.l3.setStartX(300);
			cr.l3.setEndX(250);
			cr.l4.setStartY(sq.rectangle3.getY()-100);
			cr.l4.setEndY(sq.rectangle3.getY()-150);
			//cr.l4.setStartX(200);
			//cr.l4.setEndX(250);
			cr.l4.setStartX(250);
			cr.l4.setEndX(300);
		}
		
		
		if(sq.rectangle3.getY()>580 && sq.rectangle.getY()>580 && sq.rectangle2.getY()>580 && sq.rectangle4.getY()>580){
			//ball.circle.setFill(Color.AQUA);
			//primaryStage.setScene(scene2);
			sq.rectangle4.setY(q.arc1.getCenterY()-250);
			sq.rectangle.setY(q.arc1.getCenterY()-400);
			sq.rectangle2.setY(q.arc1.getCenterY()-400);
			sq.rectangle3.setY(q.arc1.getCenterY()-400);

		}
		
		
		
		
		if (!gameOver) {
			pp.hide();
		}
		
		
//if (gameOver) {
//	//System.out.println("in the loop");
//	int pos=(int)ball.circle.getCenterY();
//		
//			univstar=+stars;
//			Popup warning=new Popup();
//			Label l=new Label("Shoot! You dont have enough stars");
//	        l.setFont(Font.font("Proxima Nova", 15));
//	        l.setTextFill(Color.web("#ef233c"));
//
//			TilePane l2=new TilePane();
//	        l.setLayoutY(5);
//	        l.setLayoutX(45);
//	        l2.setHgap(50);
//	        l2.setStyle("-fx-background-color: #ffffff; -fx-padding: 10;-fx-border-style: solid inside;-fx-border-radius: 5;-fx-border-width: 2;-fx-border-insets: 5;-fx-border-color: #f1faee;");
//	        l2.setPrefHeight(150);
//	        l2.setPrefWidth(300);
//	        l2.setAlignment(Pos.CENTER);
//			Button w=new Button("Okay");
//			w.setStyle("-fx-background-color:#d5f2e3;-fx-font-family:'Open Sans';-fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0; -fx-text-fill: #061731; -fx-font-weight: bold;-fx-padding: 10 20 10 20;");
//			w.setOnAction(new EventHandler() {
//
//				@Override
//				public void handle(Event arg0) {
//					
//					warning.hide();
//					
//				}
//		
//			});
//			
//			
//			
//			l2.getChildren().add(w);
//			
//			
//			warning.getContent().add(l2);
//			warning.getContent().add(l);
//			warning.setY(300);
//			warning.setX(625);
//			TextField textField = new TextField ();
//			TilePane layout = new TilePane();
//
//		    layout.setStyle("-fx-background-color: #ffffff; -fx-padding: 10;-fx-border-style: solid inside;-fx-border-radius: 5;-fx-border-width: 2;-fx-border-insets: 5;-fx-border-color: #f1faee;");
//			
//			
//			Button b1=new Button("REVIVE");
//	        b1.setId("shiny-orange");
//	        b1.setStyle("-fx-background-color:#d5f2e3;-fx-font-family:'Open Sans';-fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0; -fx-text-fill: #061731; -fx-font-weight: bold;-fx-padding: 10 20 10 20;");
//	        
//	        
//	        b1.setOnAction(new EventHandler() {
//
//				@Override
//				public void handle(Event arg0) {
//					
//					if (stars>3) {
//					ball.circle.setCenterY(580);
//					gameOver=false;
//					pp.hide();}
//					else {
//						if(!warning.isShowing()) {
//						warning.show(primaryStage);}
//					}
//					
//					//System.out.println(gameOver);
//					
//				}});
//			
//			Button b2=new Button("LOSE");
//			b2.setStyle("-fx-background-color:#d3d3d3;-fx-font-family:'Open Sans';-fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0; -fx-text-fill: #061731; -fx-font-weight: bold;-fx-padding: 10 20 10 20;");
//	        b2.setId("shiny-orange");
//	        b2.setMaxWidth(150);
//	        Button b3=new Button("RESTART");
//	        b3.setStyle("-fx-background-color:#d3d3d3;-fx-font-family:'Open Sans';-fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0; -fx-text-fill: #061731; -fx-font-weight: bold;-fx-padding: 10 20 10 20;");
//	        b3.setId("shiny-orange");
//	        b3.setMaxWidth(150);
//	        b3.setOnAction(new EventHandler() {
//
//				@Override
//				public void handle(Event arg0) {
//
//					reset=1;
//					int TOTALPOINTS=stars;
//					ArrayList<Integer> SESHPOINTS=new ArrayList<>();
//					int prev=0;
//		            FileOutputStream fiTP;
//					try {
//						
//						
//			            FileInputStream fSP = new FileInputStream(ISHI_totalpoints_filepath);
//			            ObjectInputStream oSP = new ObjectInputStream(fSP);
//			            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
//			            if (SESHPOINTS.size()!=0) {
//			            prev=SESHPOINTS.get(0);}
//			            else if(SESHPOINTS.size()==0) {
//			            	SESHPOINTS.add(0);
//			            }
//			            
//			            SESHPOINTS.set(0, prev+stars);
//			            
//			            oSP.close();
//			            System.out.println("The STARS  was succesfully read to a file");
//			            fSP.close();
//			            
//			            
//						fiTP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt"));
//			            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
//			            
//			            oiTP.writeObject(SESHPOINTS);
//			            oiTP.close();
//			            System.out.println("done");
//			            fiTP.close();
//					
//					
//					
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					ball.circle.setCenterY(580);
//					gameOver=false;
//					pp.hide();
//					
//					
//				}});
//	        b2.setOnAction(new EventHandler() {
//	        	
//	        	@Override
//	        	public void handle(Event arg0) {
//	        		
//	        		int TOTALPOINTS=stars;
//					ArrayList<Integer> SESHPOINTS=new ArrayList<>();
//					int prev=0;
//		            FileOutputStream fiTP;
//					try {
//						
//						
//			            FileInputStream fSP = new FileInputStream(ISHI_totalpoints_filepath);
//			            ObjectInputStream oSP = new ObjectInputStream(fSP);
//			            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
//			            if (SESHPOINTS.size()!=0) {
//			            prev=SESHPOINTS.get(0);}
//			            else if(SESHPOINTS.size()==0) {
//			            	SESHPOINTS.add(0);
//			            }
//			            
//			            SESHPOINTS.set(0, prev+stars);
//			            
//			            oSP.close();
//			            System.out.println("The STARS  was succesfully read to a file");
//			            fSP.close();
//			            
//			            
//						fiTP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt"));
//			            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
//			            
//			            oiTP.writeObject(SESHPOINTS);
//			            oiTP.close();
//			            System.out.println("done");
//			            fiTP.close();
//					
//					
//					
//					} catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//	        		gameOver=false;
//	        		pp.hide();
//	        		primaryStage.setScene(scene);
//	        		
//	        		
//	        		//System.out.println(gameOver);
//	        		
//	        	}});
//
//			Label label1 = new Label("GAME OVER");
//	        label1.setAlignment(Pos.CENTER);
//	        label1.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 25));
//	        label1.setTextFill(Color.web("#ef233c"));
//	        layout.setAlignment(Pos.CENTER);
//	        label1.setLayoutY(5);
//	        label1.setLayoutX(82);
//	        layout.setHgap(50);
//	        layout.setPrefHeight(150);
//	        layout.setPrefWidth(300);
//	       
//	        ObservableList list = layout.getChildren();  
//	        
//	        //Adding all the nodes to the observable list (HBox) 
//	        list.addAll(b1, b2,b3); 
//
//
//	        Scene scene4=new Scene(layout,300,300);
//	        pp.getContent().add(layout);
//	        pp.getContent().add(label1);
//	        pp.setX(625);
//	        pp.setY(300);
//	       if (!pp.isShowing()) {
//	       pp.show(primaryStage);}
//	       int i=0;
//			while (i!=100000) {
//			ball.circle.setCenterY(ball.circle.getCenterY()-10);
//			i++;
//			}
//			return;
//		}

	}




	}

	

	
}