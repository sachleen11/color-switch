package application;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import java.util.Random;
import javafx.scene.media.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;
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

class gameElements{
	int position;
	int getPosition(Object o) {
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
	Paint getcolor(Object o) {
		return Color.BLACK;

	}
	void setcolor(Paint p, Object o){

	}
	int getspeed() {
		return 0;
	}
	void setspeed(double i) {

	}
	void display() {

	}

}


public class Main extends Application {

	final String ISHI_SCREEN = "C:\\Users\\ishik\\Downloads\\color_screen.png";
	final String SACH_SCREEN = "/Users/sachleenkaur/Downloads/ASSETS/color_screen.png";
	final String ISHI_STAR = "C:\\Users\\ishik\\Downloads\\starf.png";
	final String SACH_STAR = "/Users/sachleenkaur/Downloads/ASSETS/starf.png";
	private static final String filepath="C:\\Users\\ishik\\OneDrive\\Desktop\\obj.txt";
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

	
	
	
	
	ArrayList<Object> components=new ArrayList<>();
	static int mode=0;
	static float speed = 5;
	static int width = 20;
	static int height = 35;
	static int seshstar=0;
	static int x=0;
	static int y=0;
	static int cornersize = 25;
	static ColorSwitch colorSwitch = new ColorSwitch(10,20);
	static List<List<Rectangle>> mega=new ArrayList<>();
	static Dir direction = Dir.left;
	static boolean gameOver = false;
	static ArcTo arcTo;
	static int gmode=0;
	static int univstar=0;

	static Random rand = new Random();


	public enum Dir {
		left, right, up, down
	}

    public void exitGame(){

        return;
    }

    class space{
    	int position=550;
  

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
			Player pl=new Player(0);
			
			ArrayList<Integer> points=new ArrayList<>();
			
            FileInputStream fSP = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt");
            ObjectInputStream oSP = new ObjectInputStream(fSP);
            points= (ArrayList<Integer>)oSP.readObject();
            if (points.size()!=0) {
            univstar=points.get(0);}
            else if(points.size()==0) {
            	points.add(0);
            	univstar=points.get(0);
            }

            
            oSP.close();
            System.out.println("The STARS  was succesfully read to a file");
            fSP.close();
			

			
	    	Space sm=new Space();
	    	Button Run=new Button("FLY MODE");
	    	Run.setMaxWidth(150);
	    	Run.setId("shiny-orange");
	    	

	    	
	    	
	        Button Start = new Button("START GAME");
	        //Start.setOnAction(event ->  primaryStage.setScene(scene2));

	        Start.setId("shiny-orange");
	        Start.setMaxWidth(150);

	        StackPane rt = new StackPane();
	        Game g=new Game();
	      // g.SetUp(rt,scene2,primaryStage);      
	        Button Exit = new Button("EXIT GAME");

	        Exit.setOnAction(new EventHandler() {

				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					
					Game g=new Game();
					g.exit();
					
				}});
	        
	        Exit.setId("shiny-orange");
	        Exit.setMaxWidth(150);
	        Button Help = new Button("HELP");
	        
	        Help.setOnAction(new EventHandler() {

				@Override
				public void handle(Event arg0) {
					Popup p=new Popup();
					TilePane l2=new TilePane();
			        l2.setHgap(50);
			        l2.setStyle("-fx-background-color: #ffffff; -fx-padding: 10;-fx-border-style: solid inside;-fx-border-radius: 5;-fx-border-width: 2;-fx-border-insets: 5;-fx-border-color: #f1faee;");
			        l2.setPrefHeight(150);
			        l2.setPrefWidth(300);
			        l2.setAlignment(Pos.CENTER);
			        l2.setHgap(50);
			        l2.setVgap(25);
			        l2.setPrefHeight(150);
			        l2.setPrefWidth(300);


					Label l=new Label("How to Play?");
					Label b1=new Label("Save using save and Exit");
					Label b2=new Label("Only 3 or more stars can help revive");
					Label b3=new Label("Use MouseClick to move");
			        l.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 15));
			        l.setTextFill(Color.web("#061731"));
			        b1.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 10));
			        b1.setTextFill(Color.web("#061731"));
			        b2.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 10));
			        b2.setTextFill(Color.web("#061731"));
			        b3.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 10));
			        b3.setTextFill(Color.web("#061731"));
			        Button b=new Button("Okay");
			        b.setId("shiny-orange");
			        
			        b.setOnAction(new EventHandler(){

						@Override
						public void handle(Event arg0) {
							p.hide();
							
						}
			        	
			        });
			        
//					 b1.setId("shiny-orange");
//					 b2.setId("shiny-orange");
//					 b3.setId("shiny-orange");
			        ObservableList list = l2.getChildren();  
			        
			        //Adding all the nodes to the observable list (HBox) 
			        list.addAll(l,b1,b2,b3,b); 
					p.getContent().add(l2);
					//p.getContent().add(l);

					p.show(primaryStage);
					// TODO Auto-generated method stub
					
				}});
	        
	        Help.setId("shiny-orange");
	        Help.setMaxWidth(150);

	        Button Load = new Button("LOAD GAME");
	     //   Load.setOnAction(event ->  primaryStage.setScene(scene2));
	        Load.setOnAction(new EventHandler() {

				@Override
				public void handle(Event arg0) {
					// TODO Auto-generated method stub
					
					try {
						System.out.println(mode);
						Pane rt = new Pane();
					    HBox layout = new HBox();
					      layout.setSpacing(20);  
					      layout.setMaxHeight(300);
					      //layout.setBorder(arg0);
					      //Setting the margin to the nodes 

					    layout.setStyle("-fx-background-color: #2a9d8f; -fx-padding: 10;-fx-border-style: solid inside;-fx-border-radius: 5;-fx-border-width: 2;-fx-border-insets: 5;-fx-border-color: #f1faee;");
						Popup pp=new Popup();
						
						Button b1=new Button("GAME 1");
				        b1.setId("shiny-orange");
				        
				        b1.setOnAction(new EventHandler() {

							@Override
							public void handle(Event arg0) {
								mode=1;
								Start.setText("Start Game 1");
								System.out.println(mode);
								pp.hide();
								
							}});
						
						Button b2=new Button("GAME 2");
						
				        b2.setId("shiny-orange");
				        b2.setMaxWidth(150);
				        b2.setOnAction(new EventHandler() {

							@Override
							public void handle(Event arg0) {
								mode=2;
								Start.setText("Start Game 2");
								System.out.println(mode);
								pp.hide();
								
							}});
				        
						Button b3=new Button("GAME 3");
						
				        b3.setId("shiny-orange");
				        b3.setMaxWidth(150);
				        b3.setOnAction(new EventHandler() {

							@Override
							public void handle(Event arg0) {
								mode=3;
								Start.setText("Start Game 3");
								System.out.println(mode);
								pp.hide();
								
							}});
				        
				        b1.setLayoutX(130);
				        b1.setLayoutY(50);
				        b1.setMaxWidth(100);
//				        layout.getChildren().add(b1);
//				        layout.getChildren().add(b2);
//				        layout.getChildren().add(b3);
				        layout.setMargin(b1, new Insets(20, 20, 20, 20)); 
				        layout.setMargin(b2, new Insets(20, 20, 20, 20)); 
				        layout.setMargin(b3, new Insets(20, 20, 20, 20)); 
				        ObservableList list = layout.getChildren();  
				        
				        //Adding all the nodes to the observable list (HBox) 
				        list.addAll(b1, b2, b3); 

				        //Scene scene4=new Scene(rt,300,300);
				        pp.getContent().add(layout);
				        pp.setX(525);
				        pp.setY(350);
				        pp.show(primaryStage);
						
//						var root = new Pane();
//							ball b=new ball();
//							
//					            FileInputStream fileOut = new FileInputStream(filepath);
//					            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
//					            ArrayList<Integer> balls= (ArrayList<Integer>)objectOut.readObject();
//					            
//					            
//					            objectOut.close();
//					            System.out.println(balls.get(0));
//					            fileOut.close();
//					            objectOut.close();
//					            FileInputStream fq = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\quads.txt");
//					            ObjectInputStream oq = new ObjectInputStream(fq);
//					            ArrayList<Integer> quads= (ArrayList<Integer>)oq.readObject();
//					            
//					            
//					            oq.close();
//					            System.out.println(quads.get(0));
//					            fq.close();
								//b.circle.setCenterY(balls.get(0));
							//	root.getChildren().add(b.circle);


						//	primaryStage.setScene(scene4);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}});

	        Load.setId("shiny-orange");
	        Load.setMaxWidth(150);
	        
//            FileInputStream fSP = new FileInputStream(ISHI_sessionpoints_filepath);
//            ObjectInputStream oSP = new ObjectInputStream(fSP);
//            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
//            SESHPOINTS.add(stars);
            
//            oSP.close();
//            System.out.println("The STARS  was succesfully read to a file");
//            fSP.close();


	        FileInputStream input = new FileInputStream(ISHI_STAR);
	        Image image = new Image(input);
	        ImageView imageView = new ImageView(image);
	        imageView.setTranslateX(-210);
	        imageView.setTranslateY(-340);
	        imageView.setFitHeight(40);
	        imageView.setFitWidth(40);
	        imageView.setPreserveRatio(true);

	        Text t = new Text();
	        t.setText(String.valueOf(univstar));
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

	        VBox vbox = new VBox(20,Start,Load, Exit,Run);
	        //vbox.setAlignment(Pos.CENTER);
	        VBox vbox2 = new VBox(20,Help);
//	        Help.setLayoutX(100);
//	        Help.setLayoutY(30);

	        vbox.setTranslateX(170);
	        vbox.setTranslateY(500);
	        vbox2.setTranslateX(330);
	        vbox2.setTranslateY(50);

	        rt.getChildren().addAll(vbox,imageView,t,t2);
	        rt.getChildren().add(vbox2);
	        
	        
	        BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream(ISHI_SCREEN),500,750,false,true),
	                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	                  BackgroundSize.DEFAULT);


	        rt.setBackground(new Background(myBI));

	        rt.setId("pane");
	        Scene scene = new Scene(rt, 500, 750);
	    	Run.setOnAction(new EventHandler() {

				@Override
				public void handle(Event arg0) {
					Bonus bonus=new Bonus();
					try {
						bonus.startbonus(primaryStage,scene);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
	    		
	    		
	    	});
	        
	        Start.setOnAction(new EventHandler() {
	        	
				@Override
				public void handle(Event arg0) {
					//Auto-generated method stub
					
					try {
						Game g=new Game();
						//g.startGame();   //to refresh saved game records

						// OBJECTS
						
						ArrayList<Integer> balls= new ArrayList<>();
						ArrayList<Integer> quads= new ArrayList<>();
						ArrayList<ArrayList<Integer>> diamonds= new ArrayList<>();
						ArrayList<ArrayList<Integer>> crosses= new ArrayList<>();
						ArrayList<Integer> lines= new ArrayList<>();
						ArrayList<Integer> squares= new ArrayList<>();
						ArrayList<ArrayList<Integer>> starsl= new ArrayList<>();
						ArrayList<ArrayList<Integer>> colorswitches= new ArrayList<>();
						ArrayList<Integer> TOTALPOINTS= new ArrayList<>();
						ArrayList<Integer> SESHPOINTS= new ArrayList<>();
						
						try {						 
				            FileInputStream fileOut = new FileInputStream(ISHI_filepath);
				            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
				            balls= (ArrayList<Integer>)objectOut.readObject();
				            System.out.println("The ball  was succesfully read to a file");
				            fileOut.close();
				            objectOut.close();
				            
				            FileInputStream fq = new FileInputStream(ISHI_quads_filepath);
				            ObjectInputStream oq = new ObjectInputStream(fq);
				            quads= (ArrayList<Integer>)oq.readObject();

				            oq.close();
				            System.out.println("The quad  was succesfully read to a file");
				            fq.close();
				            
				            FileInputStream fDIA = new FileInputStream(ISHI_diamonds_filepath);
				            ObjectInputStream oDIA = new ObjectInputStream(fDIA);
				            diamonds= (ArrayList<ArrayList<Integer>>)oDIA.readObject();
				            ArrayList<Integer> a2=new ArrayList<>();
				            
				            oDIA.close();
				            System.out.println("The DIA  was succesfully read to a file");
				            fDIA.close();
				            
				            FileInputStream fCROSS = new FileInputStream(ISHI_crosses_filepath);
				            ObjectInputStream oCROSS = new ObjectInputStream(fCROSS);
				            crosses= (ArrayList<ArrayList<Integer>>)oCROSS.readObject();

				            oCROSS.close();
				            System.out.println("The cross  was succesfully read to a file");
				            fCROSS.close();
				            
				            FileInputStream fLINES = new FileInputStream(ISHI_lines_filepath);
				            ObjectInputStream oLINES = new ObjectInputStream(fLINES);
				            lines= (ArrayList<Integer>)oLINES.readObject();

				            oLINES.close();
				            System.out.println("The LINES  was succesfully read to a file");
				            fLINES.close();
				            
				            FileInputStream fSQUARES = new FileInputStream(ISHI_squares_filepath);
				            ObjectInputStream oSQUARES = new ObjectInputStream(fSQUARES);
				            squares= (ArrayList<Integer>)oSQUARES.readObject();

				            oSQUARES.close();
				            System.out.println("The SQUARES  was succesfully read to a file");
				            fSQUARES.close();
				            
				            FileInputStream fSTAR = new FileInputStream(ISHI_stars_filepath);
				            ObjectInputStream oSTAR = new ObjectInputStream(fSTAR);
				            starsl= (ArrayList<ArrayList<Integer>>)oSTAR.readObject();

				            oSTAR.close();
				            System.out.println("The STAR  was succesfully read to a file");
				            fSTAR.close();
				            
				            FileInputStream fCS = new FileInputStream(ISHI_colorswitches_filepath);
				            ObjectInputStream oCS = new ObjectInputStream(fCS);
				            colorswitches= (ArrayList<ArrayList<Integer>>)oCS.readObject();

				            oCS.close();
				            System.out.println("The quad  was succesfully read to a file");
				            fCS.close();
				            
				            FileInputStream fSP = new FileInputStream(ISHI_sessionpoints_filepath);
				            ObjectInputStream oSP = new ObjectInputStream(fSP);
				            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();

				            oSP.close();
				            System.out.println("The STARS  was succesfully read to a file");
				            fSP.close();
				            
				 
				        } catch (Exception ex) {
				            ex.printStackTrace();
				        }
						ball b=new ball(speed);
						Star s=new Star();
						Stardeco d1=new Stardeco();
						Square sq=new Square();
						Quad q=new Quad(speed);
						Diamond d=new Diamond();
						Cross cr=new Cross();
						var root = new Pane();
						Canvas c = new Canvas(width * cornersize, height * cornersize);
					     ArrayList<ImageView> starlist=new ArrayList<>();
					     ArrayList<ColorSwitch> cslist=new ArrayList<>();
					     for (int i=0;i<5;i++) {
					    	 ImageView p=s.star();
					    	 starlist.add(p);
					     }

					     GraphicsContext gc = c.getGraphicsContext2D();
							Space sp=new Space();

					        
						     for (int i=0;i<5;i++) {
						    	 ColorSwitch cs=new ColorSwitch(200,250);
						    	 
						    	 cslist.add(cs);
						     }
							List<Rectangle> obstacle = generate();
							List<Rectangle> obstacle2 = generate();
					   
			 
						if (mode==1) {
						b.circle.setCenterY(balls.get(balls.size()-1));
						for (int i=0;i<20;i++) {
							obstacle.get(i).setY(lines.get(lines.size()-1));
							obstacle2.get(i).setY(lines.get(lines.size()-1));
						}
						
						for (int i=0;i<5;i++) {
							
							cslist.get(i).c.setCenterY(colorswitches.get(colorswitches.size()-1).get(i));
							starlist.get(i).setY(starsl.get(colorswitches.size()-1).get(i));
							
						}
						
						q.arc1.setCenterY(quads.get(quads.size()-1));
						q.arc2.setCenterY(quads.get(quads.size()-1));
						q.arc3.setCenterY(quads.get(quads.size()-1));
						q.arc4.setCenterY(quads.get(quads.size()-1));
						
						sq.rectangle.setY(squares.get(squares.size()-1));
						sq.rectangle2.setY(squares.get(squares.size()-1));
						sq.rectangle3.setY(squares.get(squares.size()-1));
						sq.rectangle4.setY(squares.get(squares.size()-1));
						//cs.c.setCenterY(colorswitches.get(colorswitches.size()-1));
						d.l.setStartX(diamonds.get(diamonds.size()-1).get(0));
						d.l.setStartY(diamonds.get(diamonds.size()-1).get(1));
						d.l.setEndX(diamonds.get(diamonds.size()-1).get(2));
						d.l.setEndY(diamonds.get(diamonds.size()-1).get(3));
						d.l2.setStartX(diamonds.get(diamonds.size()-1).get(4));
						d.l2.setStartY(diamonds.get(diamonds.size()-1).get(5));
						d.l2.setEndX(diamonds.get(diamonds.size()-1).get(6));
						d.l2.setEndY(diamonds.get(diamonds.size()-1).get(7));
						d.l3.setStartX(diamonds.get(diamonds.size()-1).get(8));
						d.l3.setStartY(diamonds.get(diamonds.size()-1).get(9));
						d.l3.setEndX(diamonds.get(diamonds.size()-1).get(10));
						d.l3.setEndY(diamonds.get(diamonds.size()-1).get(11));
						d.l4.setStartX(diamonds.get(diamonds.size()-1).get(12));
						d.l4.setStartY(diamonds.get(diamonds.size()-1).get(13));
						d.l4.setEndX(diamonds.get(diamonds.size()-1).get(14));
						d.l4.setEndY(diamonds.get(diamonds.size()-1).get(15));
						
						cr.l.setStartX(crosses.get(crosses.size()-1).get(0));
						cr.l.setStartY(crosses.get(crosses.size()-1).get(1));
						cr.l.setEndX(crosses.get(crosses.size()-1).get(2));
						cr.l.setEndY(crosses.get(crosses.size()-1).get(3));
						cr.l2.setStartX(crosses.get(crosses.size()-1).get(4));
						cr.l2.setStartY(crosses.get(crosses.size()-1).get(5));
						cr.l2.setEndX(crosses.get(crosses.size()-1).get(6));
						cr.l2.setEndY(crosses.get(crosses.size()-1).get(7));
						cr.l3.setStartX(crosses.get(crosses.size()-1).get(8));
						cr.l3.setStartY(crosses.get(crosses.size()-1).get(9));
						cr.l3.setEndX(crosses.get(crosses.size()-1).get(10));
						cr.l3.setEndY(crosses.get(crosses.size()-1).get(11));
						cr.l4.setStartX(crosses.get(crosses.size()-1).get(12));
						cr.l4.setStartY(crosses.get(crosses.size()-1).get(13));
						cr.l4.setEndX(crosses.get(crosses.size()-1).get(14));
						cr.l4.setEndY(crosses.get(crosses.size()-1).get(15));
						

							
							
							
							
						}
						
						if (mode==2) {
							
							
							b.circle.setCenterY(balls.get(balls.size()-2));
							for (int i=0;i<20;i++) {
								obstacle.get(i).setY(lines.get(lines.size()-2));
								obstacle2.get(i).setY(lines.get(lines.size()-2));
							}
							
							for (int i=0;i<5;i++) {
								
								cslist.get(i).c.setCenterY(colorswitches.get(colorswitches.size()-2).get(i));
								starlist.get(i).setY(starsl.get(colorswitches.size()-2).get(i));
								
							}
							
							q.arc1.setCenterY(quads.get(quads.size()-2));
							q.arc2.setCenterY(quads.get(quads.size()-2));
							q.arc3.setCenterY(quads.get(quads.size()-2));
							q.arc4.setCenterY(quads.get(quads.size()-2));
							
							sq.rectangle.setY(squares.get(squares.size()-2));
							sq.rectangle2.setY(squares.get(squares.size()-2));
							sq.rectangle3.setY(squares.get(squares.size()-2));
							sq.rectangle4.setY(squares.get(squares.size()-2));
							//cs.c.setCenterY(colorswitches.get(colorswitches.size()-1));
							d.l.setStartX(diamonds.get(diamonds.size()-2).get(0));
							d.l.setStartY(diamonds.get(diamonds.size()-2).get(1));
							d.l.setEndX(diamonds.get(diamonds.size()-2).get(2));
							d.l.setEndY(diamonds.get(diamonds.size()-2).get(3));
							d.l2.setStartX(diamonds.get(diamonds.size()-2).get(4));
							d.l2.setStartY(diamonds.get(diamonds.size()-2).get(5));
							d.l2.setEndX(diamonds.get(diamonds.size()-2).get(6));
							d.l2.setEndY(diamonds.get(diamonds.size()-2).get(7));
							d.l3.setStartX(diamonds.get(diamonds.size()-2).get(8));
							d.l3.setStartY(diamonds.get(diamonds.size()-2).get(9));
							d.l3.setEndX(diamonds.get(diamonds.size()-2).get(10));
							d.l3.setEndY(diamonds.get(diamonds.size()-2).get(11));
							d.l4.setStartX(diamonds.get(diamonds.size()-2).get(12));
							d.l4.setStartY(diamonds.get(diamonds.size()-2).get(13));
							d.l4.setEndX(diamonds.get(diamonds.size()-2).get(14));
							d.l4.setEndY(diamonds.get(diamonds.size()-2).get(15));
							
							cr.l.setStartX(crosses.get(crosses.size()-2).get(0));
							cr.l.setStartY(crosses.get(crosses.size()-2).get(1));
							cr.l.setEndX(crosses.get(crosses.size()-2).get(2));
							cr.l.setEndY(crosses.get(crosses.size()-2).get(3));
							cr.l2.setStartX(crosses.get(crosses.size()-2).get(4));
							cr.l2.setStartY(crosses.get(crosses.size()-2).get(5));
							cr.l2.setEndX(crosses.get(crosses.size()-2).get(6));
							cr.l2.setEndY(crosses.get(crosses.size()-2).get(7));
							cr.l3.setStartX(crosses.get(crosses.size()-2).get(8));
							cr.l3.setStartY(crosses.get(crosses.size()-2).get(9));
							cr.l3.setEndX(crosses.get(crosses.size()-2).get(10));
							cr.l3.setEndY(crosses.get(crosses.size()-2).get(11));
							cr.l4.setStartX(crosses.get(crosses.size()-2).get(12));
							cr.l4.setStartY(crosses.get(crosses.size()-2).get(13));
							cr.l4.setEndX(crosses.get(crosses.size()-2).get(14));
							cr.l4.setEndY(crosses.get(crosses.size()-2).get(15));
		
							
							
						}
					      
						
						if (mode==3) {
							
							b.circle.setCenterY(balls.get(balls.size()-3));
							for (int i=0;i<20;i++) {
								obstacle.get(i).setY(lines.get(lines.size()-3));
								obstacle2.get(i).setY(lines.get(lines.size()-3));
							}
							
							for (int i=0;i<5;i++) {
								
								cslist.get(i).c.setCenterY(colorswitches.get(colorswitches.size()-3).get(i));
								starlist.get(i).setY(starsl.get(colorswitches.size()-3).get(i));
								
							}
							
							q.arc1.setCenterY(quads.get(quads.size()-3));
							q.arc2.setCenterY(quads.get(quads.size()-3));
							q.arc3.setCenterY(quads.get(quads.size()-3));
							q.arc4.setCenterY(quads.get(quads.size()-3));
							
							sq.rectangle.setY(squares.get(squares.size()-3));
							sq.rectangle2.setY(squares.get(squares.size()-3));
							sq.rectangle3.setY(squares.get(squares.size()-3));
							sq.rectangle4.setY(squares.get(squares.size()-3));
							//cs.c.setCenterY(colorswitches.get(colorswitches.size()-1));
							d.l.setStartX(diamonds.get(diamonds.size()-3).get(0));
							d.l.setStartY(diamonds.get(diamonds.size()-3).get(1));
							d.l.setEndX(diamonds.get(diamonds.size()-3).get(2));
							d.l.setEndY(diamonds.get(diamonds.size()-3).get(3));
							d.l2.setStartX(diamonds.get(diamonds.size()-3).get(4));
							d.l2.setStartY(diamonds.get(diamonds.size()-3).get(5));
							d.l2.setEndX(diamonds.get(diamonds.size()-3).get(6));
							d.l2.setEndY(diamonds.get(diamonds.size()-3).get(7));
							d.l3.setStartX(diamonds.get(diamonds.size()-3).get(8));
							d.l3.setStartY(diamonds.get(diamonds.size()-3).get(9));
							d.l3.setEndX(diamonds.get(diamonds.size()-3).get(10));
							d.l3.setEndY(diamonds.get(diamonds.size()-3).get(11));
							d.l4.setStartX(diamonds.get(diamonds.size()-3).get(12));
							d.l4.setStartY(diamonds.get(diamonds.size()-3).get(13));
							d.l4.setEndX(diamonds.get(diamonds.size()-3).get(14));
							d.l4.setEndY(diamonds.get(diamonds.size()-3).get(15));
							
							cr.l.setStartX(crosses.get(crosses.size()-3).get(0));
							cr.l.setStartY(crosses.get(crosses.size()-3).get(1));
							cr.l.setEndX(crosses.get(crosses.size()-3).get(2));
							cr.l.setEndY(crosses.get(crosses.size()-3).get(3));
							cr.l2.setStartX(crosses.get(crosses.size()-3).get(4));
							cr.l2.setStartY(crosses.get(crosses.size()-3).get(5));
							cr.l2.setEndX(crosses.get(crosses.size()-3).get(6));
							cr.l2.setEndY(crosses.get(crosses.size()-3).get(7));
							cr.l3.setStartX(crosses.get(crosses.size()-3).get(8));
							cr.l3.setStartY(crosses.get(crosses.size()-3).get(9));
							cr.l3.setEndX(crosses.get(crosses.size()-3).get(10));
							cr.l3.setEndY(crosses.get(crosses.size()-3).get(11));
							cr.l4.setStartX(crosses.get(crosses.size()-3).get(12));
							cr.l4.setStartY(crosses.get(crosses.size()-3).get(13));
							cr.l4.setEndX(crosses.get(crosses.size()-3).get(14));
							cr.l4.setEndY(crosses.get(crosses.size()-3).get(15));
		
							
							
						}
						
						
						


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
						
				        Button Start = new Button("PAUSE",d1.pause());
				        Start.setLayoutX(400);
				        Start.setLayoutY(9);
				        Start.setStyle("-fx-background-color: #061731;-fx-text-fill: #f1faee ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold");
				         root.getChildren().add(Start);
						//b.circle.setCenterY(pr1);
				        //b=new ball();

						root.getChildren().add(b.cir());
						
						root.getChildren().add(d1.star());

						ColorSwitch cs=new ColorSwitch(200,250);
				        //root.getChildren().add(cs.cir());
						root.getChildren().add(q.arc1());
						root.getChildren().add(q.arc2());
						root.getChildren().add(q.arc3());

						root.getChildren().add(q.arc4());
						root.getChildren().add(sq.square1()); //rm
						root.getChildren().add(sq.square2()); //lm
						root.getChildren().add(sq.square3()); //top
						root.getChildren().add(sq.square4());

						for (int i=0;i<20;i++) {
							root.getChildren().add(obstacle.get(i));
						}
						for (int i=0;i<20;i++) {
							root.getChildren().add(obstacle2.get(i));
						}

						if (mega.size()==0) {
						mega.add(obstacle);
						mega.add(obstacle2);}
						
						else if (mega.size()==2) {
							System.out.println("dai jobe");
							mega.set(0,obstacle);
							mega.set(1,obstacle2);
						}
						ImageView s1= starlist.get(1);
						ImageView s2= starlist.get(2);
						ImageView s3= starlist.get(3);
						ImageView s4= starlist.get(4);
						s1.setY(q.arc1.getCenterY()-20);
						s2.setY(sq.rectangle4.getY()-80);
						s3.setY(cr.l2.getEndY()-50);
						s4.setY(d.l2.getEndY()-50);
						for (int i=0;i<5;i++) {
							ImageView p=starlist.get(i);
						root.getChildren().add(p);
						}
						

						
						cslist.get(1).c.setCenterY(q.arc1.getCenterY()-130);
						cslist.get(2).c.setCenterY(sq.rectangle4.getY()-200);
						cslist.get(3).c.setCenterY(cr.l2.getEndY()-80);
						cslist.get(4).c.setCenterY(d.l2.getEndY()-80);
						root.getChildren().add(cslist.get(0).c);
						root.getChildren().add(cslist.get(1).c);
						root.getChildren().add(cslist.get(2).c);
						root.getChildren().add(cslist.get(3).c);
						root.getChildren().add(cslist.get(4).c);
//						for (int i=0;i<5;i++) {
//							System.out.println("cs add");
//							Circle p=cslist.get(i);
//						root.getChildren().add(p);
//						}
						
						
						
						
						Scene scene2 = new Scene(root, 500, 600);
				        
						
						new AnimationTimer() {
							long lastTick = 0;
							long tick=0;
							public void handle(long now) {
								if (lastTick == 0) {
									lastTick = now;
									tick++;
									try {
										sp.tick(mega,gc,obstacle,b,q,Start,primaryStage,starlist,cslist,sq,cr,d,scene2,components,univstar,scene,pl);
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									return;
								}

								if (now - lastTick > 100000000*(speed)) {
									tick++;
									lastTick = now;
									if (tick%15==0) {
										speed=speed-(float)0.5;
									}
									try {
										sp.tick(mega,gc,obstacle,b,q,Start,primaryStage,starlist,cslist,sq,cr,d,scene2,components,univstar,scene,pl);
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
					}
					
					
				}});
	        
	        

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
