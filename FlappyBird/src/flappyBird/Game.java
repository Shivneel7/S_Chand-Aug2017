package flappyBird;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -3060582566322707434L;

	private int WIDTH = 600, HEIGHT = 400, SPEED = 1;
	
	private Thread thread;
	private boolean running = false;
	
	Background background1= new Background(0, SPEED);
	Background background2 = new Background(WIDTH, SPEED);

	static Bird bird = new Bird(40, 280);
	
	public Game() {
		new Window(WIDTH, HEIGHT, "Flappy Bird" , this);

		this.addKeyListener(new KeyInput());
	}
	
	public static void main(String[] args) {
		new Game();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running  = true;
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
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		updateBackground(g);
		
		g.dispose();
		bs.show();
	}
	
	public void updateBackground(Graphics g) {
		background1.render(g);
		background2.render(g);
		bird.render(g);
	}

	public void tick() {
		background1.tick();
		background2.tick();
		bird.tick();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var > max) {
			return max;
		}else if(var < min) {
			return min;
		}else {
			return var;
		}
	}
}
