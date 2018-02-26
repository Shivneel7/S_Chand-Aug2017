import java.awt.Color;
import java.awt.Graphics;

public class Tile implements Constants{
	
	
	
	private int x, y, temp; 
	private boolean mine;
	private Tile[][] board;

	public Tile(int row, int col, boolean mine, Tile[][] board, int temp) {
		super();
		this.x = col * TILE_LENGTH;
		this.y = row * TILE_LENGTH;
		this.mine = mine;
		this.board = board;
		this.temp = temp;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(new Color(temp * 1, temp * 2, temp * 4));
		g.fillRect(x, y, TILE_LENGTH, TILE_LENGTH);
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
