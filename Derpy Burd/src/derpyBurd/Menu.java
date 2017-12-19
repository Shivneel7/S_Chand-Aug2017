package derpyBurd;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import derpyBurd.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Audio[] sounds = new Audio[4];
	private boolean soundsOn = false;
	
	public Menu(Game game) {
		this.game = game;
		sounds[0] = new Audio("/ez.wav", -15);
		sounds[1] = new Audio("/meh.wav", -10);
		sounds[2] = new Audio("/hard.wav", -10);
		sounds[3] = new Audio("/insane.wav", -11);
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		//Play Button
		if(Game.gameState == STATE.Menu) {
			if(getClick(mx, my, Game.WIDTH - 102, Game.HEIGHT - 102, 80, 50)) {
				Game.gameState = STATE.Options;
			}else if(getClick(mx, my,Game.WIDTH/3-75, 150, 150, 75)) {//EZPZ
				if(soundsOn) {
					sounds[0].play();
				}
				Game.SPEED = 4;
				startGame();
			}else if(getClick(mx, my, Game.WIDTH/3 * 2 - 75, 150, 150, 75)) {//meh.
				if(soundsOn) {
					sounds[1].play();
				}
				Game.SPEED = 5;
				startGame();
			}else if(getClick(mx, my, Game.WIDTH/3 - 75, 250, 150, 75)) {//HARD
				if(soundsOn) {
					sounds[2].play();
				}
				Game.SPEED = 6;
				startGame();
			}else if(getClick(mx, my, Game.WIDTH/3 * 2 - 75, 250, 150, 75)) {//INSANE
				if(soundsOn) {
					sounds[3].play();
				}
				Game.SPEED = 7;
				startGame();
			}
		}
		else if(Game.gameState == STATE.Loss) {
			if(getClick(mx, my,Game.WIDTH/2 - 110, 195, 220, 100)) {//Play Again
				Game.gameState = STATE.Menu;
			}
		}else if(Game.gameState == STATE.Options) {//options
			if(getClick(mx, my, Game.WIDTH/2 - 45, Game.HEIGHT - 110, 100, 40)) {//Back
				Game.gameState = STATE.Menu;
			}
			if(getClick(mx, my, 210 , 48, 60, 40)) {
				soundsOn = true;
			}
			if(getClick(mx, my, 312 , 48, 60, 40)) {
				soundsOn = false;
			}
		}
	}
	
	private void startGame() {
		game.score = 0;
		Game.gameState = STATE.Game;
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
		if(Game.gameState == STATE.Menu) {
			//Title
			g.fillRect(Game.WIDTH/2 - 200, 15, 400, 80);
			g.setColor(Color.orange);
			g.drawString("Derpy Burd", Game.WIDTH/2 - 165, 74);
			//Select Difficulty
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 25));
			g.fillRect(Game.WIDTH/2 - 100, 100, 200, 40);
			g.setColor(Color.cyan);
			g.drawString("Select Difficulty", Game.WIDTH/2 - 90, 130);
			//EZ
			g.setFont(new Font("Arial", 1, 40));
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH/3-75, 150, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("EZ PZ", Game.WIDTH/3 - 55, 200);
			//Meh.
			g.setFont(new Font("Arial", 0, 40));
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH/3 * 2 - 75, 150, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("meh.", Game.WIDTH/3 * 2 - 40, 200);
			//Hard
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH/3 - 75, 250, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("Hard", Game.WIDTH/3 - 43, 305);
			//Insane
			g.setFont(new Font("Arial", 1, 38));
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH/3 * 2 - 75, 250, 150, 75);
			g.setColor(Color.cyan);
			g.drawString("INSANE", Game.WIDTH/3 * 2 - 70, 305);
			//Options
			g.setFont(new Font("Arial", 1, 20));
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH - 102, Game.HEIGHT - 102, 80, 50);
			g.setColor(Color.cyan);
			g.drawString("options", Game.WIDTH- 97, Game.HEIGHT - 70);
		
		}else if(Game.gameState == STATE.Options) {//options
			//Back
			g.fillRect(Game.WIDTH/2 - 45, Game.HEIGHT - 110, 100, 40);
			g.setFont(new Font("Arial", 1, 30));
			g.setColor(Color.cyan);
			g.drawString("Back", Game.WIDTH/2 - 30, Game.HEIGHT - 80);
			//Sounds
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 30));
			g.drawString("Sounds:", 50, 80);
			g.setColor(Color.black);
			if(soundsOn) {
				g.fillRect(210 , 48, 60, 40);
			}else {
				g.fillRect(312 , 48, 60, 40);
			}
			g.setColor(Color.cyan);
			g.drawString("On", 220, 80);
			g.setColor(Color.cyan);
			g.drawString("Off", 320, 80);
			
			//help text
			g.setColor(Color.black);
			g.setFont(new Font("Arial", 1, 16));
			g.drawString("Press Space to Flap.", 200, 135);
			g.drawString("Don't hit the pipe.", 200, 185);
			g.drawString("Press ESC to Pause.", 200, 235);
	
		}else if(Game.gameState == STATE.Loss) {//loss screen
			g.setFont(new Font("Arial", 1, 35));
			g.drawString("You lost with a score of: " + game.score, 30, Game.HEIGHT /2 - 40);
			g.fillRect(Game.WIDTH/2 - 110, 195, 220, 100);
			g.setColor(Color.cyan);
			g.drawString("Play Again?", 204, 257);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", 1, 38));
		g.drawString("By: Shivneel Chand", Game.WIDTH/2 - 177, Game.HEIGHT - 39);
	}
}
