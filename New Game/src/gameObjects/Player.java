package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject {
	
	private int width = 32, height = 64;
	private float gravity = .5f;
	private boolean falling, jumping;
	
	public Player(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> objectList) {
		x += dx;
		y += dy;
		if(falling) {
			dy += gravity;
		}
		collision(objectList);
	}

	private void collision(LinkedList<GameObject> objectList) {
		for(GameObject object : objectList) {
			if(object.getID() == ID.Block) {
				if(object.getBounds().intersects(this.getBounds())) {
					y = object.getY() - height;
					dy = 0;
					falling = false;
					jumping = false;
				}else {
					falling = true;
				}
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int) y, width, height);
	}

	public Rectangle getBounds() {
		return new Rectangle( (int) x, (int)y, width, height);
	}
	
	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
