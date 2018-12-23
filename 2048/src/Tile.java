import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Tile implements Constants{

	private int number;
	private int row, col;
	private Color c;

	private Random r = new Random();

	public Tile(int row, int col, int number) {
		this.row = row;
		this.col = col;
		this.number = number;
	}

	public Tile (int x, int y) {
		this(x,y,0);
	}

	public void render(Graphics g) {
		g.setColor(getColor());
		g.fillRect(row * TILE_LENGTH, col * TILE_LENGTH, TILE_LENGTH, TILE_LENGTH);
		if(number != 0) {
			if(number == 2 || number == 4) {
				g.setColor(new Color(117,101,87));
			}else {
				g.setColor(Color.white);
			}
			g.setFont(new Font(null, 0, 40));
			g.drawString("" + number, row * TILE_LENGTH + TILE_LENGTH/2 - 15, col * TILE_LENGTH + TILE_LENGTH/2 - 20);
		}
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(row * TILE_LENGTH, col * TILE_LENGTH, TILE_LENGTH, TILE_LENGTH);
	}

	private Color getColor() {
		switch(number) {
		case 2: 
			return new Color(250,231,224);
		case 4:
			return new Color(246,232,206);
		case 8:
			return new Color(252,176,126);
		case 16:
			return new Color(245,149,99);
		case 32:
			return new Color(246,124,95);
		case 64:
			return new Color(246,94,59);
		case 128:
			return new Color(237,207,114);
		case 256:
			return new Color(113,181,219);
		case 512:
			return new Color(243,75,92);
		case 1024:
			return new Color(0,127,194);
		case 2048:
			return new Color(251,197,45);
		case 4096:
			return new Color(244,102,116);
		default:
			return new Color(238,228,218);
		}
	}
	
	public void setNumber(int n) {
		number = n;
	}

	public int getNumber() {
		return number;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	


}
