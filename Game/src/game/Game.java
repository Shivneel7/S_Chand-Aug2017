package game;

import java.awt.image.BufferStrategy;
import java.awt.*;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 7364682855700581664L;
	
	public static final int WIDTH = 800, HEIGHT = WIDTH/12*9;
	
	private Thread thread;
	private boolean running = false;
	
	private Camera cam;
	
	private Handler handler;
	
	private void init() {
		handler = new Handler();
		
		cam = new Camera(0,0);
		
//		this.addMouseMotionListener(new MouseInput(handler));
//		this.addMouseListener(new MouseInput(handler));
//		this.addMouseWheelListener(new MouseInput(handler));
		
		this.addKeyListener(new KeyInput(handler));
		
		handler.addObject(new Player(20 , HEIGHT - 72, ID.Player));
		handler.createLevel();

	}
	
	public static void main(String[] args) {
		new Window(WIDTH, HEIGHT, "Game", new Game());
	}

	public synchronized void start() {
		if(running) {
			return;
		}
		
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
		init();
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
	
	public void tick() {
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getID() == ID.Player) {
				cam.tick(handler.object.get(i));
			}
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

		g2d.translate(cam.getX(), cam.getY());
		
		handler.render(g);
		
		g2d.translate(-cam.getX(), -cam.getY());
		/////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
}