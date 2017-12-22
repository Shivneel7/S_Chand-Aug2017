package gameObjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import framework.BufferedImageLoader;
import framework.HUD;
/**
 * Handles all GameObjects and creates and keeps track of levels.
 * 
 *
 */
public class Handler {
	public static int LEVEL = 0;
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();
	private BufferedImage[] levels = new BufferedImage[3];
	private HUD hud;
	
	public Handler(HUD hud) {
		this.hud = hud;
		
		BufferedImageLoader loader = new BufferedImageLoader();

		for(int i = 0; i < levels.length; i++) {
			levels[i] = loader.loadImage("/level"+ (i + 1) +".png");
		}
		
	}
	
	public void tick() {
		if(hud.getLives() == 0) {
			hud.resetLives();
			switchLevel();
		}
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).tick(objects);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}
	}
	
	public void switchLevel() {
		clearLevel();
		loadLevel(levels[LEVEL]);
	}
	
	
	private void clearLevel() {
		objects.clear();
	}
	
	public void addObject(GameObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.objects.remove(object);
	}
	
	public void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		//System.out.println(w + ", " + h);
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16 ) & 0xff;
				int green = (pixel >> 8 ) & 0xff;
				int blue = (pixel) & 0xff;
				//if statements determining objects:
				if(red == 255 && green == 255 & blue == 255) {
					addObject(new Block(xx*32, yy*32, ID.Block));
				}
				if(red == 0 && green == 0 & blue == 255) {
					addObject(new Player(xx*32, yy*32, ID.Player, this, hud));
				}
				if(red == 255 && green == 0 & blue == 0) {
					addObject(new DeathBlock(xx*32, yy*32, ID.DeathBlock));
				}
				if(red == 0 && green == 255 & blue == 0) {
					addObject(new Goal(xx*32, yy*32, ID.Goal));
				}
				if(red == 127 && green == 127 & blue == 127) {
					addObject(new TransparentBlock(xx*32, yy*32, ID.TransparentBlock));
				}
				if(red == 255 && green == 255 & blue == 0) {
					addObject(new Enemy(xx*32, yy*32, ID.Enemy, -2));
				}
			}
		}
	}
}
