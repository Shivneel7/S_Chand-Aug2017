package game;

import java.awt.*;

public abstract class GameObject {
	protected int x, y, dx, dy;
	protected ID id;

	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
	
	public void setId(ID id) {
		this.id = id;
	}

	public ID getId() {
		return id;
	}
	
	public void setdx(int dx) {
		this.dx = dx;
	}
	
	public int getdx() {
		return dx;
	}
	
	public void setdy(int dy) {
		this.dy = dy;
	}
	
	public int getdy() {
		return dy;
	}
	
}