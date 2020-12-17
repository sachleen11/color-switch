package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Star extends staticElements{

    final String ISHI_STAR = "C:\\Users\\ishik\\Downloads\\starf.png";
    final String SACH_STAR = "/Users/sachleenkaur/Downloads/ASSETS/starf.png";

	public ImageView star() throws FileNotFoundException{
	Image image = new Image(new FileInputStream(SACH_STAR));
	ImageView imageView = new ImageView(image);
	imageView.setX(235);
    imageView.setY(250);
    imageView.setFitHeight(30);
    imageView.setFitWidth(60);
    imageView.setPreserveRatio(true);
    return imageView;
	}


}
