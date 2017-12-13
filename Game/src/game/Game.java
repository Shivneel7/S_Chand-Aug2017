package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.*;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 7364682855700581664L;
	
	private static final int WIDTH = 600, HEIGHT = WIDTH/12*9;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Game() {
		handler = new Handler();
		new Window(WIDTH, HEIGHT, "Game", this);
		
//		this.addMouseMotionListener(new MouseInput(handler));
//		this.addMouseListener(new MouseInput(handler));
//		this.addMouseWheelListener(new MouseInput(handler));
		
		this.addKeyListener(new KeyInput(handler));
		
		handler.addObject(new Player(20 , HEIGHT - 72, ID.Player));

	}
	
	public static void main(String[] args) {
		new Game();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
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
        		//System.out.println("tick");
        		delta--;
        	}
        	if(running) {
        		render();
        		//System.out.println("render");
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
	
	public void tick() {
		handler.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH - 16, HEIGHT - 39);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
}