package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import userInterface.HUD;

public class SmartEnemy extends GameObject{

	private int width = SHOOTER_WIDTH, height = SHOOTER_HEIGHT;
	private float gravity = GRAVITY;

	private boolean falling, jumping;
	
	private HUD hud;
	private Player player;
	private int jumpCounter = 0;


	public SmartEnemy(float x, float y, ID id, float dx, HUD hud, Player p) {
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
		for(int i = 0; i < objects.size(); i++) {//collision
			GameObject temp = objects.get(i);
			if(temp.getID() == ID.Block || temp.getID() == ID.DeathBlock) {
				normalBlockCollision(temp);
			}else if(temp.getID() == ID.TransparentBlock) {
				if(this.getBounds().intersects(temp.getBounds()) && dy > 0) {
					y = temp.getY() - height;
					dy = 0;
					falling = false;
					jumping = false;
				}else {
					falling = true;
				}
			}
			if(temp.getID() == ID.PlayerBullet) {
				if(checkAllBounds(temp)) {
					objects.remove(temp);
					objects.remove(this);
				}
			}
//			if(temp.getID() == ID.PlayerKnife && ((Knife)temp).getClick()) {
//				if(checkAllBounds(temp)) {
//					hud.increaseScore(100);
//					hud.setPlayerHasGun(true);
//					objects.add(new Upgrade(x, y + 12, ID.AmmoUpgrade));
//					objects.remove(this);
//				}
//			}

			//AI
			int distance = (int) Math.abs(player.getX() - x);
			System.out.println(distance);
			if(distance < 500) {
				if(distance < 100) {
					System.out.println(distance);
					dx = 3 * Math.signum((player.getX() - x));
				}else if(distance < 350) {
					System.out.println(distance);
					dx = 4 * Math.signum((player.getX() - x));
				}else {
					System.out.println(distance);
					dx = 5 * Math.signum((player.getX() - x));
				}
			}else {
				jumping = true;
			}
		}
	}

	private void normalBlockCollision(GameObject block) {
		if(this.getBounds().intersects(block.getBounds())) {
			y = block.getY() - height;
			dy = 0;
			falling = false;
			jumpCounter++;
			if(jumpCounter > 20) {
				jumping = false;
				jumpCounter = 0;
			}
		}else {
			falling = true;
		}
		if(this.getBoundsTop().intersects(block.getBounds())) {
			dy = 0;
			y = block.getY() + BLOCK_HEIGHT;
			
		}else if(this.getBoundsLeft().intersects(block.getBounds())) {
			x = block.getX() + BLOCK_WIDTH;
			if(!jumping) {
				dy = -11;
				jumping = true;
			}
		}else if(this.getBoundsRight().intersects(block.getBounds())) {
			x = block.getX() - width;
			if(!jumping) {
				dy = -11;
				jumping = true;
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(SHOOTER_COLOR);
		g.fillRect((int)x, (int) y, width, height);
		g.setColor(Color.white);
		//face
		g.fillRect((int)x + 6, (int) y + 8, 4, 4);
		g.fillRect((int)x + width - 8, (int) y + 8, 4, 4);
		g.drawLine((int) x, (int) y + 20, (int)x + width - 1, (int) y + 20);
		
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
