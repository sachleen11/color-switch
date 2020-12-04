package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ball extends dynamicElements{
	int x;
	int y;
	int color=0;
	Circle circle = new Circle();
	public ball(int x, int y) {
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
