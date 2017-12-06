package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import flappyBird.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;	
	
	public Menu(Game game) {
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
	
		if(game.gameState == STATE.Menu) {
			if(getClick(mx, my, game.WIDTH/2 - 100, 100, 200, 100)) {
				game.gameState = STATE.Game;
				game.resetBackground();
			}
		}
		
		if(game.gameState == STATE.Loss) {
			if(getClick(mx, my,game.WIDTH/2 - 110, 195, 220, 100)) {
				game.gameState = STATE.Game;
				game.resetBackground();
				game.score = 0;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public boolean getClick(int mx, int my, int x, int y, int width, int height) {
		if(mx < width + x && mx > x && my < height+y && my > y) {
			return true;
		}else return false;
	}
	
	public void tick() {
	
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("Arial", 1, 70));
		g.setColor(Color.black);
		if(game.gameState == STATE.Menu) {
			g.fillRect(game.WIDTH/2 - 100, 100, 200, 100);
			g.setColor(Color.cyan);
			g.drawString("Play", game.WIDTH/2 - 70, 170);
		}
		if(game.gameState == STATE.Loss) {
			g.setFont(new Font("Arial", 1, 35));
			g.drawString("You lost with a score of: " + game.score, 30, Game.HEIGHT /2 - 40);
			g.fillRect(game.WIDTH/2 - 110, 195, 220, 100);
			g.setColor(Color.cyan);
			g.drawString("Play Again?", 204, 257);
		}
	}
}
