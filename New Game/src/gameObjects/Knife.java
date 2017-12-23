package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import framework.BufferedImageLoader;
import framework.SpriteSheet;

public class Knife extends GameObject {
	
	private SpriteSheet ss;
	private BufferedImage img;
	
	public Knife(float x, float y, ID id) {
		super(x, y, id);
		BufferedImageLoader loader = new BufferedImageLoader();
		ss = new SpriteSheet(loader.loadImage("/spriteSheet.png"));
		img = ss.grabImage(2, 1, 16, 16);
		
	}

	public void tick(LinkedList<GameObject> objects) {
		
	}

	public void render(Graphics g) {
		g.drawImage(img, (int) x, (int) y, 48,48, null);
	}

	public Rectangle getBounds() {

		return null;
	}

}
