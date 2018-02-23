import java.awt.Graphics;

public class Board {

	Tile[][] board;
	
	public Board(int numTile) {
		board = new Tile[numTile][numTile];
		addTiles();
		//Save tiles in a 2d array
	}
	
	public void addTiles() {
		for(int col = 0; col < board.length; col ++) {
			for(int row = 0; row < board[col].length; row++) {
				
			}
		}
	}
	
	public void render(Graphics g) {
		
	}
	
	public void tick() {
		
	}
}
