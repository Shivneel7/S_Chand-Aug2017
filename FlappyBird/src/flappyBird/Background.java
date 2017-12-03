package flappyBird;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background {
	public Image img;
	
	public Background(Graphics g, int x) {
		ImageIcon i = new ImageIcon("resources\\Background.png");
		img = i.getImage();
		Image img = i.getImage();
		g.drawImage(img, x, 0, null);
	}
	
}

