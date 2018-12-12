import java.awt.Graphics;

public class Board implements Constants{
	public Tile[][] board;
	
	public Board() {
		board = new Tile[4][4];
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row * TILE_LENGTH, col * TILE_LENGTH);
			}
		}
	}
	
	public void render(Graphics g) {
		for(Tile[] r : board) {
			for(Tile tile : r) {
				tile.render(g);
			}
		}
	}
	
}
