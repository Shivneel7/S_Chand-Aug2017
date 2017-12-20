package gameObjects;

import java.awt.Graphics;
import java.util.LinkedList;

import framework.Game;

public class Handler {
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).tick(objects);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
	
	public void createLevel() {
		for(int i = 0; i < Game.WIDTH * 7; i+=32) {
			addObject(new Block(i, Game.HEIGHT-32,ID.Block));
		}
	}
}
