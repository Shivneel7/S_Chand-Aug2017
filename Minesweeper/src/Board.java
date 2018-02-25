import java.awt.Graphics;
import java.util.ArrayList;

public class Board implements Constants{

	Tile[][] board;
	ArrayList<Boolean> random = new ArrayList<>();
	public Board() {
		board = new Tile[NUM_ROW][NUM_COL];
		addTiles();
		//Save tiles in a 2d array
	}
	
	public void addTiles() {
		int temp = 0;
		for(int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row, col, false,board, temp);
				temp++;
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
