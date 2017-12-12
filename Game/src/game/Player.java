package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	
	private BufferedImageLoader loader;
	
	private SpriteSheet ss;
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		loader = new BufferedImageLoader();
		 ss = new SpriteSheet(loader.loadImage("/Untitled.png"));
	}

	public void tick() {
		x += dx;
		y += dy;
		
	}

	public void render(Graphics g) {
//		g.setColor(Color.blue);
//		g.fillRect(x, y, 32, 32);
//		g.setColor(Color.white);
//		g.fillRect(x+6, y+6, 4, 4);
//		g.fillRect(x+22, y+6, 4, 4);
		g.drawImage(ss.grabImage(1, 1, 32, 32), x, y, null);
	}
	

}