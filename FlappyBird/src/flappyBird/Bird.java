package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Bird {
	
	private int x;
	private int y;
	private int dy;
	public int counter = 0;
	public int tickSlower = 0;
	
	public Bird(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setdy(int dy) {
		this.dy = dy;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getdy() {
		return this.dy;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void tick() {
		this.y += dy;
		if(dy != 0 ) {
			counter ++;
		}
		if(counter > 15) {
				dy = 2;
		}
		if(this.y > 280) {
				dy =0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(x, y, 32, 32);
		g.setColor(Color.white);
		g.fillOval(x +22, y + 6, 4, 4);
		g.setColor(Color.yellow);
		int[] arr = {x + 31, x +32, x + 32 + 6};
		int[] arr2 = {y + 11, y + 17, y + 14};
		g.fillPolygon(arr, arr2, 3);
	}
	
	public void jump() {
		dy = -3;
		counter = 0;
	}
}
