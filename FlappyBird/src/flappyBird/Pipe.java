package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Pipe {
	
	private int x, y;
	Random r = new Random();
	
	public Pipe() {
		this.x = Game.background2.getX() - 60;
		this.y = r.nextInt(195) + 200;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, 0, 40, Game.HEIGHT - y);
		g.fillRect(x, Game.HEIGHT - y + 100, 40, Game.HEIGHT);
	}
	
	public void tick() {
		this.x = Game.background2.getX() - 40;
	}
	
}