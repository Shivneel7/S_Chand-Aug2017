package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pipe {
	
	private int x, y;
	private Background b;
	Random r = new Random();
	
	public Pipe(Background b) {
		this.b = b;
		this.x = b.getX() - 60;
		this.y = r.nextInt(195) + 200;
	}
	
	public int getX() {
		return this.x;
	}
	
	public Rectangle getBounds1() {
		return new Rectangle(x , 0, 40, Game.HEIGHT - y);
	}
	
	public Rectangle getBounds2() {
		return new Rectangle(x, Game.HEIGHT - y + 100, 40, y - 100);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, 0, 40, Game.HEIGHT - y);
		g.fillRect(x, Game.HEIGHT - y + 100, 40, y - 100);
	}
	
	public void tick() {
		this.x = b.getX() - 40;
		if(x == -36) {
			System.out.println("x: " + x);
			y =r.nextInt(195) + 200;
			System.out.println("y: " + y);
		}
	}
	
}