package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import framework.BufferedImageLoader;
import framework.Constants;
import framework.SpriteSheet;
import gameObjects.GameObject;

public class HUD implements Constants{
	private int lives = NUMBER_OF_LIVES;
	private int score = 0;
	private boolean playerHasGun = false;
	
	private SpriteSheet ss;
	
	
	
	public HUD() {
		BufferedImageLoader loader = new BufferedImageLoader();
		ss = new SpriteSheet(loader.loadImage("/spriteSheet.png"));
	}
	
	public void tick() {

	}
	
	public void render(Graphics g) {
		//Lives
		g.setColor(Color.black);
		g.fillRect(6, 22, lives * 12 + 60, 20);
		g.setColor(new Color(125, lives * (255/NUMBER_OF_LIVES), 0));
		g.setFont(new Font(null, 1, 16));
		g.drawString("Lives:" , 10, 38);
		for(int i = 0; i < lives; i ++) {
			g.fillRect(60 + (12*i), 28, 10, 10);
		}
		//Score
		g.setColor(Color.black);
		g.fillRect(6, 2, 70 + ((""+score).length() * 8) , 20);
		g.setColor(Color.white);
		g.drawString("Score: " + score, 10, 18);
		//gun
		if(playerHasGun) {
			g.drawImage(ss.grabImage(1, 1, 16, 16), 10, 50, 48,48, null);
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
	
	public void increaseScore(int d) {
		score += d;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean doesPlayerHasGun() {
		return playerHasGun;
	}

	public void setPlayerHasGun(boolean playerHasGun) {
		this.playerHasGun = playerHasGun;
	}
	
	
}
