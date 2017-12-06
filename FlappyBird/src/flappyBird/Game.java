package flappyBird;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -3060582566322707434L;

	public static final int WIDTH = 600, HEIGHT = 400;
	
	private static int SPEED = 4;
	
	private Thread thread;
	private boolean running = false;
	
	private Menu menu;
	
	private Background background1 = new Background(0, SPEED);
	private static Background background2 = new Background(WIDTH, SPEED);
	
	private static Pipe obstacle;// = new Pipe(background2);
	
	private static Bird bird; // = new Bird(40, 280, obstacle, this);
	
	public static int score = 0;
	
	public enum STATE{Menu, Game, Loss};
	
	public STATE gameState = STATE.Menu;
	
	public Game() {
		menu = new Menu(this);
		obstacle = new Pipe(background2);
		bird = new Bird(40, 280, obstacle, this);
		
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "Totally not Flappy Bird" , this);
		
		this.addKeyListener(new KeyInput(bird));
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
				//System.out.println("FPS: "+ frames);
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
		if(gameState == STATE.Menu || gameState == STATE.Loss) {
			menu.render(g);
		}else{
			obstacle.render(g);
			bird.render(g);
			g.setColor(Color.white);
			g.drawString("Score: " + score, 10, HEIGHT - 45);
		}

		g.dispose();
		bs.show();
	}
	
	public void updateBackground(Graphics g) {
		background1.render(g);
		background2.render(g);
	}

	public void tick() {
		background1.tick();
		background2.tick();
		if(gameState == STATE.Menu){
			menu.tick();
		}else if(gameState == STATE.Game){
			score++;
			bird.tick();
			obstacle.tick();
		}
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

	public void resetBackground() {
		background1.setX(0);
		background2.setX(WIDTH);
		obstacle.setX(HEIGHT + 100);
	}
}
