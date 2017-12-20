package framework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import gameObjects.*;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -3307397034749894482L;

	Thread thread;
	boolean running = false;
	
	public static int WIDTH = 720, HEIGHT = WIDTH / 12 * 9;
	
	private Handler handler;

	private Camera cam;
	
	private Game() {
		new Window(WIDTH, HEIGHT, "Untitled", this);
		
		handler = new Handler();
		cam = new Camera( 0, 0);
		
		handler.createLevel();
		handler.addObject(new Player(10, 10, ID.Player));
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
				System.out.println("FPS: "+ frames);
				frames = 0;
        	}
        }
        stop();
	}
}
