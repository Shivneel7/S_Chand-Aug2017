package enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import framework.Game;
import gameObjects.GameObject;
import gameObjects.ID;
import gameObjects.Knife;
import gameObjects.Upgrade;
import userInterface.HUD;
/**
 * @see Enemy
 * Jumps around
 * @author Shivneel Chand
 *
 */
public class Jumper extends GameObject{

	private int width = JUMPER_WIDTH, height = JUMPER_HEIGHT;
	private float gravity = GRAVITY;

	private int health = JUMPER_HEALTH;
	private boolean falling;
	private HUD hud;

	private int hitWait = CLICK_SPEED;



	public Jumper(float x, float y, ID id, float dx, HUD hud) {
		super(x, y, id);
		this.dx= dx;
		this.hud = hud;
	}

	public void tick(LinkedList<GameObject> objects) {
		x += dx;
		y += dy;
		if(falling ) {
			dy += gravity;
		}
		
		if(health <= 0){ //if it dies
			hud.increaseScore(200);
			objects.add(new Upgrade(x, y + 12, ID.HealthUpgrade, -1));
			objects.add(new Upgrade(x, y + 12, ID.HealthUpgrade, 1));
			objects.remove(this);
		}
		
		for(int i = 0; i < objects.size(); i++) {//collision
			GameObject temp = objects.get(i);
			
			if(temp.getID() == ID.Block || temp.getID() == ID.DeathBlock || temp.getID() == ID.TransparentBlock ) {
				normalBlockCollision(temp);
				
			}else if(temp.getID() == ID.PlayerBullet) {
				if(checkBounds(temp)) {
					objects.remove(temp);
					health--;
				}
				
			}else if(temp.getID() == ID.PlayerKnife && ((Knife)temp).getClick()) {
				hitWait++;
				if(checkBounds(temp)) {
					if(hitWait > CLICK_SPEED) {
						health -= 2;
						hitWait = 0;
					}
				}
			}
		}
	}

	private void normalBlockCollision(GameObject block) {
		if(this.getBoundsBottom().intersects(block.getBounds())) {
			y = block.getY() - height;
			dy = -10 - r.nextInt(5);
			falling = false;
		}else falling = true;
		
		if(this.getBoundsTop().intersects(block.getBounds())) {
			dy = 0;
			y = block.getY() + BLOCK_HEIGHT;
		}else if(this.getBoundsLeft().intersects(block.getBounds())) {
			x = block.getX() + BLOCK_WIDTH;
			dx *= -1;
			
		}else if(this.getBoundsRight().intersects(block.getBounds())) {
			x = block.getX() - width;
			dx *= -1;
		}
	}

	public void render(Graphics g) {
		g.setColor(new Color(200, 200, 100));
		g.fillRect((int)x, (int) y, width, height);
		g.setColor(Color.white);
		//face
		g.fillRect((int)x + 6, (int) y + 8, 4, 4);
		g.fillRect((int)x + width - 8, (int) y + 8, 4, 4);
		g.drawLine((int) x, (int) y + 20, (int)x + width - 1, (int) y + 20);
		//health
		g.setColor(new Color(125, Game.clamp(health, 0, JUMPER_HEALTH) * (255/JUMPER_HEALTH), 0));
		g.fillRect((int)x, (int)y - 10 , width * health / JUMPER_HEALTH, 5);
		
//		//Bounding Boxes
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBoundsBottom());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());

	}

	public boolean checkBounds(GameObject temp) {
		if(getBounds().intersects(temp.getBounds())) {
			return true;
		}
		return false;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int)y, width, height);
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle((int) x+8, (int)y + height/2, width-16, height/2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x+8, (int)y, width-16, height/2);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int)y + 4, width/2 - 6, height - 8);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + width/2 + 6, (int)y + 4, width/2 - 7, height - 8);
	}
}
