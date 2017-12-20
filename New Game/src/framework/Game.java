package framework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import gameObjects.Block;
import gameObjects.GameObject;
import gameObjects.Handler;
import gameObjects.ID;
import gameObjects.Player;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -3307397034749894482L;

	Thread thread;
	boolean running = false;
	
	public static int WIDTH = 840, HEIGHT = WIDTH / 12 * 9;
	
	private Handler handler;
	private Camera cam;
	
	private BufferedImage level;
	
	private Game() {
		new Window(WIDTH, HEIGHT, "Game", this);
		
		handler = new Handler();
		cam = new Camera(-1000, 0);
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/level.png");
		
		loadLevel(level);
		
		this.addKeyListener(new KeyInput(handler));
	}

	public static void main(String[] args) {
		new Game();
	}

	public synchronized void start() {
		if(!running) {
			thread = new Thread(this);
			thread.start();
			running = true;
		}else
			return;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		/////////////////////////////////////////////////////
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g2d.translate(cam.getX(), cam.getY());//camera
		handler.render(g);
		
		g2d.translate(-cam.getX(), -cam.getY());//camera
		/////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public void tick() {
		handler.tick();
		for(GameObject object : handler.object)
			if(object.getID() == ID.Player) {
				cam.tick(object);
			}
	}
	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
        	long now = System.nanoTime();
        	delta += (now - lastTime) / ns;
        	lastTime = now;
        	while(delta >=1) {
        		tick();
        		delta--;
        	}
        	if(running) {
        		render();
        	}
        	frames++;
        	if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: "+ frames);
				frames = 0;
        	}
        }
        stop();
	}
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		//System.out.println(w + ", " + h);
		
		for(int xx = 0; xx < h; xx++) {
			for(int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16 ) & 0xff;
				int green = (pixel >> 8 ) & 0xff;
				int blue = (pixel) & 0xff;
				//if statements determining object:
				if(red == 255 && green == 255 & blue == 255) {
					handler.addObject(new Block(xx*32, yy*32, ID.Block));
				}
				if(red == 0 && green == 0 & blue == 255) {
					handler.addObject(new Player(xx*32, yy*32, ID.Player));
				}
			}
		}
	}
}
