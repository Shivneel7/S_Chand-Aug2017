package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Upgrades extends GameObject {
	
	private int width = 16, height = 16;
	
	public Upgrades(float x, float y, ID id) {
		super(x, y, id);
		
	}

	public void tick(LinkedList<GameObject> objects) {
		if(id == ID.HealthUpgrade) {

		}else if(id == ID.AmmoUpgrade) {
			
		}
	}

	public void render(Graphics g) {
		if(id == ID.HealthUpgrade) {

		}else if(id == ID.AmmoUpgrade) {
			
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, width, height);
	}

}
