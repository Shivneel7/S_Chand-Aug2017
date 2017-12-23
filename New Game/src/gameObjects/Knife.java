package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import framework.BufferedImageLoader;
import framework.SpriteSheet;

public class Knife extends GameObject {
	
	private SpriteSheet ss;
	private BufferedImage stillRight;
	private BufferedImage stillLeft;
	private BufferedImage hitRight;
	private BufferedImage hitLeft;
	private boolean click = false;
	private boolean right = true;
	private int clickCounter = 0;
	
	public Knife(float x, float y, ID id) {
		super(x, y, id);
		BufferedImageLoader loader = new BufferedImageLoader();
		ss = new SpriteSheet(loader.loadImage("/spriteSheet.png"));
		stillRight = ss.grabImage(2, 1, 16, 16);
		stillLeft = ss.grabImage(3, 1, 16, 16);
		hitRight = ss.grabImage(1, 2, 32, 16);
		hitLeft = ss.grabImage(1, 3, 32, 16);
		
	}

	public void tick(LinkedList<GameObject> objects) {
		if(click) {
			clickCounter++;
		}
		if(clickCounter > 10) {
			click = false;
			clickCounter = 0;
		}
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).getID() == ID.Player) {
				if(((Player)objects.get(i)).getDirection()<0) {
					right = false;
					if(((Player)objects.get(i)).hasKnife() && id == ID.PlayerKnife) {
					}
				}else right = true;
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		if(click && right) {
			g.drawImage(hitRight, (int) x, (int) y + 20, 72, 48, null);
		}else if(!click && right){
			g.drawImage(stillRight, (int) x, (int) y, 48, 48, null);
		}else if(click && ! right) {
			g.drawImage(hitLeft, (int) x - 45, (int) y + 20, 72, 48, null);
		}else {
			g.drawImage(stillLeft, (int) x- PLAYER_WIDTH, (int) y, 48, 48, null);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
	}
	
	public void setClick(boolean click) {
		this.click = click;
	}
	
	public boolean getClick() {
		return click;
	}
	
	public Rectangle getBounds() {
		if(this.id == ID.Knife) {
			return new Rectangle((int) x, (int) y, 48, 48);
		}else if(click && right) {
			return new Rectangle((int) x+ 7, (int) y+23, 55, 20);
		}else if(!click && right){
			return new Rectangle((int) x, (int) y +  28, 12, 12);
		}else if(click && ! right) {
			return new Rectangle((int) x - 45, (int) y+25, 55, 20);
		}else {
			return new Rectangle((int) x, (int) y +  26, 12, 12);
		}

	}
	
}
