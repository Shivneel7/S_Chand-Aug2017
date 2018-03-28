import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Board implements Constants{

	private Tile[][] board;
	private boolean loss;
	private int numFlags = 0, numRow, numCol, numMines;

	public Board(int numRow, int numCol, int numMines) {
		this.numRow = numRow;
		this.numCol = numCol;
		this.numMines = numMines;
		board = new Tile[numRow][numCol];
		addTiles();
		plantMines();
		setTileValues();
	}

	private void addTiles() {
		for(int row = 0; row < board.length; row ++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row, col, false);
			}
		}
	}

	private void plantMines(){
		Random r = new Random();
		for(int i = 0; i < numMines;) {
			Tile temp = board[r.nextInt(numRow)][r.nextInt(numCol)];
			if(!temp.hasMine()) {
				temp.setMine(true);
				i++;
			}
		}
	}

	private void setTileValues() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++) {
				Tile temp = board[row][col];
				if(!temp.hasMine()) {
					temp.setProximity(checkProximity(row, col));
				}
			}
		}
	}

	private int checkProximity(int row, int col) {
		int numMines = 0;
		for(int i = row-1; i <= row + 1; i ++) {
			for(int j = col-1; j <= col + 1; j ++) {
				if(i >= 0 && i < numRow && j >= 0 && j < numCol) {
					if(board[i][j].hasMine()) {
						numMines++;
					}
				}
			}
		}
		return numMines;
	}

	public void click(int row, int col) {
		Tile temp = board[row][col];
		temp.reveal();
		if(temp.hasMine()) {
			lose();
		}else if(temp.getProximity() == 0) {
			for(int i = row-1; i <= row + 1; i ++) {
				for(int j = col-1; j <= col + 1; j ++) {
					if(i >= 0 && i < numRow && j >= 0 && j < numCol) {
						if(!board[i][j].isRevealed()) {
							click(i,j);
						}
					}
				}
			}
		}
	}

	private void lose() {
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col].hasMine()) {
					board[row][col].reveal();
				}
			}
		}
		loss = true;
	}

	public void render(Graphics g) {
		for(Tile[] row: board) {
			for(Tile t: row) {
				t.render(g);
			}
		}
		if(loss) {
			g.setColor(Color.black);
			g.setFont(new Font(null, 0, 40));
			g.drawString("you lost.", 0, GAME_HEIGHT- UI_DIS);
		}
	}

	public void tick() {
		
	}

	public Tile[][] getBoard() {
		return board;
	}

	public int getNumFlags() {
		return numFlags;
	}

	public void incFlags() {
		this.numFlags++;
	}
	
	public void decFlags() {
		this.numFlags--;
	}

}
