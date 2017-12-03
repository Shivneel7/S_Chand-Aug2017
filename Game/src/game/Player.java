package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += dx;
		y += dy;
		
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
		g.setColor(Color.white);
		g.fillRect(x+6, y+6, 4, 4);
		g.fillRect(x+22, y+6, 4, 4);
	}
	
	public void jump() {

	}

}