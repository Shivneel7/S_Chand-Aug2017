
public class Tiles {
	
	public final static int WIDTH = Game.WIDTH / 20, HEIGHT = Game.HEIGHT/20;
	
	private int x, y; 
	private boolean mine;
	
	public Tiles(int x, int y, boolean mine) {
		super();
		this.x = x;
		this.y = y;
		this.mine = mine;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}
}
