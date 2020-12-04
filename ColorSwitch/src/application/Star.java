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
	imageView.setX(230);
    imageView.setY(300);
    imageView.setFitHeight(50);
    imageView.setFitWidth(100);
    imageView.setPreserveRatio(true);
    return imageView;
	}


}
