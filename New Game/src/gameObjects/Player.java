package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject {
	
	private int width = 32, height = 64;
	public Player(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> object) {
		x += dx;
		y += dy;
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int) y, width, height);
	}

	public Rectangle getBounds() {
		return new Rectangle( (int) x, (int)y, width, height);
	}

}
