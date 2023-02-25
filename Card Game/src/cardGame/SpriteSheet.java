package cardGame;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteSheet implements Constants {
	BufferedImage ss;
	
	public SpriteSheet() {
		try {
			ss = ImageIO.read(getClass().getResource("/Playing Cards.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage grabCardGraphic(int col, int row, int width, int height, int offset) {
		return ss.getSubimage(col * width - width + offset * (col - 1), row * height - height + offset * (row - 1), width, height);
	}
}
