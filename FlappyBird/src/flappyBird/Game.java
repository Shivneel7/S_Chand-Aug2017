package flappyBird;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -3060582566322707434L;

	public static int backgroundX = 0;
	
	private int WIDTH = 600, HEIGHT = 400;
	
	private Thread thread;
	private boolean running = false;
	
	private Background background1;
	private Background background2;
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Flappy Bird" , this);
		
		this.addKeyListener(new KeyInput());
	}
	
	public static void main(String[] args) {
		new Game();
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
	
	private void tick() {
		backgroundX--;
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		background1 = new Background(g, backgroundX);
		background2 = new Background(g, backgroundX+600);
		if(backgroundX % 600 == 0) {
			backgroundX = 0;
		}
		
		g.dispose();
		bs.show();
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
		running  = true;
	}
	
	public void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
