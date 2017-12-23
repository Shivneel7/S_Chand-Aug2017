package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import framework.Constants;

public class HUD implements Constants{
	private int lives = NUMBER_OF_LIVES;
	
	public HUD() {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(6, 14, lives * 12 + 60, 20);
		g.setColor(new Color(125, lives * (255/NUMBER_OF_LIVES), 0));
		g.setFont(new Font(null, 1, 16));
		g.drawString("Lives:" , 10, 30);
		for(int i = 0; i < lives; i ++) {
			g.fillRect(60 + (12*i), 20, 10, 10);
		}
	}
	
	public void resetLives() {
		lives = NUMBER_OF_LIVES;
	}
	
	public void loseLife() {
		if(lives > 0) {
			lives--;
		}
	}
	
	public void gainLife() {
		lives++;
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
}
