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
		//Play Button
		if(game.gameState == STATE.Menu) {
			if(getClick(mx, my,game.WIDTH/3-75, 150, 150, 75)) {//EZPZ
				game.SPEED = 4;
				startGame();
			}else if(getClick(mx, my, game.WIDTH/3 * 2 - 75, 150, 150, 75)) {//meh.
				game.SPEED = 5;
				startGame();
			}else if(getClick(mx, my, game.WIDTH/3 - 75, 250, 150, 75)) {//HARD
				game.SPEED = 6;
				startGame();
			}else if(getClick(mx, my, game.WIDTH/3 * 2 - 75, 250, 150, 75)) {//INSANE
				game.SPEED = 7;
				startGame();
			}
		}
		//Play Again
		if(game.gameState == STATE.Loss) {
			if(getClick(mx, my,game.WIDTH/2 - 110, 195, 220, 100)) {
				game.gameState = STATE.Menu;
				game.score = 0;
			}
		}
	}
	
	private void startGame() {
		game.gameState = STATE.Game;
		game.restartBackground();
		game.resetBackground();
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
		g.setFont(new Font("Arial", 1, 60));
		g.setColor(Color.black);
		if(game.gameState == STATE.Menu) {
			//Title
			g.fillRect(game.WIDTH/2 - 200, 15, 400, 80);
			g.setColor(Color.orange);
			g.drawString("Derpy Burd", game.WIDTH/2 - 165, 74);
			//Select Difficulty
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 25));
			g.fillRect(game.WIDTH/2 - 100, 100, 200, 40);
			g.setColor(Color.cyan);
			g.drawString("Select Difficulty", game.WIDTH/2 - 90, 130);
			//EZ
			g.setFont(new Font("Arial", 1, 40));
			g.setColor(Color.black);
			g.fillRect(game.WIDTH/3-75, 150, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("EZ PZ", game.WIDTH/3 - 55, 200);
			//Meh.
			g.setFont(new Font("Arial", 0, 40));
			g.setColor(Color.black);
			g.fillRect(game.WIDTH/3 * 2 - 75, 150, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("meh.", game.WIDTH/3 * 2 - 40, 200);
			//Hard
			g.setColor(Color.black);
			g.fillRect(game.WIDTH/3 - 75, 250, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("Hard", game.WIDTH/3 - 43, 305);
			//Insane
			g.setFont(new Font("Arial", 1, 38));
			g.setColor(Color.black);
			g.fillRect(game.WIDTH/3 * 2 - 75, 250, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("INSANE", game.WIDTH/3 * 2 - 70, 305);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", 1, 38));
		g.drawString("By: Shivneel Chand", game.WIDTH/2 - 177, game.HEIGHT - 39);
		if(game.gameState == STATE.Loss) {
			g.setFont(new Font("Arial", 1, 35));
			g.drawString("You lost with a score of: " + game.score, 30, Game.HEIGHT /2 - 40);
			g.fillRect(game.WIDTH/2 - 110, 195, 220, 100);
			g.setColor(Color.cyan);
			g.drawString("Play Again?", 204, 257);
		}
	}
}
