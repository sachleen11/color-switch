package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;

public class Quad extends obstacle{
	Arc arc1 = new Arc();
	Arc arc2= new Arc();
	Arc arc3 = new Arc();
	Arc arc4 = new Arc();
	public Arc arc1() {
		arc1.setCenterX(250.0f);
		arc1.setCenterY(-5);
		arc1.setRadiusX(90);
		arc1.setRadiusY(90);
        arc1.setStartAngle(0.0f);
        arc1.setLength(90.0f);
        arc1.setStrokeWidth(10);
		arc1.setStroke(Color.web("ED476F",1.0));
		//arc1.setStroke(Color.web("ED476F",1.0));
		arc1.setFill(Color.web("061731",1.0));
		return arc1;
	}
	public Arc arc2() {
		arc2.setCenterX(250.0f);
		arc2.setCenterY(-5);
		arc2.setRadiusX(90);
		arc2.setRadiusY(90);
		arc2.setStartAngle(90.0f);
		arc2.setLength(90.0f);
		arc2.setStrokeWidth(10);
		arc2.setFill(Color.web("061731",1.0));
		arc2.setStroke(Color.web("61D8A2",1.0));
		//arc2.setStroke(Color.web("ED476F",1.0));
		return arc2;
	}
	public Arc arc3() {
		arc3.setCenterX(250.0f);
		arc3.setCenterY(-5);
		arc3.setRadiusX(90);
		arc3.setRadiusY(90);
		arc3.setStartAngle(180.0f);
		arc3.setLength(90.0f);
		arc3.setStrokeWidth(10);
		arc3.setFill(Color.web("061731",1.0));
		arc3.setStroke(Color.web("FAD167",1.0));
		//arc3.setStroke(Color.web("ED476F",1.0));
		return arc3;
	}
	public Arc arc4() {
		arc4.setCenterX(250.0f);
		arc4.setCenterY(-5);
		arc4.setRadiusX(90);
		arc4.setRadiusY(90);
		arc4.setStartAngle(270.0f);
		arc4.setLength(90.0f);
		arc4.setStrokeWidth(10);
		arc4.setFill(Color.web("061731",1.0));
		arc4.setStroke(Color.web("368BB2",1.0));
		//arc4.setStroke(Color.web("ED476F",1.0));
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
