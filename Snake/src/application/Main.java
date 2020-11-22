package application;
	



import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.scene.shape.Arc;

public class Main extends Application {
	// variable
	
	static int speed = 5;
	static int foodcolor = 0;
	static int width = 20;
	static int height = 35;
//	static int foodX = 5;
//	static int foodY = height/3;
	static int x=0;
	static int y=0;
	static int cornersize = 25;
	static List<Corner> snake = new ArrayList<>();
	static Corner food = new Corner(10,20);
	static List<List<Rectangle>> mega= new ArrayList<List<Rectangle>>();
	//static ball b=new ball(x,y);
	static Dir direction = Dir.left;
	static boolean gameOver = false;
	static ArcTo arcTo;
	
	static Random rand = new Random();
	
	
	public enum Dir {
		left, right, up, down
	}
	
	public static class Cross{
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
	
	public static class Diamond{
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
	
	public static class ball{
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
	
	
	public static class Quad{
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
	
	public static class Square{
		
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

	public static class Corner {
		int x;
		int y;
		int color;

		public Corner(int x, int y) {
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
		 List<Corner> obstacle = new ArrayList<>();
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
		obstacle.add(new Corner(width ,4* height /5 ));
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
		obstacle.add(new Corner(width ,4* height /5 ));
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
		obstacle.add(new Corner(width ,4* height /5 ));
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
		obstacle.add(new Corner(width ,4* height /5 ));
		j=j+30;
}

		return Linear;
	}
	
	
//	public static void action(List<Corner> obstacle, GraphicsContext gc) {
//
//		for (int i = obstacle.size() - 1; i >= 1; i--) {
//
//			obstacle.get(i).x = obstacle.get(i - 1).x;
//			obstacle.get(i).y = obstacle.get(i - 1).y;
//		}
//		
//		switch (direction) {
//		case up:
//			
//			//snake.get(0).y--;
//			obstacle.get(0).x--;
//			//snake.get(0).y++;
//			//snake.get(0).y++;
//			//b.y--;
//			
//			if (snake.get(0).y < 0) {
//				//gameOver = true;
//			}
//			break;
//		case down:
//			//snake.get(0).y++;
//			obstacle.get(0).x--;
//			//b.y++;
//			if (snake.get(0).y > height) {
//				//gameOver = true;
//			}
//			break;
//		case left:
//			//snake.get(0).x--;
//			obstacle.get(0).x--;
//			//b.x++;
//			
////			if (snake.get(0).x < 0) {
////				gameOver = true;
////			}
//			break;	
//		
//		}
//		
//
//	}


	public void start(Stage primaryStage) {
		try {
			//newFood();
			
			
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

			Scene scene = new Scene(root, width * cornersize, height * cornersize);

			// control
			scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
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

			// add start snake parts
			
			snake.add(new Corner(width, height ));

			//snake.add(new Corner(width / 2, height / 2));
			//If you do not want to use css style, you can just delete the next line.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("SNAKE GAME");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// tick
	public static void tick(GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q) {
		//gravity(ball);

//		for (int j=0;j<mega.size();j++) {
//			//List<Corner> obstacle2 = mega.get(j);
//			action(obstacle2,gc);}
		

		
//		for (int i = snake.size() - 1; i >= 1; i--) {
//			snake.get(i).x = snake.get(i - 1).x;
//			snake.get(i).y = snake.get(i - 1).y;
////			obstacle.get(i).x = obstacle.get(i - 1).x;
////			obstacle.get(i).y = obstacle.get(i - 1).y;
//		}
		
		//for (int j=0;j<mega.size();j++) {
			//List<Corner> obstacle2 = mega.get(0);
		for (int i = obstacle.size() - 1; i >= 1; i--) {

			mega.get(0).get(i).setX(mega.get(0).get(i - 1).getX());
			mega.get(0).get(i).setY(mega.get(0).get(i - 1).getY());
			mega.get(1).get(i).setX(mega.get(1).get(i - 1).getX());
			mega.get(1).get(i).setY(mega.get(1).get(i - 1).getY());
			//obstacle.get(i).y = obstacle.get(i - 1).y;
		}
		
		//gravity(ball);
		
//		EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
//		    @Override
//		    public void handle(KeyEvent e) {
//
//		      if(e.getCode() == KeyCode.W) {
//		            //your code for shooting the missile
//		    	  System.out.println("hi");
//		    	  ball.circle.setCenterY(ball.circle.getCenterY()-30);
//		        }
//		        e.consume();
//		    }
//		};
		
		
		
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
//			for (int j=0;j<19;j++) {
//				mega.get(0).get(j).setY(mega.get(0).get(j).getY()+10);
//				mega.get(1).get(j).setY(mega.get(1).get(j).getY()+10);
//			}
			//snake.get(0).y++;
			//snake.get(0).y++;
			//b.y--;
			
			if (snake.get(0).y < 0) {
				//gameOver = true;
			}
			break;
		case down:
			snake.get(0).y++;
			//obstacle.get(0).x--;
			mega.get(0).get(0).setX(mega.get(0).get(0).getX()-30);
			mega.get(1).get(0).setX(mega.get(0).get(0).getX()-30);
			int j=(int)ball.circle.getCenterY();
			j=j+30;
			ball.circle.setCenterY(j);
			//b.y++;
			if (snake.get(0).y > height) {
				//gameOver = true;
			}
			break;
		case left:
			snake.get(0).x=width/2;
//			while (loop) {
//				
//			}
			//obstacle.get(0).x--;
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
			//b.x++;
			
			if (snake.get(0).x < 0) {
				//gameOver = true;
			}
			break;
		case right:
			//snake.get(0).x++;
			//obstacle.get(0).x--;
			if (snake.get(0).x > width) {
				//gameOver = true;
			}
			break;

		}

		// eat food
		// self destroy
		for (int i = 1; i < snake.size(); i++) {
			if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
				gameOver = true;
			}
		}

		// fill
		// background
		gc.setFill(Color.web("061731",1.0));
		gc.fillRect(0, 0, width * cornersize, height * cornersize);

		// score
		gc.setFill(Color.web("F8FDE7",1.0));
		Font f=Font.font("Proxima Nova",FontWeight.BOLD, (double)27);
		gc.setFont(f);
		gc.fillText("Stars: " + 0, 40, 30);

		// random foodcolor
		
		Color cc = Color.WHITE;

//		switch (foodcolor) {
//		case 0:
//			cc = Color.web("#a719b4",1.0);
//			break;
//		case 1:
//			cc = Color.PINK;
//			break;
//		case 2:
//			cc = Color.web("FAD167",1.0);
//			break;
//		case 3:
//			cc = Color.BLUE;
//			break;
//		}
//		gc.setFill(cc);
//		gc.fillOval(x* cornersize, y * cornersize, cornersize, cornersize);

		// snake
		for (Corner c : snake) {
			c.color=1;
			gc.setFill(Color.web("#a719b4",1.0));
			gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
//			gc.setFill(Color.GREEN);
//			gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);

		}
		
		food.color=rand.nextInt(3)+1;
		if (food.color==1) {
			gc.setFill(Color.web("61D8A2",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		if (food.color==2) {
			gc.setFill(Color.web("ED476F",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		if (food.color==3) {
			gc.setFill(Color.web("FAD167",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		if (food.color==4) {
			gc.setFill(Color.web("368BB2",1.0));
			
			gc.fillOval(240, 570, 30 , 30 );
		}
		
		//int i=0;
		//for (int j=0;j<mega.size();j++) {
			//
		//List<Corner> obstacle = mega.get(0);

		if (ball.circle.getCenterY()==710) {
			ball.circle.setFill(Color.PINK);
		for (int i=0;i<mega.get(0).size();i++) {
			if (mega.get(0).get(i).getX()==240) {
				String s1=ball.circle.getFill().toString();
				String s2=mega.get(0).get(i).getFill().toString();
				if (!s1.equals(s2)) {
//					System.out.println(ball.circle.getFill().getClass());
//					System.out.println(mega.get(0).get(i).getFill());
//					ball.circle.setFill(Color.web("61D8A2",1.0));
					gameOver=true;
				}
			}
		}}
		
		if (mega.get(0).get(19).getX()==480) {
			mega.get(1).get(0).setX(510);
		}
		if (mega.get(1).get(19).getX()==480) {
			mega.get(0).get(0).setX(510);
		}
		
		if (ball.circle.getCenterY()==560) {
			ball.color=food.color;
			// 450-x=3y
			//ball.circle.setFill(Color.PINK);
			//Corner c=snake.get(0);
			snake.get(0).y--;
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


