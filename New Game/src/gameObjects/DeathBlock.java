package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class DeathBlock extends GameObject{

	public DeathBlock(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> objectList) {
		
	}

	public void render(Graphics g) {
		g.setColor(DEATH_BLOCK_COLOR);
		g.fillRect((int) x, (int) y, BLOCK_WIDTH, BLOCK_HEIGHT);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int)y, BLOCK_WIDTH, BLOCK_HEIGHT);
	}
	
}
