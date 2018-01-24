package cardGame;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteSheet implements Constants {
	BufferedImage ss;
	
	public SpriteSheet() {
		try {
			ss = ImageIO.read(getClass().getResource("/cards.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage grabCardGraphic(int col, int row, int width, int height) {
		return ss.getSubimage(col * width - width, row * height - height, width, height);
	}
}
