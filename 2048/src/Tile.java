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
		
		number = 2;
		
	}
	
	public Tile (int x, int y) {
		this(x,y,0);
	}

	public void render(Graphics g) {
		g.setColor(getColor());
		g.fillRect(x, y, TILE_LENGTH, TILE_LENGTH);
		if(number != 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font(null, 0, 40));
			g.drawString("" + number, x + 10, y+TILE_LENGTH/2);
		}
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, TILE_LENGTH, TILE_LENGTH);
	}

	private Color getColor() {
		switch(number) {
		case 2: 
			return new Color(237,207,114);
		default:
			return new Color(238,228,218);
		}
	}
	

}
