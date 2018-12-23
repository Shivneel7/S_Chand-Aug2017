import java.awt.Graphics;
import java.util.Random;

public class Board implements Constants {

	public Tile[][] board;
	Random r;

	int numEmpty = 16;

	public Board() {
		r = new Random();
		board = new Tile[4][4];

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row, col);
			}
		}
		addTile();
		addTile();
	}

	public void move(String direction) {
		if (direction.equals("up")) {

		} else if (direction.equals("down")) {

		} else if (direction.equals("left")) {

		} else if (direction.equals("right")) {
		
		}
		addTile();

	}
	/**
	 * Make the searching algorithm better
	 */
	public void addTile() {

		if (numEmpty == 0) {
			//LOSE
		} else {
			int numCount = 0;

			while (numCount == 0) {

				int row1 = r.nextInt(4);
				int col1 = r.nextInt(4);

				if (board[row1][col1].getNumber() == 0) {
					System.out.println(numEmpty);
					numCount++;
					numEmpty--;
					if (r.nextInt(10) == 0) {
						board[row1][col1].setNumber(4);
					} else {
						board[row1][col1].setNumber(2);
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		for (Tile[] r : board) {
			for (Tile tile : r) {
				tile.render(g);
			}
		}
	}

}
