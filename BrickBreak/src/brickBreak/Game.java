package brickBreak;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -3060582566322707434L;

	public static final int WIDTH = 1600, HEIGHT = 900, PADDLE_WIDTH = 400, PADDLE_THICC = 20, BALL_RAD = 30;

	private Thread thread;
	private boolean running = false;

	private Paddle paddle; // = new Bird(40, 280, obstacle, this);
	private Ball ball;


	public Game() {
		// menu = new Menu(this);

		// this.addMouseListener(menu);
		// this.addMouseMotionListener(menu);

		new Window(WIDTH, HEIGHT, "Shiv's Shitty Shirtless Shindig", this);
		paddle = new Paddle(WIDTH, HEIGHT, PADDLE_THICC, PADDLE_WIDTH);
		this.addKeyListener(paddle);
		ball = new Ball(WIDTH, BALL_RAD, HEIGHT, paddle);
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
		} catch (Exception e) {
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
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		//////////////////////////////
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		paddle.render(g);
		ball.render(g);

		/////////////////////////////////
		g.dispose();
		bs.show();
	}

	public void tick() {
		paddle.tick();
		ball.tick();
	}

}
