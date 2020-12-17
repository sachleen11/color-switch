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
	public Line line1() {	//RIGHT
	l.setStartX(345);
	l.setStartY(-950);
	l.setEndX(320);
	l.setEndY(-1052);
	l.setStroke(Color.web("ED476F",1.0));
	l.setStrokeWidth(10);
	return l;
	}
	public Line line2() { //UP
		l2.setStartX(320);
		l2.setStartY(-1052);
		l2.setEndX(150);
		l2.setEndY(-1052);
		l2.setStroke(Color.web("FAD167",1.0));
		l2.setStrokeWidth(10);
		return l2;
	}
	public Line line3() { //LEFT
		l3.setStartX(180);
		l3.setStartY(-950);
		l3.setEndX(150);
		l3.setEndY(-1050);
		l3.setStroke(Color.web("61D8A2",1.0));
		l3.setStrokeWidth(10);
		return l3;
	}
	public Line line4() { //DOWN
		l4.setStartX(180);
		l4.setStartY(-950);
		l4.setEndX(350);
		l4.setEndY(-950);
		l4.setStroke(Color.web("368BB2",1.0));
		l4.setStrokeWidth(10);
		return l4;
	}
}
