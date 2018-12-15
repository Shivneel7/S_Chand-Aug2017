import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Tile implements Constants{

	private int number;
	private int x, y;
	private Color c;

	private Random r = new Random();

	public Tile(int x, int y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;	
	}

	public Tile (int x, int y) {
		this(x,y,0);
	}

	public void render(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, TILE_LENGTH, TILE_LENGTH);
		if(number != 0) {
			if(number != 2 || number != 4) {
				g.setColor(Color.WHITE);
			}else {
				g.setColor(Color.BLACK);
			}
			g.setFont(new Font(null, 0, 40));
			g.drawString("" + number, x + TILE_LENGTH/2 - 15, y + TILE_LENGTH/2 - 20);
		}
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, TILE_LENGTH, TILE_LENGTH);
	}

	private Color getColor() {
		switch(number) {
		case 2: 
			return new Color(238,228,218);
		case 4:
			return new Color(237,224,200);
		case 8:
			return new Color(242,177,121);
		case 16:
			return new Color(245,149,99);
		case 32:
			return new Color(246,124,95);
		case 64:
			return new Color(246,94,59);
		case 128:
			return new Color(237,207,114);
		case 256:

		case 512:

		case 1024:

		case 2048:

		case 4096:

		default:
			return new Color(238,228,218);
		}
	}


}
