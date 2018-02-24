import java.awt.Color;
import java.awt.Graphics;

public class Tile implements Constants{
	
	
	
	private int x, y; 
	private boolean mine;
	private Tile[][] board;

	public Tile(int x, int y, boolean mine, Tile[][] board) {
		super();
		this.x = x * TILE_LENGTH;
		this.y = y * TILE_LENGTH;
		this.mine = mine;
		this.board = board;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect(x, y, TILE_LENGTH, TILE_LENGTH);
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
