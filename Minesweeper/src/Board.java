import java.awt.Graphics;
import java.util.ArrayList;

public class Board implements Constants{

	Tile[][] board;
	ArrayList<Boolean> random = new ArrayList<>();
	public Board() {
		board = new Tile[NUM_COL][NUM_ROW];
		addTiles();
		//Save tiles in a 2d array
	}
	
	public void addTiles() {
		for(int col = 0; col < board.length; col ++) {
			for(int row = 0; row < board[col].length; row++) {
				board[col][row] = new Tile(col, row, false,board);
			}
		}
	}
	
	public void render(Graphics g) {
		for(Tile[] row: board) {
			for(Tile t: row) {
				t.render(g);
			}
		}
	}
	
	public void tick() {
		
	}
}
