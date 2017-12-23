package gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import framework.BufferedImageLoader;
import framework.SpriteSheet;

public class Knife extends GameObject {
	
	private SpriteSheet ss;
	private BufferedImage img;
	private BufferedImage img2;
	private BufferedImage img3;
	private BufferedImage img4;
	private boolean click = false;
	private boolean right = true;
	private int counter = 0;
	
	public Knife(float x, float y, ID id) {
		super(x, y, id);
		BufferedImageLoader loader = new BufferedImageLoader();
		ss = new SpriteSheet(loader.loadImage("/spriteSheet.png"));
		img = ss.grabImage(2, 1, 16, 16);
		img2 = ss.grabImage(3, 1, 32, 16);
		img3 = ss.grabImage(1, 2, 32, 16);
		img4 = ss.grabImage(2, 3, 32, 16);
		
	}

	public void tick(LinkedList<GameObject> objects) {
		if(click) {
			counter++;
		}
		if(counter > 10) {
			click = false;
			counter = 0;
		}
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).getID() == ID.Player) {
				if(((Player)objects.get(i)).getDirection()<0) {
					right = false;
				}else right = true;
			}
		}
	}

	public void render(Graphics g) {
		if(click && right) {
			g.drawImage(img2, (int) x, (int) y + 20, 72, 48, null);
		}
		else if(!click && right){
			g.drawImage(img, (int) x, (int) y, 48, 48, null);
		}else if(click && !right) {
			g.drawImage(img3, (int) x, (int) y, 48, 48, null);
		}else {
			g.drawImage(img4, (int) x, (int) y, 48, 48, null);
		}
	}
	
	public void setClick(boolean click) {
		this.click = click;
	}
	
	public Rectangle getBounds() {

		return new Rectangle((int) x, (int) y, 48, 48);
	}
	
}
