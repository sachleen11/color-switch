package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ColorSwitch extends staticElements{
//	int x;
//	int y;
	int color;
	Circle c=new Circle();
	public ColorSwitch(int x, int y) {
//		this.x = x;
//		this.y = y;
		c.setCenterX(250);
		c.setCenterY(200);
		c.setRadius(10);
		c.setFill(Color.web("368BB2",1.0));
	}
	public Circle cir() {
		return c;
	}
	int getcolor() {
		return color;
	}
	void setcolor(int i) {
		color=i;
	}
	
}
