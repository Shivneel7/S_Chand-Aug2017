import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board implements Constants{

	Tile[][] board;
	ArrayList<Boolean> random = new ArrayList<>();
	public Board() {
		board = new Tile[NUM_ROW][NUM_COL];
		addTiles();
		plantMines();
		checkProximity();
	}

	private void addTiles() {
		int temp = 0;
		for(int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row, col, false, temp);
				temp++;
			}
		}
	}
	
	private void plantMines(){
		Random r = new Random();
		for(int i = 0; i < NUM_MINES;) {
			Tile temp = board[r.nextInt(NUM_ROW)][r.nextInt(NUM_COL)];
			if(!temp.hasMine()) {
				temp.setMine(true);
				i++;
			}
		}
	}
	
	private void checkProximity() {
		for(Tile[] row: board) {
			for(Tile t: row) {
				if(!t.hasMine()) {
					
				}
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
