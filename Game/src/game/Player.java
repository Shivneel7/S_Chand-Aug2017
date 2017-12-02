package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		
		dx = r.nextInt(6);
		dy = r.nextInt(6);
	}

	@Override
	public void tick() {
		x += dx;
		y += dy;
		
	}

	@Override
	public void render(Graphics g) {
		drawPlayer(g);
		
	}
	
	public void drawPlayer(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 100, 100);
		g.setColor(Color.white);
		g.fillOval(x+20, y+20, 10, 10);
		g.fillOval(x+70, y+20, 10, 10);
	}

}
