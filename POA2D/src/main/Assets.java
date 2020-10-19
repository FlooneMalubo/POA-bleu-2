package main;
import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage car, train, wagon;
	private static final int W = 45, H = 60;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/poa_sprite.png"));
		car = sheet.crop(0, 0, W, H);
		train = sheet.crop(W, 0, W, H);
		wagon = sheet.crop(W*2, 0, W*2, H*2);
	}

}
