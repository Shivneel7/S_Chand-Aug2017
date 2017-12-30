package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.Game;
import userInterface.HUD;

public class SmartJumper extends GameObject{

	private int width = 32, height = 32;
	private float gravity = GRAVITY;

	private int health = SMART_HEALTH;
	private boolean falling, jumping, sensePlayer;
	
	private HUD hud;
	private Player player;
	
	private int jumpCounter = 0;
	private int hitWait = 0;


	public SmartJumper(float x, float y, ID id, float dx, HUD hud, Player p) {
		super(x, y, id);
		this.dx= dx;
		this.hud = hud;
		player = p;
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
			objects.add(new Upgrade(x, y + 12, ID.HealthUpgrade, 0));
			objects.add(new Upgrade(x, y + 12, ID.HealthUpgrade, 1));
			objects.remove(this);
		}
		
		for(int i = 0; i < objects.size(); i++) {//collision
			GameObject temp = objects.get(i);
			if(temp.getID() == ID.Block || temp.getID() == ID.DeathBlock || temp.getID() == ID.TransparentBlock ) {
				normalBlockCollision(temp);
			}
			if(temp.getID() == ID.PlayerBullet) {
				if(checkAllBounds(temp)) {
					objects.remove(temp);
					health--;
				}
			}
			
			if(temp.getID() == ID.PlayerKnife && ((Knife)temp).getClick()) {
				hitWait++;
				if(checkAllBounds(temp)) {
					if(hitWait > 10) {
						health -= 2;
						hitWait = 0;
					}
				}
			}
		}
		
		//AI
		int distance = (int) Math.abs(player.getX() - x);
		if(distance < 500) {
			sensePlayer = true;
			if(distance < 100) {
				dx = 2 * Math.signum((player.getX() - x));
			}else if(distance < 350) {
				dx = 3.5f * Math.signum((player.getX() - x));
			}else {
				dx = 5 * Math.signum((player.getX() - x));
			}
		}else {
			sensePlayer = false;
		}
	}

	private void normalBlockCollision(GameObject block) {
		if(this.getBounds().intersects(block.getBounds())) {
			y = block.getY() - height;
			dy = -10;
		}else {
			falling = true;
		}
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
		g.setColor(new Color(125, Game.clamp(health, 0, SMART_HEALTH) * (255/SMART_HEALTH), 0));
		g.fillRect((int)x, (int)y - 10 , width * health / SMART_HEALTH, 5);
		
//		//Bounding Boxes
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsTop());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsRight());

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
		return new Rectangle((int) x, (int)y + 4, width/2 - 6, height - 8);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + width/2 + 6, (int)y + 4, width/2 - 7, height - 8);
	}
}
