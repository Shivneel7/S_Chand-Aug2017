package derpyBurd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {
	
	public static BufferedImage img;
	private int x;
	private int originalX;
	private int speed;
	
	public Background(int x, int speed) {
		try {
			img = ImageIO.read(getClass().getResource("/original background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void render(Graphics g) {
		if(Math.abs(x) % Game.WIDTH < 3) {
			x = originalX;
		}
		g.drawImage(img, x, 0, null);
	}
}

