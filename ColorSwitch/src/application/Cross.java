package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Cross extends obstacle{
	Line l = new Line();
	Line l2 = new Line();
	Line l3 = new Line();
	Line l4 = new Line();
	Rectangle rectangle4=new Rectangle();
	public Line line1() {
	//l.setStartX(300);
		l.setStartX(350);
	l.setStartY(-320);
	//l.setEndX(250);
		l.setEndX(300);
	l.setEndY(-370);
	l.setStroke(Color.web("ED476F",1.0));
	l.setStrokeWidth(10);
	return l;
	}
	public Line line2() {
		//l2.setStartX(250);
		l2.setStartX(300);
		l2.setStartY(-370);
		//l2.setEndX(300);
		l2.setEndX(350);
		l2.setEndY(-420);
		l2.setStroke(Color.web("FAD167",1.0));
		l2.setStrokeWidth(10);
		return l2;
	}
	public Line line3() {
		//l3.setStartX(250);
		l3.setStartX(300);
		l3.setStartY(-370);
		//l3.setEndX(200);
		l3.setEndX(250);
		l3.setEndY(-410);
		l3.setStroke(Color.web("61D8A2",1.0));
		l3.setStrokeWidth(10);
		return l3;
	}
	public Line line4() {
		//l4.setStartX(200);
		l4.setStartX(250);
		l4.setStartY(-320);
		//l4.setEndX(250);
		l4.setEndX(300);
		l4.setEndY(-370);
		l4.setStroke(Color.web("368BB2",1.0));
		l4.setStrokeWidth(10);
		return l4;
	}

}
