package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Enemy extends GameObject{
	
	private int width = ENEMY_WIDTH, height = ENEMY_HEIGHT;
	private float gravity = GRAVITY;
	private boolean falling = true;
	private int triggerCounter = 100;
	
	public Enemy(float x, float y, ID id, float dx) {
		super(x, y, id);
		this.dx= dx;

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
				int distance = (int) Math.abs(temp.getX() - x);
				if(distance < 600) {
					triggerCounter++;
					if(triggerCounter > 15 && distance < 150) {
						objects.add(new Bullet(x + width/2 , y + height/2 - 17, ID.EnemyBullet,
								Math.signum((temp.getX() - x)) * BULLET_SPEED, 0));
						triggerCounter = 0;
					}else if(triggerCounter > 50 && distance < 300) {
						objects.add(new Bullet(x + width/2 , y + height/2 - 17, ID.EnemyBullet,
								Math.signum((temp.getX() - x)) * BULLET_SPEED, 0));
						triggerCounter = 0;
					}else if(triggerCounter > 75){
						objects.add(new Bullet(x + width/2 , y + height/2 - 17, ID.EnemyBullet,
								Math.signum((temp.getX() - x)) * BULLET_SPEED, 0));
						triggerCounter = 0;
					}
					
				}
			}
			if(temp.getID() == ID.PlayerBullet) {
				if(checkAllBounds(temp)) {
					objects.remove(temp);
					objects.remove(this);

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
		if(this.getBoundsLeft().intersects(block.getBounds())) {
			x = block.getX() + BLOCK_WIDTH;
			dx*=-1;
		}
		if(this.getBoundsRight().intersects(block.getBounds())) {
			x = block.getX() - width;
			dx*=-1;
		}

	}

	public void render(Graphics g) {
		g.setColor(ENEMY_COLOR);
		g.fillRect((int)x, (int) y, width, height);
		g.setColor(Color.white);
		//if(direction == -1) {
			g.fillRect((int)x + 6, (int) y + 8, 4, 4);
			g.fillRect((int)x + width - 8, (int) y + 8, 4, 4);
			g.drawLine((int) x, (int) y + 20, (int)x + width - 1, (int) y + 20);
//		}else {
//			g.fillRect((int)x + width - 8, (int) y + 8, 4, 4);
//			g.drawLine((int) x + width, (int) y + 20, (int)x + width - 10, (int) y + 20);
		//}
	}
	
	//returns true if the object is touching the given object on any side.
	public boolean checkAllBounds(GameObject temp) {
		if(this.getBounds().intersects(temp.getBounds()) ||
				this.getBoundsTop().intersects(temp.getBounds()) ||
				this.getBoundsRight().intersects(temp.getBounds()) ||
				this.getBoundsLeft().intersects(temp.getBounds())) {
			return true;
		}
		return false;
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
