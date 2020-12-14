package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import application.Main.Dir;
import application.Main.space;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Space {
	final String ISHI_SCREEN = "C:\\Users\\ishik\\Downloads\\color_screen.png";
	final String SACH_SCREEN = "/Users/sachleenkaur/Downloads/ASSETS/color_screen.png";
	final String ISHI_STAR = "C:\\Users\\ishik\\Downloads\\starf.png";
	final String SACH_STAR = "/Users/sachleenkaur/Downloads/ASSETS/starf.png";
	private static final String filepath="C:\\Users\\ishik\\OneDrive\\Desktop\\obj.txt";
	ArrayList<Object> components=new ArrayList<>();
	//static int mode=0;
	static float speed = 5;
	static int width = 20;
	static int height = 35;
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
	static int s1=0;
	static int s2=0;
	static int s3=0;
	static int s4=0;
	static int s5=0;
	
	
	
	public void tick(List<List<Rectangle>> mega,GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q,Button Start,Stage primaryStage, ArrayList<ImageView> starlist,ColorSwitch cs,Square sq,Cross cr,Diamond d,Scene scene2,ArrayList<Object> comp, int univstar) throws FileNotFoundException {
		//speed++;
   		Pane rt = new Pane();
   		
        Button Exit = new Button("EXIT GAME");
        Exit.setMaxWidth(200);
        Exit.setLayoutX(205);
        Exit.setLayoutY(600);
        Exit.setStyle("-fx-background-color:#f1faee;-fx-text-fill: #061731 ;-fx-font-family:'Open Sans', sans-serif;-fx-font-weight: bold;-fx-font-size: 17px;");
        Exit.setOnAction(event -> Platform.exit());
        rt.getChildren().add(Exit);

        Button E = new Button("SAVE & EXIT GAME");
        E.setMaxWidth(200);
        E.setLayoutX(70);
        E.setLayoutY(500);
        //E.setOnAction(event -> Platform.exit());
       E.setOnAction(new EventHandler() {


			@Override
			public void handle(Event arg0) {
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
		            FileInputStream fileOut = new FileInputStream(filepath);
		            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
		            balls= (ArrayList<Integer>)objectOut.readObject();
		            balls.add((int)ball.circle.getCenterY());
		            
		            
		            System.out.println("The ball  was succesfully read to a file");
		            fileOut.close();
		            objectOut.close();
		            
		            FileInputStream fq = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\quads.txt");
		            ObjectInputStream oq = new ObjectInputStream(fq);
		            quads= (ArrayList<Integer>)oq.readObject();
		            quads.add((int)q.arc1.getCenterY());
		            
		            oq.close();
		            System.out.println("The quad  was succesfully read to a file");
		            fq.close();
		            
		            FileInputStream fDIA = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\diamonds.txt");
		            ObjectInputStream oDIA = new ObjectInputStream(fDIA);
		            diamonds= (ArrayList<ArrayList<Integer>>)oDIA.readObject();
		            ArrayList<Integer> a2=new ArrayList<>();
		            diamonds.add(a2);
		            diamonds.get(diamonds.size()-1).add((int)d.l.getStartX());
		            diamonds.get(diamonds.size()-1).add((int)d.l.getStartY());
		            diamonds.get(diamonds.size()-1).add((int)d.l.getEndX());
		            diamonds.get(diamonds.size()-1).add((int)d.l.getEndY());
		            
		            diamonds.get(diamonds.size()-1).add((int)d.l2.getStartX());
		            diamonds.get(diamonds.size()-1).add((int)d.l2.getStartY());
		            diamonds.get(diamonds.size()-1).add((int)d.l2.getEndX());
		            diamonds.get(diamonds.size()-1).add((int)d.l2.getEndY());
		            
		            diamonds.get(diamonds.size()-1).add((int)d.l3.getStartX());
		            diamonds.get(diamonds.size()-1).add((int)d.l3.getStartY());
		            diamonds.get(diamonds.size()-1).add((int)d.l3.getEndX());
		            diamonds.get(diamonds.size()-1).add((int)d.l3.getEndY());
		            
		            diamonds.get(diamonds.size()-1).add((int)d.l4.getStartX());
		            diamonds.get(diamonds.size()-1).add((int)d.l4.getStartY());
		            diamonds.get(diamonds.size()-1).add((int)d.l4.getEndX());
		            diamonds.get(diamonds.size()-1).add((int)d.l4.getEndY());
		            
		            oDIA.close();
		            System.out.println("The DIA  was succesfully read to a file");
		            fDIA.close();
		            
		            FileInputStream fCROSS = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\crosses.txt");
		            ObjectInputStream oCROSS = new ObjectInputStream(fCROSS);
		            crosses= (ArrayList<ArrayList<Integer>>)oCROSS.readObject();
		            ArrayList<Integer> a1=new ArrayList<>();
		            crosses.add(a1);
		            crosses.get(crosses.size()-1).add((int)cr.l.getStartX());
		            crosses.get(crosses.size()-1).add((int)cr.l.getStartY());
		            crosses.get(crosses.size()-1).add((int)cr.l.getEndX());
		            crosses.get(crosses.size()-1).add((int)cr.l.getEndY());
		            
		            crosses.get(crosses.size()-1).add((int)cr.l2.getStartX());
		            crosses.get(crosses.size()-1).add((int)cr.l2.getStartY());
		            crosses.get(crosses.size()-1).add((int)cr.l2.getEndX());
		            crosses.get(crosses.size()-1).add((int)cr.l2.getEndY());
		            
		            crosses.get(crosses.size()-1).add((int)cr.l3.getStartX());
		            crosses.get(crosses.size()-1).add((int)cr.l3.getStartY());
		            crosses.get(crosses.size()-1).add((int)cr.l3.getEndX());
		            crosses.get(crosses.size()-1).add((int)cr.l3.getEndY());
		            
		            crosses.get(crosses.size()-1).add((int)cr.l4.getStartX());
		            crosses.get(crosses.size()-1).add((int)cr.l4.getStartY());
		            crosses.get(crosses.size()-1).add((int)cr.l4.getEndX());
		            crosses.get(crosses.size()-1).add((int)cr.l4.getEndY());
		            
		            
		            oCROSS.close();
		            System.out.println("The cross  was succesfully read to a file");
		            fCROSS.close();
		            
		            FileInputStream fLINES = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\lines.txt");
		            ObjectInputStream oLINES = new ObjectInputStream(fLINES);
		            lines= (ArrayList<Integer>)oLINES.readObject();
		            lines.add((int)mega.get(0).get(0).getY());
		            
		            oLINES.close();
		            System.out.println("The LINES  was succesfully read to a file");
		            fLINES.close();
		            
		            FileInputStream fSQUARES = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\squares.txt");
		            ObjectInputStream oSQUARES = new ObjectInputStream(fSQUARES);
		            squares= (ArrayList<Integer>)oSQUARES.readObject();
		            squares.add((int)sq.rectangle4.getY());
		            
		            oSQUARES.close();
		            System.out.println("The SQUARES  was succesfully read to a file");
		            fSQUARES.close();
		            
		            FileInputStream fSTAR = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\stars.txt");
		            ObjectInputStream oSTAR = new ObjectInputStream(fSTAR);
		            starsl= (ArrayList<ArrayList<Integer>>)oSTAR.readObject();
		            ArrayList<Integer> a3=new ArrayList<>();
		            starsl.add(a3);
		            for (int i=0;i<starlist.size();i++) {
		            starsl.get(starsl.size()-1).add((int)starlist.get(i).getY());
		            
		            }
		            oSTAR.close();
		            System.out.println("The STAR  was succesfully read to a file");
		            fSTAR.close();
		            
		            FileInputStream fCS = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\colorswitches.txt");
		            ObjectInputStream oCS = new ObjectInputStream(fCS);
		            colorswitches= (ArrayList<ArrayList<Integer>>)oCS.readObject();
		            ArrayList<Integer> a4=new ArrayList<>();
		            colorswitches.add(a4);
		            colorswitches.get(colorswitches.size()-1).add((int)cs.c.getCenterY());
		            
		            oCS.close();
		            System.out.println("The quad  was succesfully read to a file");
		            fCS.close();
		            
		            FileInputStream fSP = new FileInputStream("C:\\Users\\ishik\\OneDrive\\Desktop\\sessionpoints.txt");
		            ObjectInputStream oSP = new ObjectInputStream(fSP);
		            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
		            SESHPOINTS.add(stars);
		            
		            oSP.close();
		            System.out.println("The STARS  was succesfully read to a file");
		            fSP.close();
		            
		 
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
				
				try {
					 
					FileOutputStream fi = new FileOutputStream(new File(filepath));
		            ObjectOutputStream oi = new ObjectOutputStream(fi);
		           
		            oi.writeObject(balls);
		            oi.close();
		            System.out.println("write done");
		            fi.close();
		            
		            
		            FileOutputStream fiq = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\quads.txt"));
		            ObjectOutputStream oiq = new ObjectOutputStream(fiq);
		            
		            oiq.writeObject(quads);
		            oiq.close();
		            System.out.println("write done");
		            fiq.close();
		            
		            
		            FileOutputStream fid = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\diamonds.txt"));
		            ObjectOutputStream oid = new ObjectOutputStream(fid);
		            
		            oid.writeObject(diamonds);
		            oid.close();
		            System.out.println("write done");
		            fid.close();
		            
		            
		            FileOutputStream fic = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\crosses.txt"));
		            ObjectOutputStream oic = new ObjectOutputStream(fic);
		            
		            oic.writeObject(crosses);
		            oic.close();
		            System.out.println("write done");
		            fic.close();
		            
		            
		            FileOutputStream fil = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\lines.txt"));
		            ObjectOutputStream oil = new ObjectOutputStream(fil);
		            
		            oil.writeObject(lines);
		            oil.close();
		            System.out.println("write done");
		            fil.close();
		            
		            
		            FileOutputStream fis = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\squares.txt"));
		            ObjectOutputStream ois = new ObjectOutputStream(fis);
		            
		            ois.writeObject(squares);
		            ois.close();
		            System.out.println("write done");
		            fis.close();
		            
		            
		            FileOutputStream fist = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\stars.txt"));
		            ObjectOutputStream oist = new ObjectOutputStream(fist);
		            
		            oist.writeObject(stars);
		            oist.close();
		            System.out.println("write done");
		            fist.close();
		            
		            
		            FileOutputStream fics = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\colorswitches.txt"));
		            ObjectOutputStream oics = new ObjectOutputStream(fics);
		            
		            oics.writeObject(colorswitches);
		            oics.close();
		            System.out.println("write done");
		            fics.close();
					
					
		            FileOutputStream fiTP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\totalpoints.txt"));
		            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
		            
		            oiTP.writeObject(TOTALPOINTS);
		            oiTP.close();
		            System.out.println("write done");
		            fiTP.close();
					
		            FileOutputStream fiSP = new FileOutputStream(new File("C:\\Users\\ishik\\OneDrive\\Desktop\\sessionpoints.txt"));
		            ObjectOutputStream oiSP = new ObjectOutputStream(fiSP);
		            
		            oiSP.writeObject(SESHPOINTS);
		            oiSP.close();
		            System.out.println("write done");
		            fiSP.close();		            
		 
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }


	          //  objectOut.close();
//				comp.add(gc);
//				comp.add(mega.get(0));
//				comp.add(mega.get(1));
//				comp.add(ball);
//				comp.add(q);
//				comp.add(starlist);
//				comp.add(cs);
//				comp.add(sq);
//				comp.add(cr);
//				comp.add(d);
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
//		for (int i=0;i<mega.get(0).size();i++) {
//			mega.get(1).get(0).setY(mega.get(1).get(0).getY()+1);
//			mega.get(0).get(0).setY(mega.get(0).get(0).getY()+1);
//		}

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
	    			
	    			if (cr.l.getStartX()!=cr.l.getEndX()) {
	    				cr.l.setStartX(cr.l.getEndX());
	    				cr.l.setStartY(cr.l.getStartY()+15);
	    				help_rotate = 0;
	    			}
	    			else {
	    				cr.l.setStartX(300);
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
						cr.l3.setEndX(200);
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
						cr.l.setStroke(temp2);
						cr.l2.setStroke(temp3);
						cr.l3.setStroke(temp4);
						cr.l4.setStroke(temp1);
					}
					
					if(d.l.getStartX()!= d.l.getEndX()){
						d.l.setStartX(d.l.getEndX());
						d.l.setEndY(d.l.getEndY()-20);
						d.l.setStartY(d.l.getStartY()-20);
					}
					else{
						d.l.setStartX(300);
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
						d.l3.setStartX(230);
					}
					if(d.l4.getEndY()!=d.l4.getStartY()-20){
						d.l4.setEndY(d.l4.getStartY()-20);
						d.l4.setStartX(200);
						d.l4.setEndX(d.l4.getEndX()-30);
					}
					else{
						d.l4.setEndY(d.l4.getStartY());
						d.l4.setStartX(230);
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
//				Color temp1 = (Color)sq.square1().getFill();
//				Color temp2 = (Color)sq.square2().getFill();
//				Color temp3 = (Color)sq.square3().getFill();
//				Color temp4 = (Color)sq.square4().getFill();
//
//				sq.square1().setFill(temp2);
//				sq.square2().setFill(temp3);
//				sq.square3().setFill(temp4);
//				sq.square4().setFill(temp1);

		gc.setFill(Color.web("061731",1.0));
		gc.fillRect(0, 0, width * cornersize, height * cornersize);

		gc.setFill(Color.web("F8FDE7",1.0));
		Font f=Font.font("Proxima Nova",FontWeight.BOLD, (double)27);
		gc.setFont(f);
		gc.fillText(" " + stars, 40, 30);

		Color cc = Color.WHITE;

//COLORSWITCH
//		sq.square1().setFill(sq.square2().getFill());
//		sq.square2().setFill(sq.square3().getFill());
//		sq.square3().setFill(sq.square4().getFill());
//		sq.square4().setFill(sq.square1().getFill());
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
//		primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
//			if (key.getCode() == KeyCode.Z) {
//
//
//				 ball.circle.setCenterY(ball.cir().getCenterY()-3);
//
//			}
//
//
//		});
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
//	    			sq.rectangle2.setY(sq.rectangle2.getY()+2);
//	    			sq.rectangle3.setY(sq.rectangle3.getY()+2);
//	    			sq.rectangle4.setY(sq.rectangle4.getY()+2);


	    			
                }

            }
        });
        
       // ball.circle.setCenterY(position);
        //mega.get(0).get(1).getY()>400
        if (ball.circle.getCenterY()<550) {
        	//System.out.println("ji");
        	
//            if (ball.cir().getCenterY()<400) {
//            	//System.out.println("ji");
//        		for (int i = obstacle.size() - 1; i >= 0; i--) {
//
//        			mega.get(0).get(i).setY(mega.get(0).get(i).getY()+1);
//        			mega.get(1).get(i).setY(mega.get(1).get(i).getY()+1);
//        		}
//            	//ball.circle.setCenterY(ball.cir().getCenterY()+3);
//            }
            
//            else {
           	ball.circle.setCenterY(ball.cir().getCenterY()+3);
//            }
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
//		for (int i=0;i<5;i++) {
//			ImageView iv=starlist.get(i);
//    		if (iv.getY()-ball.circle.getCenterY()<30 && iv.getY()-ball.circle.getCenterY()>0 ) {
//    			
//    			stars++;
//    		}
//			
//		}
		
		ImageView v=starlist.get(0);
		if (v.getY()-ball.circle.getCenterY()>0 && s1<session) {
			s1++;
			stars++;
		}
		ImageView v2=starlist.get(1);
		if (v2.getY()-ball.circle.getCenterY()>0 && s2<session) {
			s2++;
			stars++;
		}
		ImageView v3=starlist.get(2);
		if (v3.getY()-ball.circle.getCenterY()>0 && s3<session) {
			s3++;
			stars++;
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
//		if (d.l2.getStartY()>0 && d.l2.getStartY()<100) 
		if(mega.get(0).get(0).getY()>580 ){
			session++;
			System.out.println(session);
			//ball.circle.setFill(Color.AQUA);
			//primaryStage.setScene(scene2);
    		for (int i = obstacle.size() - 1; i >= 0; i--) {

    			mega.get(0).get(i).setY(d.l2.getStartY()-150);
    			mega.get(1).get(i).setY(d.l2.getStartY()-150);
    		}}
		
		
			ImageView iv1=starlist.get(0);
    		if(iv1.getY()>ball.circle.getCenterY() && mega.get(0).get(0).getY()<0){
    			//ball.circle.setFill(Color.AQUA);
    			//primaryStage.setScene(scene2);
    			iv1.setY(mega.get(0).get(0).getY()-150);
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
		if(d.l4.getStartY()>580 && d.l.getStartY()>580 && d.l2.getStartY()>580 && d.l3.getStartY()>580 &&
				d.l4.getEndY()>580 && d.l.getEndY()>580 && d.l2.getEndY()>580 && d.l3.getEndY()>580){
			//ball.circle.setFill(Color.AQUA);
			speed=speed-(float)speed/5;
			
			//primaryStage.setScene(scene2);
			d.l.setStartY(starlist.get(3).getY()-150);
			d.l.setEndY(starlist.get(3).getY()-200);
			d.l.setStartX(300);
			d.l.setEndX(270);
			d.l2.setStartY(starlist.get(3).getY()-200);
			d.l2.setEndY(starlist.get(3).getY()-200);
			d.l2.setStartX(270);
			d.l2.setEndX(200);
			
			d.l3.setStartY(starlist.get(3).getY()-150);
			d.l3.setEndY(starlist.get(3).getY()-200);
			d.l3.setStartX(230);
			d.l3.setEndX(200);
			
			d.l4.setStartY(starlist.get(3).getY()-150);
			d.l4.setEndY(starlist.get(3).getY()-150);
			d.l4.setStartX(230);
			d.l4.setEndX(300);
}
		
		
		if(cr.l4.getStartY()>580 && cr.l.getStartY()>580 && cr.l2.getStartY()>580 && cr.l3.getStartY()>580 &&
				cr.l4.getEndY()>580 && cr.l.getEndY()>580 && cr.l2.getEndY()>580 && cr.l3.getEndY()>580){
			//ball.circle.setFill(Color.AQUA);
			speed=speed-(float)speed/5;
			//primaryStage.setScene(scene2);
			cr.l.setStartY(sq.rectangle3.getY()-70);
			cr.l.setEndY(sq.rectangle3.getY()-120);
			
			cr.l.setStartX(300);
			cr.l.setEndX(250);
			cr.l2.setStartY(sq.rectangle3.getY()-120);
			cr.l2.setEndY(sq.rectangle3.getY()-170);
			cr.l2.setStartX(250);
			cr.l2.setEndX(300);
			cr.l3.setStartY(sq.rectangle3.getY()-120);
			cr.l3.setEndY(sq.rectangle3.getY()-160);
			cr.l3.setStartX(250);
			cr.l3.setEndX(200);
			cr.l4.setStartY(sq.rectangle3.getY()-70);
			cr.l4.setEndY(sq.rectangle3.getY()-120);
			cr.l4.setStartX(200);
			cr.l4.setEndX(250);
		}
		
		
		if(sq.rectangle3.getY()>580 && sq.rectangle.getY()>580 && sq.rectangle2.getY()>580 && sq.rectangle4.getY()>580){
			//ball.circle.setFill(Color.AQUA);
			//primaryStage.setScene(scene2);
			sq.rectangle4.setY(q.arc1.getCenterY()-200);
			sq.rectangle.setY(q.arc1.getCenterY()-300);
			sq.rectangle2.setY(q.arc1.getCenterY()-300);
			sq.rectangle3.setY(q.arc1.getCenterY()-300);
//			d.l.setEndY(-450);
//			d.l2.setStartY(-450);
//			d.l2.setEndY(-450);
//			
//			d.l3.setStartY(-400);
//			d.l3.setEndY(-450);
//			d.l4.setStartY(-400);
//			d.l4.setEndY(-400);
//			q.arc2.setCenterY(-400);
//			q.arc3.setCenterY(-400);
//			q.arc4.setCenterY(-400);
		}
if (gameOver) {
			univstar=+stars;
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
	
}