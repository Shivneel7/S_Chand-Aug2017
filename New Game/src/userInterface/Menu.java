package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import framework.Constants;
import framework.Game;
import framework.Game.STATE;
import gameObjects.Bullet;
import gameObjects.GameObject;
import gameObjects.Handler;
import gameObjects.ID;
import gameObjects.Knife;
/**
 * Handles all mouse events, not just menu.
 * @author shivn
 *
 */
public class Menu extends MouseAdapter implements Constants{
	
	private Handler handler;
	private HUD hud;
	
	public Menu(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	public void tick() {
		//What happens when we lose
		if(Game.gameState == STATE.Loss) {
			loss();
		}
	}
	
	/**
	 * What happens when player loses.
	 */
	private void loss() {
		hud.resetLives();
		hud.setPlayerHasGun(false);
		hud.setAmmo(0);
		handler.switchLevel();
		System.out.println(handler.player.getCP());
		if(handler.player.getCP() != null) {
			handler.player.setX(handler.player.getCP().getX());
			handler.player.setY(handler.player.getCP().getY());
		}
		hud.setScore(0);
		Game.gameState = STATE.Game;
	}
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
			g.setColor(Color.white);
			g.setFont(new Font(null, 1, 90));
			g.drawString("THIS IS THE MENU" , 0, GAME_HEIGHT /2 );
			g.drawRect(200, 200, 200, 200);
		}else if(Game.gameState == STATE.Loss) {
			g.setColor(Color.white);
			g.setFont(new Font(null, 1, 90));
			g.drawString("U Looz" , 0, GAME_HEIGHT /2 );
			g.drawRect(200, 200, 200, 200);
		}
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if(Game.gameState == STATE.Game) {
			for(int i = 0; i < handler.objects.size(); i++) {
				GameObject temp = handler.objects.get(i);
				if(temp.getID() == ID.PlayerKnife &&  e.getButton() == MouseEvent.BUTTON1){
					((Knife)temp).setClick(true);
				}
			}
			if(hud.doesPlayerHasGun() && hud.getAmmo() > 0 &&  e.getButton() == MouseEvent.BUTTON3) {
				handler.addObject(new Bullet(handler.player.getX() + PLAYER_WIDTH/2, 
						handler.player.getY() + PLAYER_HEIGHT/5 * 2, ID.PlayerBullet,
						BULLET_SPEED * (handler.player.getDirection()), 0));
				hud.increaseAmmo(-1);
			}
		}else if(Game.gameState == STATE.Menu) {
			if(getClick(mx, my, 200, 200, 200, 200)) {
				Game.gameState = STATE.Game;
			}
		}else if(Game.gameState == STATE.Loss) {
			if(getClick(mx, my, 200, 200, 200, 200)) {
				Game.gameState = STATE.Game;
			}
		}
	}

	public boolean getClick(int mx, int my, int x, int y, int width, int height) {
		if(mx < width + x && mx > x && my < height+y && my > y) {
			return true;
		}else return false;
	}
	
}
