import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Tile implements Constants{

	private int power = 5;
	private int x, y;
	private Color c;
	
	private Random r = new Random();

	public Tile(int x, int y, boolean blank) {
		this.x = x;
		this.y = y;
		
		//c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
		if (!blank) {
			if (r.nextBoolean()) {
				power = 1;
			} else {
				power = 2;
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.lightGray);
		g.drawRect(x, y, TILE_LENGTH, TILE_LENGTH);
		if(power != 0) {
			g.setFont(new Font(null, 0, 40));
			g.drawString(""+(exponent(power)), x + 10, y+TILE_LENGTH/2);
		}
		
	}
	
	public int exponent(int power) {
		int product = 2;
		for(int i = 1; i < power; i++) {
			product *= 2;
		}
		return product;
		
	}

}
