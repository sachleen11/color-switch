package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class Square extends obstacle{
	Rectangle rectangle = new Rectangle();
	Rectangle rectangle2 = new Rectangle();
	Rectangle rectangle3 = new Rectangle();
	Rectangle rectangle4 = new Rectangle();
	public Rectangle square1() {
        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTPINK), new Stop(1, Color.CORAL)};
        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
	      rectangle.setX(300);
	      rectangle.setY(-250);
	      rectangle.setWidth(10);
	      rectangle.setHeight(100);
	      rectangle.setFill(Color.web("ED476F",1.0));


	      Group g=new Group();

	      return rectangle;
	}
	public Rectangle square2() {
        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTGREEN), new Stop(1, Color.FORESTGREEN)};
        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		rectangle2.setX(200);
		rectangle2.setY(-250);
		rectangle2.setWidth(10);
		rectangle2.setHeight(100);
		rectangle2.setFill(Color.web("61D8A2",1.0));


		Group g=new Group();

		return rectangle2;
	}
	public Rectangle square3() {
        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTGOLDENRODYELLOW), new Stop(1, Color.YELLOW)};
        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

		rectangle3.setX(200);
		rectangle3.setY(-250);
		rectangle3.setWidth(100);
		rectangle3.setHeight(10);
		rectangle3.setFill(Color.web("FAD167",1.0));


		//Group g=new Group();

		return rectangle3;
	}
	public Rectangle square4() {
        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.BLUE)};
        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

		rectangle4.setX(200);
		rectangle4.setY(-150);
		rectangle4.setWidth(110);
		rectangle4.setHeight(10);
		rectangle4.setFill(Color.web("368BB2",1.0));

		return rectangle4;
	}
}
