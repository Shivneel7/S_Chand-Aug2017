package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.Game;
import framework.Game.STATE;
import userInterface.HUD;

public class Player extends GameObject{
	
	private int width = PLAYER_WIDTH, height = PLAYER_HEIGHT;
	private float gravity = GRAVITY;
	private boolean falling, jumping;
	private Handler handler;
	private HUD hud;
	private boolean hasGun = false;
	private int direction = 1;//left = -1, right - 1
	private boolean hasKnife = false;
	
	public Player(float x, float y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
	}

	public void tick(LinkedList<GameObject> objects) {
		x += dx;
		y += dy;
		if(falling) {
			dy += gravity;
		}
		if(y > 1400) { // for death by falling through map
			handler.switchLevel();
		}
		
		collision(objects);
	}

	private void collision(LinkedList<GameObject> objects) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);
			if(temp.getID() == ID.Block) {//if player touches a block
				normalBlockCollision(temp);
			}else if(temp.getID() == ID.TransparentBlock) {
				if(this.getBounds().intersects(temp.getBounds()) && dy > 0) {
					y = temp.getY() - height;
					dy=0;
					falling = false;
					jumping = false;
				}else {
					falling = true;
				}
			}else if(temp.getID() == ID.DeathBlock) {//if player touches a deathblock
				if(checkAllBounds(temp)) {
					Game.gameState = STATE.Loss;
				}
			}else if(temp.getID() == ID.Goal) {
				if(checkAllBounds(temp)) {
					Handler.LEVEL ++;
					handler.switchLevel();
				}
			}else if(temp.getID() == ID.Enemy){
				if(checkAllBounds(temp)&&hasKnife ) {
					objects.remove(temp);
					hasGun = true;
					hud.setPlayerHasGun(true);
				}
			}else if(temp.getID() == ID.EnemyBullet) {// if player touches bullet
				if(checkAllBounds(temp)) {
					hud.loseLife();
					objects.remove(temp);
				}
			}else if(temp.getID() == ID.Coin) {
				if(checkAllBounds(temp)) {
					hud.increaseScore(100);
					objects.remove(temp);
				}
			}
		}
	}
	//Collision for normal blocks
	private void normalBlockCollision(GameObject block) {
		if(this.getBounds().intersects(block.getBounds())) {
			y = block.getY() - height;
			dy = 0;
			falling = false;
			jumping = false;
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
		g.setColor(PLAYER_COLOR);
		g.fillRect((int)x, (int) y, width, height);
		g.setColor(Color.white);
		if(direction == -1) {
			g.fillRect((int)x + 8, (int) y + 8, 4, 4);
			g.drawLine((int) x, (int) y + 20, (int)x + 10, (int) y + 20);
		}else {
			g.fillRect((int)x + width - 8, (int) y + 8, 4, 4);
			g.drawLine((int) x + width, (int) y + 20, (int)x + width - 10, (int) y + 20);
		}
		//Bounding Boxes
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.red);
//		g2d.draw(getBounds());
//		g2d.draw(getBoundsTop());
//		g2d.draw(getBoundsLeft());
//		g2d.draw(getBoundsRight());
	}
	
	//TODO: Remove constants in bounding
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
	
	//returns true if the player is touching the given object on any side.
	public boolean checkAllBounds(GameObject temp) {
		if(this.getBounds().intersects(temp.getBounds()) ||
				this.getBoundsTop().intersects(temp.getBounds()) ||
				this.getBoundsRight().intersects(temp.getBounds()) ||
				this.getBoundsLeft().intersects(temp.getBounds())) {
			return true;
		}
		return false;
	}
	
	public boolean isJumping() {
		return jumping;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public boolean hasGun() {
		return hasGun;
	}

	public void setHasGun(boolean hasGun) {
		this.hasGun = hasGun;
	}
	
}
