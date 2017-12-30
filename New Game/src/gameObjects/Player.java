package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.Game;
import framework.Game.STATE;
import userInterface.HUD;

public class Player extends GameObject{
	
	private int width = PLAYER_WIDTH, height = PLAYER_HEIGHT;
	private float gravity = GRAVITY;
	
	private boolean falling, jumping;
	private int direction = 1;//left = -1, right = 1
	private boolean invincible = true;
	
	private Handler handler;
	private HUD hud;
	private Checkpoint cp;

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
			Game.gameState = STATE.Loss;
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
					dy = 0;
					falling = false;
					jumping = false;
				}else {
					falling = true;
				}
			}else if(temp.getID() == ID.DeathBlock && checkAllBounds(temp)) {//if player touches a deathblock
				if(!invincible)
					Game.gameState = STATE.Loss;
				
			}else if(temp.getID() == ID.Goal && checkAllBounds(temp)) {
				
				Handler.LEVEL ++;
				cp = null;
				handler.switchLevel();
			}else if(temp.getID() == ID.Checkpoint && checkAllBounds(temp)){
				cp = (Checkpoint) temp;
			}else if(temp.getID() == ID.Enemy || temp.getID() == ID.Shooter 
						|| temp.getID() == ID.SmartEnemy){
				if(checkAllBounds(temp)) {
					if(!invincible)
						Game.gameState = STATE.Loss;
				}
			}else if(temp.getID() == ID.EnemyBullet) {// if player touches bullet
				if(checkAllBounds(temp)) {
					if(!invincible)
						hud.loseLife();
					objects.remove(temp);
				}
			}else if(temp.getID() == ID.Coin && checkAllBounds(temp)) {
				hud.increaseScore(100);
				objects.remove(temp);
			}else if(temp.getID() == ID.Knife || temp.getID() == ID.PlayerKnife) {
				if(checkAllBounds(temp)) {
					temp.setX(x + 8);
					temp.setY(y + 8);
				}
			}else if(temp.getID() == ID.HealthUpgrade && checkAllBounds(temp)) {
				hud.gainLife();
				objects.remove(temp);
			}else if(temp.getID() == ID.AmmoUpgrade && checkAllBounds(temp)) {
				hud.increaseAmmo(6);
				objects.remove(temp);
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
			y = block.getY() + BLOCK_HEIGHT;
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

	public Checkpoint getCP() {
		return cp;
	}

	public void setCP(Checkpoint cp) {
		this.cp = cp;
	}
}
