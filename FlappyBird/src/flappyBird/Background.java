package flappyBird;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background {
	public Image img;
	private int x;
	private int originalX;
	private int speed;
	
	public Background(int x, int speed) {
		ImageIcon i = new ImageIcon("resources\\Background.png");
		img = i.getImage();
		Image img = i.getImage();
		this.x = x;
		originalX =x;
		this.speed = speed;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void tick() {
		x -= speed;
	}
	
	public void render(Graphics g) {
		if(x % 600 == 0) {
			x = originalX;
		}
		g.drawImage(img, x, 0, null);
	}
}

