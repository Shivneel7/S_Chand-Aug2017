package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Pipe {
	
	private int x, y;
	Random r = new Random();
	
	public Pipe() {
		this.x = Game.background2.getX() - 60;
		this.y = Game.clamp(r.nextInt(Game.HEIGHT-10) , 200, Game.HEIGHT-10);
	}
	
	public int getX() {
		return this.x;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, 0, 40, Game.HEIGHT - y);
		g.fillRect(x, Game.HEIGHT - y + 90, 40, Game.HEIGHT);
	}
	
	public void tick() {
		this.x = Game.background2.getX() - 40;
	}
	
}