package application;
	



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class Main extends Application {
	// variable
	
	static int speed = 5;
	static int foodcolor = 0;
	static int width = 20;
	static int height = 20;
	static int foodX = width/2;
	static int foodY = height/3;
	static int x=0;
	static int y=0;
	static int cornersize = 25;
	static List<Corner> snake = new ArrayList<>();
	static Corner food = new Corner(width/2,height/3);
	static List<List<Corner>> mega= new ArrayList<List<Corner>>();
	//static ball b=new ball(x,y);
	static Dir direction = Dir.left;
	static boolean gameOver = false;
	
	
	static Random rand = new Random();
	
	
	public enum Dir {
		left, right, up, down
	}
	
	public static class ball{
		int x;
		int y;
		int color=0;
		Circle circle = new Circle();
		public ball(int x, int y) {
			circle.setCenterX(250); 
			circle.setCenterY(450); 
			circle.setRadius(15 );
			circle.setFill(Color.GREEN);
		}	
		
		public Circle cir() {
			
			
			
			return circle;
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
	
	public static List<Corner> generate(GraphicsContext gc) {
		 List<Corner> obstacle = new ArrayList<>();
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));
		obstacle.add(new Corner(width , height / 2));

		return obstacle;
	}
	
	
	public static void action(List<Corner> obstacle, GraphicsContext gc) {

		for (int i = obstacle.size() - 1; i >= 1; i--) {

			obstacle.get(i).x = obstacle.get(i - 1).x;
			obstacle.get(i).y = obstacle.get(i - 1).y;
		}
		
		switch (direction) {
		case up:
			
			//snake.get(0).y--;
			obstacle.get(0).x--;
			//snake.get(0).y++;
			//snake.get(0).y++;
			//b.y--;
			
			if (snake.get(0).y < 0) {
				//gameOver = true;
			}
			break;
		case down:
			//snake.get(0).y++;
			obstacle.get(0).x--;
			//b.y++;
			if (snake.get(0).y > height) {
				//gameOver = true;
			}
			break;
		case left:
			//snake.get(0).x--;
			obstacle.get(0).x--;
			//b.x++;
			
//			if (snake.get(0).x < 0) {
//				gameOver = true;
//			}
			break;	
		
		}
		

	}


	public void start(Stage primaryStage) {
		try {
			//newFood();
			Circle ball = new Circle(x, Color.DARKSLATEBLUE);
			var root = new Pane();
			//VBox root = new VBox();
			Canvas c = new Canvas(width * cornersize, height * cornersize);
			GraphicsContext gc = c.getGraphicsContext2D();
			ball b=new ball(width/3,height/3);
			//root.getChildren().add(b.cir());
			root.getChildren().add(c);
			
			root.getChildren().add(b.circle);
			List<Corner> obstacle = generate(gc);
			mega.add(obstacle);
			//root.getChildren().add(ball);

			new AnimationTimer() {
				long lastTick = 0;

				public void handle(long now) {
					if (lastTick == 0) {
						lastTick = now;
						tick(gc,obstacle,b);
						return;
					}

					if (now - lastTick > 1000000000 / speed) {
						lastTick = now;
						tick(gc,obstacle,b);
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
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
//			obstacle.add(new Corner(width , height / 2));
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
	public static void tick(GraphicsContext gc,List<Corner> obstacle,ball ball) {
		if (gameOver) {
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 50));
			gc.fillText("GAME OVER", 100, 250);
			return;
		}
		for (int j=0;j<mega.size();j++) {
			List<Corner> obstacle2 = mega.get(j);
			action(obstacle2,gc);}
		

		
//		for (int i = snake.size() - 1; i >= 1; i--) {
//			snake.get(i).x = snake.get(i - 1).x;
//			snake.get(i).y = snake.get(i - 1).y;
////			obstacle.get(i).x = obstacle.get(i - 1).x;
////			obstacle.get(i).y = obstacle.get(i - 1).y;
//		}
		
		//for (int j=0;j<mega.size();j++) {
			//List<Corner> obstacle2 = mega.get(0);
		for (int i = obstacle.size() - 1; i >= 1; i--) {

			obstacle.get(i).x = obstacle.get(i - 1).x;
			obstacle.get(i).y = obstacle.get(i - 1).y;
		}
		

		switch (direction) {
		case up:
			
			//snake.get(0).y--;
			obstacle.get(0).x--;
			int i=(int)ball.circle.getCenterY();
			i=i-30;
			ball.circle.setCenterY(i);
			//snake.get(0).y++;
			//snake.get(0).y++;
			//b.y--;
			
			if (snake.get(0).y < 0) {
				//gameOver = true;
			}
			break;
		case down:
			snake.get(0).y++;
			obstacle.get(0).x--;
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
			obstacle.get(0).x--;
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
//		if (foodX == snake.get(0).x && foodY == snake.get(0).y) {
//			snake.add(new Corner(-1, -1));
//			newFood();
//		}

		// self destroy
		for (int i = 1; i < snake.size(); i++) {
			if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
				gameOver = true;
			}
		}

		// fill
		// background
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width * cornersize, height * cornersize);

		// score
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("", 30));
		gc.fillText("Score: " + (speed - 6), 10, 30);

		// random foodcolor
		Color cc = Color.WHITE;

		switch (foodcolor) {
		case 0:
			cc = Color.GREEN;
			break;
		case 1:
			cc = Color.PINK;
			break;
		case 2:
			cc = Color.YELLOW;
			break;
		case 3:
			cc = Color.BLUE;
			break;
		}
		gc.setFill(cc);
		gc.fillOval(x* cornersize, y * cornersize, cornersize, cornersize);

		// snake
		for (Corner c : snake) {
			c.color=1;
			gc.setFill(Color.GREEN);
			gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
//			gc.setFill(Color.GREEN);
//			gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);

		}
		
		food.color=rand.nextInt(3)+1;
		if (food.color==1) {
			gc.setFill(Color.GREEN);
			
			gc.fillOval(food.x * cornersize, food.y * cornersize, cornersize - 1, cornersize - 1);
		}
		if (food.color==2) {
			gc.setFill(Color.PINK);
			
			gc.fillOval(food.x * cornersize, food.y * cornersize, cornersize - 1, cornersize - 1);
		}
		if (food.color==3) {
			gc.setFill(Color.YELLOW);
			
			gc.fillOval(food.x * cornersize, food.y * cornersize, cornersize - 1, cornersize - 1);
		}
		if (food.color==4) {
			gc.setFill(Color.BLUE);
			
			gc.fillOval(food.x * cornersize, food.y * cornersize, cornersize - 1, cornersize - 1);
		}
		
		//int i=0;
		//for (int j=0;j<mega.size();j++) {
			//
		//List<Corner> obstacle = mega.get(0);
		for (int i=0;i<5;i++) {
			Corner c=obstacle.get(i);
			c.color=2;
			gc.setFill(Color.PINK);
			gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize -1);
		}
		for (int i=5;i<10;i++) {
			Corner c=obstacle.get(i);
			c.color=3;
			gc.setFill(Color.YELLOW);
			gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize -1);
		}
		for (int i=10;i<15;i++) {
			Corner c=obstacle.get(i);
			c.color=4;
			gc.setFill(Color.BLUE);
			gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize -1);
		}
		for (int i=15;i<20;i++) {
			Corner c=obstacle.get(i);
			c.color=1;
			gc.setFill(Color.GREEN);
			gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize -1);
		}
//		for (Corner c : obstacle) {
//			gc.setFill(Color.PINK);
//			gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize -1);
//			
//		}
		//List<Corner> obstacle=mega.get(0);
//		if (obstacle.get(15).x==width) {
//			List<Corner> obstacle2 = generate(gc);
//			obstacle2.get(0).x=width;
//			mega.add(obstacle2);
//			//action(mega,gc);
//			
//		}
		if (ball.circle.getCenterY()==240) {
			//ball.circle.setFill(Color.PINK);
		for (int i=0;i<obstacle.size();i++) {
			if (obstacle.get(i).x==width/2 && obstacle.get(i).y==height/2) {
				if (ball.color!=obstacle.get(i).color) {
					gameOver=true;
				}
			}
		}}
		
		if (ball.circle.getCenterY()==210) {
			ball.color=food.color;
			// 450-x=3y
			//ball.circle.setFill(Color.PINK);
			//Corner c=snake.get(0);
			snake.get(0).y--;
			if (ball.color==1) {
				//Corner c=snake.get(0);
				ball.circle.setFill(Color.GREEN);
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
			if (ball.color==2) {
				ball.circle.setFill(Color.PINK);
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
			if (ball.color==3) {
				ball.circle.setFill(Color.YELLOW);
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
			if (ball.color==4) {
				ball.circle.setFill(Color.BLUE);
				
				//gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
			}
		}
		

	}

	// food
	public static void newFood() {
		
			foodX = width/2;
			foodY = height/3;

//			for (Corner c : snake) {
//				if (c.x == foodX && c.y == foodY) {
//					continue start;
//				}
//			}
			foodcolor = rand.nextInt(3);
			//speed++;
			//break;

		
	}

	public static void main(String[] args) {
		launch(args);
	}
}


