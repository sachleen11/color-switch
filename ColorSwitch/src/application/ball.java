package application;

import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ball extends dynamicElements implements Serializable{
	int x;
	int y;
	int color=0;
	int inpos=550;
	transient Circle circle = new Circle();
	public ball() {
		circle.setCenterX(250);
		circle.setCenterY(550
				);
		circle.setRadius(15 );
		circle.setFill(Color.web("ED476F",1.0));
	}

	public Circle cir() {
		return circle;
	}
}
