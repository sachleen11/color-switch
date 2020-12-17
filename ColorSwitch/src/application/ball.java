package application;

import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class ball extends dynamicElements implements Serializable{
	int x;
	int y;
	int color=0;
	int inpos=550;
	double speed=0;
	transient Circle circle = new Circle();
	public ball(double s) {
		circle.setCenterX(250);
		circle.setCenterY(550
				);
		circle.setRadius(10 );
		circle.setFill(Color.web("ED476F",1.0));
		this.speed=s;
	}

	public Circle cir() {
		
		return circle;
	}
	
	double getspeed() {
		return speed;
	}
	
	void setspeed(double d) {
		this.speed=d;
	}
	
	Paint getcolor() {
		return circle.getFill();
	}
	
	void setColor(Paint p) {
		circle.setFill(p);
	}

	@Override
	int getPosition(Object o) {
		Circle c=(Circle)o;
		return (int)c.getCenterY();
		
	}
}
