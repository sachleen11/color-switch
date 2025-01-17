package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Stardeco{

	final String ISHI_STAR = "C:\\Users\\ishik\\Downloads\\starf.png";
	final String SACH_STAR = "/Users/sachleenkaur/Downloads/ASSETS/starf.png";
	final String ISHI_PAUSE = "C:\\Users\\ishik\\Downloads\\pause.png";
	final String SACH_PAUSE = "/Users/sachleenkaur/Downloads/ASSETS/pause.png";


	public ImageView star() throws FileNotFoundException{
	Image image = new Image(new FileInputStream(SACH_STAR));
	ImageView imageView = new ImageView(image);
	imageView.setX(12);
    imageView.setY(9);
    imageView.setFitHeight(25);
    imageView.setFitWidth(25);
    imageView.setPreserveRatio(true);
    return imageView;
	}
	public ImageView pause() throws FileNotFoundException{
		Image image = new Image(new FileInputStream(SACH_PAUSE));
		ImageView imageView = new ImageView(image);
		imageView.setX(400);
		imageView.setY(9);
		imageView.setFitHeight(35);
		imageView.setFitWidth(35);
		imageView.setPreserveRatio(true);
		return imageView;
	}


}