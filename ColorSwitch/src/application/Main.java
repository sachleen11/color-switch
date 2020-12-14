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
	static int gmode=0;

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
			
			
	    	Space sm=new Space();
	        Button Start = new Button("START GAME");
	        //Start.setOnAction(event ->  primaryStage.setScene(scene2));
	        Start.setOnAction(new EventHandler() {
	
				@Override
				public void handle(Event arg0) {
					//Auto-generated method stub
					
					try {
						ball b=new ball();


						Circle ball = new Circle(x, Color.DARKSLATEBLUE);
						Star s=new Star();
						Stardeco d1=new Stardeco();
						
						//FILE REFRESH
						
//						ArrayList<Integer> balls= new ArrayList<>();
//						ArrayList<Integer> quads= new ArrayList<>();
//						ArrayList<ArrayList<Integer>> diamonds= new ArrayList<>();
//						ArrayList<ArrayList<Integer>> crosses= new ArrayList<>();
//						ArrayList<Integer> lines= new ArrayList<>();
//						ArrayList<Integer> squares= new ArrayList<>();
//						ArrayList<ArrayList<Integer>> starsl= new ArrayList<>();
//						ArrayList<ArrayList<Integer>> colorswitches= new ArrayList<>();
//						ArrayList<Integer> TOTALPOINTS= new ArrayList<>();
//						ArrayList<Integer> SESHPOINTS= new ArrayList<>();
//						
//						
//						
//						FileOutputStream fi = new FileOutputStream(new File(filepath));
//			            ObjectOutputStream oi = new ObjectOutputStream(fi);
//			           
//			            oi.writeObject(balls);
//			            oi.close();
//			            System.out.println("done");
//			            fi.close();
//			            
//			            
//			            FileOutputStream fiq = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\quads.txt"));
//			            ObjectOutputStream oiq = new ObjectOutputStream(fiq);
//			            
//			            oiq.writeObject(quads);
//			            oiq.close();
//			            System.out.println("done");
//			            fiq.close();
//			            
//			            
//			            FileOutputStream fid = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\diamonds.txt"));
//			            ObjectOutputStream oid = new ObjectOutputStream(fid);
//			            
//			            oid.writeObject(diamonds);
//			            oid.close();
//			            System.out.println("done");
//			            fid.close();
//			            
//			            
//			            FileOutputStream fic = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\crosses.txt"));
//			            ObjectOutputStream oic = new ObjectOutputStream(fic);
//			            
//			            oic.writeObject(crosses);
//			            oic.close();
//			            System.out.println("done");
//			            fic.close();
//			            
//			            
//			            FileOutputStream fil = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\lines.txt"));
//			            ObjectOutputStream oil = new ObjectOutputStream(fil);
//			            
//			            oil.writeObject(lines);
//			            oil.close();
//			            System.out.println("done");
//			            fil.close();
//			            
//			            
//			            FileOutputStream fis = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\squares.txt"));
//			            ObjectOutputStream ois = new ObjectOutputStream(fis);
//			            
//			            ois.writeObject(squares);
//			            ois.close();
//			            System.out.println("done");
//			            fis.close();
//			            
//			            
//			            FileOutputStream fist = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\stars.txt"));
//			            ObjectOutputStream oist = new ObjectOutputStream(fist);
//			            
//			            oist.writeObject(starsl);
//			            oist.close();
//			            System.out.println("done");
//			            fist.close();
//			            
//			            
//			            FileOutputStream fics = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\colorswitches.txt"));
//			            ObjectOutputStream oics = new ObjectOutputStream(fics);
//			            
//			            oics.writeObject(colorswitches);
//			            oics.close();
//			            System.out.println("done");
//			            fics.close();
//						
//						
//			            FileOutputStream fiTP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt"));
//			            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
//			            
//			            oiTP.writeObject(TOTALPOINTS);
//			            oiTP.close();
//			            System.out.println("done");
//			            fiTP.close();
//						
//			            FileOutputStream fiSP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\sessionpoints.txt"));
//			            ObjectOutputStream oiSP = new ObjectOutputStream(fiSP);
//			            
//			            oiSP.writeObject(SESHPOINTS);
//			            oiSP.close();
//			            System.out.println("done");
//			            fiSP.close();
			 

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

						Space sp=new Space();
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
										sp.tick(mega,gc,obstacle,b,q,Start,primaryStage,starlist,cs,sq,cr,d,scene2,components);
									} catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									return;
								}

								if (now - lastTick > 100000000*(speed-1)) {
									lastTick = now;
									try {
										sp.tick(mega,gc,obstacle,b,q,Start,primaryStage,starlist,cs,sq,cr,d,scene2,components);
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
