import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable, Constants{

	private static final long serialVersionUID = 150789955774302817L;
	
	private int numRow = NUM_ROW, numCol = NUM_COL, numMines = NUM_MINES;
	
	private Thread thread;
	private boolean running;
	
	private Board board;
	private Window window;
	
	public Game() {
		
		board = new Board(numRow, numCol, numMines);
		window = new Window("MineSweeper", GAME_WIDTH, GAME_HEIGHT, this);
		
		addMouseListener(new MouseHandler(window, board));
		//addMouseMotionListener(new MouseHandler());
	}
	
	public static void main(String[] args) {
		new Game();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////////////////////////
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		
		board.render(g);
		
		//Mines Counter
		g.setColor(Color.BLACK);
		g.fillRect(0, GAME_HEIGHT - UI_DIS, 135, UI_DIS);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font(null, 0, 20));
		g.drawString("Mines Left:  ", 0,GAME_HEIGHT - 10);
		g.setColor(Color.RED);;
		g.drawString(" "+ (numMines - board.getNumFlags()), 100, GAME_HEIGHT - 10);
		/////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	private void tick() {
		board.tick();
		
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int clamp(int min, int max, int x) {
		if(x<min) {
			return min;
		}else if(x>max) {
			return max;
		}
		return x;
	}
	

}
