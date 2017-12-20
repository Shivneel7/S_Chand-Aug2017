package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject {
	
	private int width = 32, height = 64;
	private float gravity = .5f;
	private boolean falling, jumping;
	
	public Player(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> objects) {
		x += dx;
		y += dy;
		if(falling) {
			dy += gravity;
		}
		collision(objects);
	}

	private void collision(LinkedList<GameObject> objects) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);
			if(temp.getID() == ID.Block) {
				if(this.getBounds().intersects(temp.getBounds())) {
					y = temp.getY() - height;
					dy = 0;
					falling = false;
					jumping = false;
				}else {
					falling = true;
				}
				if(this.getBoundsTop().intersects(temp.getBounds())) {
					y = temp.getY() + height/2;
					dy = 0;
				}
				if(this.getBoundsRight().intersects(temp.getBounds())) {
					x = temp.getX() - width;
				}
				if(this.getBoundsLeft().intersects(temp.getBounds())) {
					x = temp.getX() + 32;
				}
			}
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int) y, width, height);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x+8, (int)y + height/2, width-16, height/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int) x+8, (int)y, width-16, height/2);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int)y + 4, width/2 - 10, height - 8);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + width/2 + 10, (int)y + 4, width/2 - 10, height - 8);
	}
	
	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
}
