package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.Constants;

public class Gun extends GameObject implements Constants {

	public Gun(float x, float y, ID id) {
		super(x, y, id);

	}


	public void tick(LinkedList<GameObject> objects) {

	}


	public void render(Graphics g) {


	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 10,10);
	}

}
