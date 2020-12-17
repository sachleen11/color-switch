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

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {

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
	private static final String filepath="C:\\Users\\ishik\\OneDrive\\Desktop\\obj.txt";
	
	
    void startGame() throws IOException {
		//FILE REFRESH
		
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
		
		
		
		FileOutputStream fi = new FileOutputStream(new File(SACH_filepath));
        ObjectOutputStream oi = new ObjectOutputStream(fi);
       
        oi.writeObject(balls);
        oi.close();
         
        fi.close();
        
        
        FileOutputStream fiq = new FileOutputStream(new File(SACH_quads_filepath));
        ObjectOutputStream oiq = new ObjectOutputStream(fiq);
        
        oiq.writeObject(quads);
        oiq.close();
         
        fiq.close();
        
        
        FileOutputStream fid = new FileOutputStream(new File(SACH_diamonds_filepath));
        ObjectOutputStream oid = new ObjectOutputStream(fid);
        
        oid.writeObject(diamonds);
        oid.close();
         
        fid.close();
        
        
        FileOutputStream fic = new FileOutputStream(new File(SACH_crosses_filepath));
        ObjectOutputStream oic = new ObjectOutputStream(fic);
        
        oic.writeObject(crosses);
        oic.close();
         
        fic.close();
        
        
        FileOutputStream fil = new FileOutputStream(new File(SACH_lines_filepath));
        ObjectOutputStream oil = new ObjectOutputStream(fil);
        
        oil.writeObject(lines);
        oil.close();
         
        fil.close();
        
        
        FileOutputStream fis = new FileOutputStream(new File(SACH_squares_filepath));
        ObjectOutputStream ois = new ObjectOutputStream(fis);
        
        ois.writeObject(squares);
        ois.close();
         
        fis.close();
        
        
        FileOutputStream fist = new FileOutputStream(new File(SACH_stars_filepath));
        ObjectOutputStream oist = new ObjectOutputStream(fist);
        
        oist.writeObject(starsl);
        oist.close();
         
        fist.close();
        
        
        FileOutputStream fics = new FileOutputStream(new File(SACH_colorswitches_filepath));
        ObjectOutputStream oics = new ObjectOutputStream(fics);
        
        oics.writeObject(colorswitches);
        oics.close();
         
        fics.close();
		
		
        FileOutputStream fiTP = new FileOutputStream(new File(SACH_totalpoints_filepath));
        ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
        
        oiTP.writeObject(TOTALPOINTS);
        oiTP.close();
         
        fiTP.close();
		
        FileOutputStream fiSP = new FileOutputStream(new File(SACH_sessionpoints_filepath));
        ObjectOutputStream oiSP = new ObjectOutputStream(fiSP);
        
        oiSP.writeObject(SESHPOINTS);
        oiSP.close();
         
        fiSP.close();

    }
    
    
    void save(List<List<Rectangle>> mega,GraphicsContext gc,List<Rectangle> obstacle,ball ball,Quad q,Button Start,Stage primaryStage, ArrayList<ImageView> starlist,ArrayList<ColorSwitch> cslist,Square sq,Cross cr,Diamond d,Scene scene2,ArrayList<Object> comp, Scene scene,int stars) {
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
            FileInputStream fileOut = new FileInputStream(SACH_filepath);
            ObjectInputStream objectOut = new ObjectInputStream(fileOut);
            balls= (ArrayList<Integer>)objectOut.readObject();
            balls.add((int)ball.circle.getCenterY());
            
            
            System.out.println("The ball  was succesfully read to a file");
            fileOut.close();
            objectOut.close();
            
            FileInputStream fq = new FileInputStream(SACH_quads_filepath);
            ObjectInputStream oq = new ObjectInputStream(fq);
            quads= (ArrayList<Integer>)oq.readObject();
            quads.add((int)q.arc1.getCenterY());
            
            oq.close();
            System.out.println("The quad  was succesfully read to a file");
            fq.close();
            
            FileInputStream fDIA = new FileInputStream(SACH_diamonds_filepath);
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
            
            FileInputStream fCROSS = new FileInputStream(SACH_crosses_filepath);
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
            
            FileInputStream fLINES = new FileInputStream(SACH_lines_filepath);
            ObjectInputStream oLINES = new ObjectInputStream(fLINES);
            lines= (ArrayList<Integer>)oLINES.readObject();
            lines.add((int)mega.get(0).get(0).getY());
            
            oLINES.close();
            System.out.println("The LINES  was succesfully read to a file");
            fLINES.close();
            
            FileInputStream fSQUARES = new FileInputStream(SACH_squares_filepath);
            ObjectInputStream oSQUARES = new ObjectInputStream(fSQUARES);
            squares= (ArrayList<Integer>)oSQUARES.readObject();
            squares.add((int)sq.rectangle4.getY());
            
            oSQUARES.close();
            System.out.println("The SQUARES  was succesfully read to a file");
            fSQUARES.close();
            
            FileInputStream fSTAR = new FileInputStream(SACH_stars_filepath);
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
            
            FileInputStream fCS = new FileInputStream(SACH_colorswitches_filepath);
            ObjectInputStream oCS = new ObjectInputStream(fCS);
            colorswitches= (ArrayList<ArrayList<Integer>>)oCS.readObject();
            ArrayList<Integer> a4=new ArrayList<>();
            colorswitches.add(a4);
            for (int i=0;i<starlist.size();i++) {
            colorswitches.get(colorswitches.size()-1).add((int)cslist.get(i).c.getCenterY());
            
            }
            
            
            oCS.close();
            System.out.println("The quad  was succesfully read to a file");
            fCS.close();
            
            FileInputStream fSP = new FileInputStream(SACH_sessionpoints_filepath);
            ObjectInputStream oSP = new ObjectInputStream(fSP);
            SESHPOINTS= (ArrayList<Integer>)oSP.readObject();
            SESHPOINTS.add(stars);
            
            oSP.close();
            System.out.println("The STARS  was succesfully read to a file");
            fSP.close();
            
            
            
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		//int TOTALPOINTS=stars;
		//ArrayList<Integer> SESHPOINTS=new ArrayList<>();
		int prev=0;
        FileOutputStream fiTP;
		try {
			
			
            FileInputStream fSP = new FileInputStream(SACH_totalpoints_filepath);
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
            
            
			fiTP = new FileOutputStream(new File(SACH_totalpoints_filepath));
            ObjectOutputStream oiTP = new ObjectOutputStream(fiTP);
            
            oiTP.writeObject(SESHPOINTS);
            oiTP.close();
             
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
		
		
		
		try {
			 
			FileOutputStream fi = new FileOutputStream(new File(SACH_filepath));
            ObjectOutputStream oi = new ObjectOutputStream(fi);
           
            oi.writeObject(balls);
            oi.close();
            fi.close();
            
            
            FileOutputStream fiq = new FileOutputStream(new File(SACH_quads_filepath));
            ObjectOutputStream oiq = new ObjectOutputStream(fiq);
            
            oiq.writeObject(quads);
            oiq.close();
            fiq.close();
            
            
            FileOutputStream fid = new FileOutputStream(new File(SACH_diamonds_filepath));
            ObjectOutputStream oid = new ObjectOutputStream(fid);
            
            oid.writeObject(diamonds);
            oid.close();
            fid.close();
            
            
            FileOutputStream fic = new FileOutputStream(new File(SACH_crosses_filepath));
            ObjectOutputStream oic = new ObjectOutputStream(fic);
            
            oic.writeObject(crosses);
            oic.close();
  fic.close();
            
            
            FileOutputStream fil = new FileOutputStream(new File(SACH_lines_filepath));
            ObjectOutputStream oil = new ObjectOutputStream(fil);
            
            oil.writeObject(lines);
            oil.close();
  fil.close();
            
            
            FileOutputStream fis = new FileOutputStream(new File(SACH_squares_filepath));
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            
            ois.writeObject(squares);
            ois.close();
  fis.close();
            
            
            FileOutputStream fist = new FileOutputStream(new File(SACH_stars_filepath));
            ObjectOutputStream oist = new ObjectOutputStream(fist);
            
            oist.writeObject(starsl);
            oist.close();
  fist.close();
            
            
            FileOutputStream fics = new FileOutputStream(new File(SACH_colorswitches_filepath));
            ObjectOutputStream oics = new ObjectOutputStream(fics);
            
            oics.writeObject(colorswitches);
            oics.close();
  fics.close();
			
			
            FileOutputStream fiP = new FileOutputStream(new File(SACH_totalpoints_filepath));
            ObjectOutputStream oiTP = new ObjectOutputStream(fiP);
            
            oiTP.writeObject(TOTALPOINTS);
            oiTP.close();
  fiP.close();
			
            FileOutputStream fiSP = new FileOutputStream(new File(SACH_sessionpoints_filepath));
            ObjectOutputStream oiSP = new ObjectOutputStream(fiSP);
            
            oiSP.writeObject(SESHPOINTS);
            oiSP.close();
  fiSP.close();		            
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
    }
    
    protected void SetUp(Pane mainPage,Scene scene2, Stage primaryStage) throws Exception{
    	//int mode=0;
    	Space sm=new Space();
        Button Start = new Button("START GAME");
        Start.setOnAction(event ->  primaryStage.setScene(scene2));
//        Start.setOnAction(new EventHandler() {
//
//			@Override
//			public void handle(Event arg0) {
//				// TODO Auto-generated method stub
//				
//				try {
//					sm.makescene2(0, primaryStage);
//				} catch (ClassNotFoundException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//			}});
        Start.setId("shiny-orange");
        Start.setMaxWidth(150);

        Button Exit = new Button("EXIT GAME");

        Exit.setOnAction(event -> Platform.exit());
        
        Exit.setId("shiny-orange");
        Exit.setMaxWidth(150);

        Button Load = new Button("LOAD GAME");
        Load.setOnAction(event ->  primaryStage.setScene(scene2));
//        Load.setOnAction(new EventHandler() {
//
//			@Override
//			public void handle(Event arg0) {
//				// TODO Auto-generated method stub
//				
//				try {
//					sm.makescene2(0, primaryStage);
//				} catch (ClassNotFoundException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//			}
        


				
				
			
//        });
        Load.setId("shiny-orange");
        Load.setMaxWidth(150);


        FileInputStream input = new FileInputStream(SACH_STAR);
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

        mainPage.getChildren().addAll(vbox,imageView,t,t2);
    }
    
    
    
    void exit() {
    	System.exit(0);
    }
}
