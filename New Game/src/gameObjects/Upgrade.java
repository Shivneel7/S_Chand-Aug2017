package gameObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Upgrade extends GameObject {
	
	private int width = 24, height = 24;
	
	public Upgrade(float x, float y, ID id) {
		super(x, y, id);
		
	}

	public void tick(LinkedList<GameObject> objects) {
		if(id == ID.HealthUpgrade) {
			
		}else if(id == ID.AmmoUpgrade) {
			
		}
	}

	public void render(Graphics g) {
		if(id == ID.HealthUpgrade) {
			g.setColor(Color.cyan);
			g.fillRect((int)x, (int) y, width, height);
			g.setColor(Color.darkGray);
			g.setFont(new Font(null, 1, 24));
			g.drawString("H", (int) x + 4, (int) y + 20);
		}else if(id == ID.AmmoUpgrade) {
			g.setColor(Color.cyan);
			g.fillRect((int)x, (int) y, width, height);
			g.setColor(Color.darkGray);
			g.setFont(new Font(null, 1, 24));
			g.drawString("A", (int) x + 4, (int) y + 20);
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}

}
