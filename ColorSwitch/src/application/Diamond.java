package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Diamond extends obstacle{
	
	Line l = new Line();
	Line l2 = new Line();
	Line l3 = new Line();
	Line l4 = new Line();
	Rectangle rectangle4=new Rectangle();
	public Line line1() {
	l.setStartX(300);
	l.setStartY(-550);
	l.setEndX(270);
	l.setEndY(-602);
	l.setStroke(Color.web("ED476F",1.0));
	l.setStrokeWidth(5);
	return l;
	}
	public Line line2() {
		l2.setStartX(270);
		l2.setStartY(-602);
		l2.setEndX(200);
		l2.setEndY(-602);
		l2.setStroke(Color.web("FAD167",1.0));
		l2.setStrokeWidth(5);
		return l2;
	}
	public Line line3() {
		l3.setStartX(230);
		l3.setStartY(-550);
		l3.setEndX(200);
		l3.setEndY(-600);
		l3.setStroke(Color.web("61D8A2",1.0));
		l3.setStrokeWidth(5);
		return l3;
	}
	public Line line4() {
		l4.setStartX(230);
		l4.setStartY(-550);
		l4.setEndX(300);
		l4.setEndY(-550);
		l4.setStroke(Color.web("368BB2",1.0));
		l4.setStrokeWidth(5);
		return l4;
	}
}
