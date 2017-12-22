package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Enemy extends GameObject{
	
	private int width = ENEMY_WIDTH, height = ENEMY_HEIGHT;
	private float gravity = GRAVITY;
	private boolean falling = true;
	private int triggerCounter = 100;
	
	public Enemy(float x, float y, ID id) {
		super(x, y, id);
	}

	public void tick(LinkedList<GameObject> objects) {
		x += dx;
		y += dy;
		if(falling ) {
			dy += gravity;
		}
		for(int i = 0; i < objects.size(); i++) {//collision
			GameObject temp = objects.get(i);
			if(temp.getID() == ID.Block || temp.getID() == ID.DeathBlock || temp.getID() == ID.TransparentBlock) {
				normalBlockCollision(temp);
			}
			if(temp.getID() == ID.Player) {
				if(Math.abs(temp.getX() - x) < 1000) {
					triggerCounter++;
					if(triggerCounter > 100 && Math.abs(temp.getX() - x) < 1000) {
						objects.add(new Bullet(x, y + 10, ID.Bullet, Math.signum((temp.getX() - x)) * 4 , 0));
						triggerCounter = 0;
					}
				}
			}
		}
	}

	private void normalBlockCollision(GameObject block) {
		if(this.getBounds().intersects(block.getBounds())) {
			y = block.getY() - height;
			dy = 0;
			falling = false;
		}else {
			falling = true;
		}
		if(this.getBoundsTop().intersects(block.getBounds())) {
			y = block.getY() + height/2;
			dy = 0;
		}
		if(this.getBoundsLeft().intersects(block.getBounds())) {
			x = block.getX() + BLOCK_WIDTH;
		}
		if(this.getBoundsRight().intersects(block.getBounds())) {
			x = block.getX() - width;
		}

	}

	public void render(Graphics g) {
		g.setColor(ENEMY_COLOR);
		g.fillRect((int)x, (int) y, width, height);
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
}
