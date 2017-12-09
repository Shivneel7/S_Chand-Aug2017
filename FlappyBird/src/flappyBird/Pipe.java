package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pipe {
	
	private int x, y;
	private Background b;
	private int pipeWidth = 40;
	
	Random r = new Random();
	
	public Pipe(Background b) {
		this.b = b;
		this.x = b.getX() - 60;
		this.y = r.nextInt(195) + 200;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Rectangle getBounds1() {
		return new Rectangle(x , 0, pipeWidth, Game.HEIGHT - y);
	}
	
	public Rectangle getBounds2() {
		return new Rectangle(x, Game.HEIGHT - y + 90, pipeWidth, y - 90);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, 0, pipeWidth, Game.HEIGHT - y);
		g.fillRect(x, Game.HEIGHT - y + 90, pipeWidth, y - 90);
	}
	
	public void getRandomY() {
		y = r.nextInt(195) + 200;
	}
	
	public void tick() {
		this.x = b.getX() - pipeWidth;
		if(x == (Game.WIDTH % Game.SPEED) - pipeWidth) {
			y = r.nextInt(195) + 200;
		}
	}
	
}