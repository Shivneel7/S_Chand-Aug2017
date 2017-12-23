package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import framework.Constants;
import framework.Game;
import framework.Game.STATE;
import gameObjects.Handler;

public class Menu extends MouseAdapter implements Constants{
	
	private Handler handler;
	private HUD hud;
	
	public int lCounter = 0;
	
	public Menu(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	public void tick() {
		if(Game.gameState == STATE.Loss) {
			hud.resetLives();
			handler.switchLevel();
			hud.setScore(0);
			Game.gameState = STATE.Game;
//			lCounter ++;
//			if(lCounter > 100) {
//				Game.gameState = STATE.Game;
//				lCounter =0;
//			}
		}
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
		
		if(Game.gameState == STATE.Menu) {
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
