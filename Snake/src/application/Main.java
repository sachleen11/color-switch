package application;
	



import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import java.util.Random;
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


class obstacle{
	
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
	//static ball b=new ball(x,y);
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

    protected void SetUp(Pane mainPage, Scene scene2, Stage primaryStage) throws Exception{
        Font gamefont = Font.font(30);

        Button Start = new Button("START GAME");
        Start.setFont(gamefont);
        Start.setOnAction(event ->  primaryStage.setScene(scene2));
        Start.setId("shiny-orange");
        Start.setMaxWidth(190);
        

        Button Exit = new Button("EXIT GAME");
        Exit.setFont(gamefont);
        
        Exit.setOnAction(event -> Platform.exit());
        Exit.setId("shiny-orange");
        Exit.setMaxWidth(190);

        
        FileInputStream input = new FileInputStream("C:\\Users\\ishik\\Downloads\\starf.png");
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
        t.setFont(Font.font("Proxima Nova",FontWeight.BOLD,20));
        t.setFill(Color.WHITE);
        t.setTranslateX(-180);
        t.setTranslateY(-338);

        Text t2 = new Text();
        //String t = "BEST SCORE";
        t2.setText("BEST SCORE: 7");
        t2.setFont(Font.font("Proxima Nova",FontWeight.BOLD,20));
        t2.setFill(Color.WHITE);
        t2.setTranslateX(160);
        t2.setTranslateY(-340);
        //Group img = new Group(imageView);

        VBox vbox = new VBox(40,Start, Exit);

        vbox.setTranslateX(170);
        vbox.setTranslateY(500);

        mainPage.getChildren().addAll(vbox,imageView,t,t2);
    }

	
	public static class Cross extends obstacle{
		Line l = new Line();
		Line l2 = new Line();
		Line l3 = new Line();
		Line l4 = new Line();
		Rectangle rectangle4=new Rectangle();
		public Line line1() {
		l.setStartX(300);
		l.setStartY(350);
		l.setEndX(250);
		l.setEndY(400);
		l.setStroke(Color.web("ED476F",1.0));
		l.setStrokeWidth(10);
		return l;
		}
		public Line line2() {
			l2.setStartX(250);
			l2.setStartY(400);
			l2.setEndX(300);
			l2.setEndY(450);
			l2.setStroke(Color.web("FAD167",1.0));
			l2.setStrokeWidth(10);
			return l2;
		}
		public Line line3() {
			l3.setStartX(250);
			l3.setStartY(400);
			l3.setEndX(200);
			l3.setEndY(450);
			l3.setStroke(Color.web("61D8A2",1.0));
			l3.setStrokeWidth(10);
			return l3;
		}
		public Line line4() {
//			l4.setStartX(250);
//			l4.setStartY(400);
//			l4.setEndX(200);
//			l4.setEndY(450);
			l4.setStartX(200);
			l4.setStartY(350);
			l4.setEndX(250);
			l4.setEndY(400);
			l4.setStroke(Color.web("368BB2",1.0));
			l4.setStrokeWidth(10);
			return l4;
		}
	}
	
	public static class Diamond extends obstacle{
		Line l = new Line();
		Line l2 = new Line();
		Line l3 = new Line();
		Line l4 = new Line();
		Rectangle rectangle4=new Rectangle();
		public Line line1() {
		l.setStartX(300);
		l.setStartY(480);
		l.setEndX(270);
		l.setEndY(530);
		l.setStroke(Color.web("ED476F",1.0));
		l.setStrokeWidth(5);
		return l;
		}
		public Line line2() {
			l2.setStartX(270);
			l2.setStartY(532);
			l2.setEndX(200);
			l2.setEndY(532);
			l2.setStroke(Color.web("FAD167",1.0));
			l2.setStrokeWidth(5);
			return l2;
		}
		public Line line3() {
			l3.setStartX(230);
			l3.setStartY(480);
			l3.setEndX(200);
			l3.setEndY(530);
			l3.setStroke(Color.web("61D8A2",1.0));
			l3.setStrokeWidth(5);
			return l3;
		}
		public Line line4() {
			l4.setStartX(230);
			l4.setStartY(480);
			l4.setEndX(300);
			l4.setEndY(480);
			l4.setStroke(Color.web("368BB2",1.0));
			l4.setStrokeWidth(5);
			return l4;
		}
	}
	
	public static class ball extends obstacle{
		int x;
		int y;
		int color=0;
		Circle circle = new Circle();
		public ball(int x, int y) {
			circle.setCenterX(250); 
			circle.setCenterY(800
					); 
			circle.setRadius(15 );
			circle.setFill(Color.web("ED476F",1.0));
		}	
		
		public Circle cir() {
			
			
			
			return circle;
		}
	}
	
	
	public static class Quad extends obstacle{
		Arc arc1 = new Arc();
		Arc arc2= new Arc();
		Arc arc3 = new Arc();
		Arc arc4 = new Arc();
		public Arc arc1() {
			arc1.setCenterX(250.0f); 
			arc1.setCenterY(280); 
			arc1.setRadiusX(50); 
			arc1.setRadiusY(50);
	        arc1.setStartAngle(0.0f); 
	        arc1.setLength(90.0f); 
	        arc1.setStrokeWidth(10);
			arc1.setStroke(Color.web("ED476F",1.0));
			arc1.setFill(Color.web("061731",1.0));
			return arc1;
		}
		public Arc arc2() {
			arc2.setCenterX(250.0f); 
			arc2.setCenterY(280); 
			arc2.setRadiusX(50); 
			arc2.setRadiusY(50);
			arc2.setStartAngle(90.0f); 
			arc2.setLength(90.0f); 
			arc2.setStrokeWidth(10);
			arc2.setFill(Color.web("061731",1.0));
			arc2.setStroke(Color.web("61D8A2",1.0));
			return arc2;
		}
		public Arc arc3() {
			arc3.setCenterX(250.0f); 
			arc3.setCenterY(280); 
			arc3.setRadiusX(50); 
			arc3.setRadiusY(50);
			arc3.setStartAngle(180.0f); 
			arc3.setLength(90.0f); 
			arc3.setStrokeWidth(10);
			arc3.setFill(Color.web("061731",1.0));
			arc3.setStroke(Color.web("FAD167",1.0));
			return arc3;
		}
		public Arc arc4() {
			arc4.setCenterX(250.0f); 
			arc4.setCenterY(280); 
			arc4.setRadiusX(50); 
			arc4.setRadiusY(50);
			arc4.setStartAngle(270.0f); 
			arc4.setLength(90.0f); 
			arc4.setStrokeWidth(10);
			arc4.setFill(Color.web("061731",1.0));
			arc4.setStroke(Color.web("368BB2",1.0));
			return arc4;
		}
		
		public void inf(boolean v) {
			int i=0;
			boolean loop=true;
			int angle=0;
			while (!v) {
				arc1.setStartAngle(arc1.getStartAngle()+angle);
				arc2.setStartAngle(arc2.getStartAngle()+angle);
				arc3.setStartAngle(arc3.getStartAngle()+angle);
				arc4.setStartAngle(arc4.getStartAngle()+angle);
				angle=angle+90;
				i++;
			}
		}
	}
	
	public static class Square extends obstacle{
		
		Rectangle rectangle = new Rectangle();
		Rectangle rectangle2 = new Rectangle();
		Rectangle rectangle3 = new Rectangle();
		Rectangle rectangle4 = new Rectangle();
		public Rectangle square1() {
	        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTPINK), new Stop(1, Color.CORAL)};  
	        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
		      rectangle.setX(300); 
		      rectangle.setY(100); 
		      rectangle.setWidth(10); 
		      rectangle.setHeight(100);
		      rectangle.setFill(Color.web("ED476F",1.0));

		      
		      Group g=new Group();
		      
		      return rectangle;
		}
		public Rectangle square2() {
	        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTGREEN), new Stop(1, Color.FORESTGREEN)};  
	        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
			rectangle2.setX(200); 
			rectangle2.setY(100); 
			rectangle2.setWidth(10); 
			rectangle2.setHeight(100);
			rectangle2.setFill(Color.web("61D8A2",1.0));

			
			Group g=new Group();
			
			return rectangle2;
		}
		public Rectangle square3() {
	        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTGOLDENRODYELLOW), new Stop(1, Color.YELLOW)};  
	        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 

			rectangle3.setX(200); 
			rectangle3.setY(100); 
			rectangle3.setWidth(100); 
			rectangle3.setHeight(10);
			rectangle3.setFill(Color.web("FAD167",1.0));

			
			//Group g=new Group();
			
			return rectangle3;
		}
		public Rectangle square4() {
	        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.BLUE)};  
	        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops); 
	        
			rectangle4.setX(200); 
			rectangle4.setY(200); 
			rectangle4.setWidth(110); 
			rectangle4.setHeight(10);
			rectangle4.setFill(Color.web("368BB2",1.0));

			return rectangle4;
		}
		
	}

	public static class ColorSwitch {
		int x;
		int y;
		int color;

		public ColorSwitch(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	
	public static class Star{

		public ImageView star() throws FileNotFoundException{
		Image image = new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\starf.png"));
		ImageView imageView = new ImageView(image);
		imageView.setX(230); 
	    imageView.setY(625);
	    imageView.setFitHeight(50); 
	    imageView.setFitWidth(100);
	    imageView.setPreserveRatio(true);
	    return imageView;
		}
	    
		
	}
	
	public static class bg{

		public ImageView star() throws FileNotFoundException{
		Image image = new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\color_screen.png"));
		ImageView imageView = new ImageView(image);
		imageView.setX(250); 
	    imageView.setY(325);
	    imageView.setFitHeight(500); 
	    imageView.setFitWidth(750);
	    imageView.setPreserveRatio(true);
	    return imageView;
		}
	    
		
	}
	public static class Stardeco{

		public ImageView star() throws FileNotFoundException{
		Image image = new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\starf.png"));
		ImageView imageView = new ImageView(image);
		imageView.setX(12); 
	    imageView.setY(9);
	    imageView.setFitHeight(25); 
	    imageView.setFitWidth(25);
	    imageView.setPreserveRatio(true);
	    return imageView;
		}
		public ImageView pause() throws FileNotFoundException{
			Image image = new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\pause.png"));
			ImageView imageView = new ImageView(image);
			imageView.setX(460); 
			imageView.setY(9);
			imageView.setFitHeight(35); 
			imageView.setFitWidth(35);
			imageView.setPreserveRatio(true);
			return imageView;
		}
	    
		
	}
	public static List<Rectangle> generate(GraphicsContext gc) {
		// List<Corner> obstacle = new ArrayList<>();
		 List<Rectangle> Linear = new ArrayList<>();
		 int j=30;
		 for (int i=0;i<5;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j); 
				r.setY(700); 
				r.setWidth(30); 
				r.setHeight(30);
				r.setFill(Color.web("ED476F",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		//obstacle.add(new Corner(width ,4* height /5 ));
		j=j+30;
}
		 for (int i=5;i<10;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j); 
				r.setY(700); 
				r.setWidth(30); 
				r.setHeight(30);
				r.setFill(Color.web("61D8A2",1.0));
				//r.setStroke(Color.web("61D8A2",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		//obstacle.add(new Corner(width ,4* height /5 ));
		j=j+30;
}
		 for (int i=10;i<15;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j); 
				r.setY(700); 
				r.setWidth(30); 
				r.setHeight(30);
				r.setFill(Color.web("FAD167",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		//obstacle.add(new Corner(width ,4* height /5 ));
		j=j+30;
}
		 for (int i=15;i<20;i++) {
			 Rectangle r=new Rectangle();
				r.setX(j); 
				r.setY(700); 
				r.setWidth(30); 
				r.setHeight(30);
				r.setFill(Color.web("368BB2",1.0));
				r.setStroke(Color.web("061731",1.0));
				Linear.add(r);
		//obstacle.add(new Corner(width ,4* height /5 ));
		j=j+30;
}

		return Linear;
	}



	public void start(Stage primaryStage) {
		try {

	        //ishika
			Circle ball = new Circle(x, Color.DARKSLATEBLUE);
			Star s=new Star();
			Stardeco d1=new Stardeco();

			DropShadow dropShadow = new DropShadow();
			dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
			dropShadow.setColor(Color.PERU);
		      dropShadow.setHeight(5); 
		      
		      //Setting the width of the shadow 
		      dropShadow.setWidth(5); 
		      
		      //Setting the radius of the shadow 
		      dropShadow.setRadius(5); 
		      
		      //setting the offset of the shadow 
		      dropShadow.setOffsetX(3); 
		      dropShadow.setOffsetY(2); 
		      
		      //Setting the spread of the shadow 
		      dropShadow.setSpread(5);
			ImageView p=s.star();
			//ImageView p2=d1.star();
			//p.setEffect(dropShadow);
			Square sq=new Square();
			Quad q=new Quad();
			Diamond d=new Diamond();
			Cross cr=new Cross();
			var root = new Pane();
			//VBox root = new VBox();
			Canvas c = new Canvas(width * cornersize, height * cornersize);
			
			GraphicsContext gc = c.getGraphicsContext2D();
			ball b=new ball(width/3,height/3);
			//root.getChildren().add(b.cir());
			root.getChildren().add(c);
			root.getChildren().add(cr.line1());
			root.getChildren().add(cr.line2());
			root.getChildren().add(cr.line3());
			root.getChildren().add(cr.line4());
			
			root.getChildren().add(d.line1());
			root.getChildren().add(d.line2());
			root.getChildren().add(d.line3());
			root.getChildren().add(d.line4());
		
			root.getChildren().add(b.circle);
			root.getChildren().add(p);
			root.getChildren().add(d1.star());
			root.getChildren().add(d1.pause());
			root.getChildren().add(q.arc1());
			root.getChildren().add(q.arc2());
			root.getChildren().add(q.arc3());
			
			root.getChildren().add(q.arc4());
			//q.inf();
			//sq.square4().setFill(linear);
			root.getChildren().add(sq.square1());
			root.getChildren().add(sq.square2());
			root.getChildren().add(sq.square3());
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
			//root.getChildren().add(ball);

			new AnimationTimer() {
				long lastTick = 0;

				public void handle(long now) {
					if (lastTick == 0) {
						lastTick = now;
						tick(gc,obstacle,b,q);
						return;
					}

					if (now - lastTick > 1000000000 / speed) {
						lastTick = now;
						tick(gc,obstacle,b,q);
					}
				}

			}.start();

			
			Scene scene2 = new Scene(root, width * cornersize, height * cornersize);

			// control
			scene2.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
				if (key.getCode() == KeyCode.W) {
					
					//ball.setCenterX(x++);
					
					direction = Dir.up;
					
				}
				//direction=Dir.down;

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

			bg photo=new bg();
	        StackPane rt = new StackPane();
	        SetUp(rt,scene2,primaryStage);
	       // rt.getChildren().add(photo.star());
	        BackgroundImage myBI= new BackgroundImage(new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\color_screen.png"),500,750,false,true),
	                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	                  BackgroundSize.DEFAULT);
	        
	        
	        //then you set to your node
	        rt.setBackground(new Background(myBI));
	        //rt.setBackground(arg0);
	        rt.setId("pane");
	        Scene scene = new Scene(rt, 500, 750);
	        scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());

	        //Scene s_img = new Scene(img, 500,600);
	        primaryStage.setTitle("Color Switch");
	        primaryStage.setScene(scene);
	        //primaryStage.setScene(s_img);
	        primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// tick
	public static void tick(GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q) {

		for (int i = obstacle.size() - 1; i >= 1; i--) {

			mega.get(0).get(i).setX(mega.get(0).get(i - 1).getX());
			mega.get(0).get(i).setY(mega.get(0).get(i - 1).getY());
			mega.get(1).get(i).setX(mega.get(1).get(i - 1).getX());
			mega.get(1).get(i).setY(mega.get(1).get(i - 1).getY());
			//obstacle.get(i).y = obstacle.get(i - 1).y;
		}
		
		
		boolean loop=true;
		//q.inf(gameOver);
		switch (direction) {
		case up:
			
			//snake.get(0).y--;
			//obstacle.get(0).x--;
			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
			mega.get(1).get(0).setX(mega.get(0).get(0).getX()-30);
			int i=(int)ball.circle.getCenterY();
			i=i-30;
			ball.circle.setCenterY(i);
			q.arc1.setStartAngle(q.arc1.getStartAngle()+90);
			q.arc2.setStartAngle(q.arc2.getStartAngle()+90);
			q.arc3.setStartAngle(q.arc3.getStartAngle()+90);
			q.arc4.setStartAngle(q.arc4.getStartAngle()+90);

			break;
		case down:

			//obstacle.get(0).x--;
			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
			mega.get(1).get(0).setX(mega.get(0).get(0).getX()-30);
			int j=(int)ball.circle.getCenterY();
			j=j+30;
			ball.circle.setCenterY(j);
			//b.y++;

			break;
		case left:

			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
			mega.get(1).get(0).setX(mega.get(1).get(0).getX()-30);
			q.arc1.setStartAngle(q.arc1.getStartAngle()+90);
			q.arc2.setStartAngle(q.arc2.getStartAngle()+90);
			q.arc3.setStartAngle(q.arc3.getStartAngle()+90);
			q.arc4.setStartAngle(q.arc4.getStartAngle()+90);
//			j=(int)ball.circle.getCenterY();
//			j=j+30;
//			ball.circle.setCenterY(j);
		      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
		          @Override 
		          public void handle(MouseEvent e) { 
		             //System.out.println("Hello World");
		  			int i=(int)ball.circle.getCenterY();
					i=i-30;
					ball.circle.setCenterY(i);
		            // ball.circle.setFill(Color.DARKSLATEBLUE);
		          } 
		       };

			break;


		}



		// fill
		// background
		gc.setFill(Color.web("061731",1.0));
		gc.fillRect(0, 0, width * cornersize, height * cornersize);

		// score
		gc.setFill(Color.web("F8FDE7",1.0));
		Font f=Font.font("Proxima Nova",FontWeight.BOLD, (double)27);
		gc.setFont(f);
		gc.fillText(" " + stars, 40, 30);

		// random foodcolor
		
		Color cc = Color.WHITE;


		
		colorSwitch.color=rand.nextInt(3)+1;
		if (colorSwitch.color==1) {
			gc.setFill(Color.web("61D8A2",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		if (colorSwitch.color==2) {
			gc.setFill(Color.web("ED476F",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		if (colorSwitch.color==3) {
			gc.setFill(Color.web("FAD167",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		if (colorSwitch.color==4) {
			gc.setFill(Color.web("368BB2",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}

		if (ball.circle.getCenterY()==710) {
			//ball.circle.setFill(Color.PINK);
		for (int i=0;i<mega.get(0).size();i++) {
			if (mega.get(0).get(i).getX()==240) {
				//ball.circle.setFill(Color.PINK);
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
		
		// 230 625  800-30x=625 175
		if (ball.circle.getCenterY()==620) {
			//System.out.println("hufwc");
			//ball.circle.setFill(Color.PINK);
			stars++;
		}
		
		
		if (ball.circle.getCenterY()==560) {
			ball.color=colorSwitch.color;

			if (ball.color==1) {
				//Corner c=snake.get(0);
				ball.circle.setFill(Color.web("61D8A2",1.0));
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
			if (ball.color==2) {
				ball.circle.setFill(Color.web("ED476F",1.0));
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
			if (ball.color==3) {
				ball.circle.setFill(Color.web("FAD167",1.0));
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
			if (ball.color==4) {
				ball.circle.setFill(Color.web("368BB2",1.0));
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
		}
		
		if (gameOver) {
			//gc.setFill(Color.BLACK);
			gc.setFill(Color.web("e63946",1.0));
			gc.setFont(Font.font("Proxima Nova",FontWeight.BOLD, 50));
			//gc.fillRect(arg0, arg1, arg2, arg3);
			
			gc.fillText("GAME OVER", 110, 75);
			int i=0;
			while (i!=100000) {
			ball.circle.setCenterY(ball.circle.getCenterY()-10);
			i++;}

			return;
		}
		

	}

	// food
//gravity
	public static void gravity(ball ball) {
		int g=5;
		while (ball.circle.getCenterY()<800)
		ball.circle.setCenterY(ball.circle.getCenterY()+10);
		}

	public static void main(String[] args) {
		launch(args);
	}
}


