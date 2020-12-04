package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stardeco{

	public ImageView star() throws FileNotFoundException{
	Image image = new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\starf.png"));
	ImageView imageView = new ImageView(image);
	imageView.setX(12);
    imageView.setY(9);
    imageView.setFitHeight(25);
    imageView.setFitWidth(25);
    imageView.setPreserveRatio(true);
    return imageView;
	}
	public ImageView pause() throws FileNotFoundException{
		Image image = new Image(new FileInputStream("C:\\Users\\ishik\\Downloads\\pause.png"));
		ImageView imageView = new ImageView(image);
		imageView.setX(400);
		imageView.setY(9);
		imageView.setFitHeight(35);
		imageView.setFitWidth(35);
		imageView.setPreserveRatio(true);
		return imageView;
	}


}