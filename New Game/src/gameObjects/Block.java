package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Block extends GameObject{

	public Block(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> objectList) {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.drawRect((int) x, (int) y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int)y,32,32);
	}
	
}
