import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JDialog;
import javax.swing.JTextField;

public class Game extends Canvas implements Runnable, Constants, ActionListener{

	private static final long serialVersionUID = 150789955774302817L;
	
	public static int numRow = NUM_ROW, numCol = NUM_COL, numMines = NUM_MINES, 
			gameHeight = GAME_HEIGHT, gameWidth = GAME_WIDTH;
	
	private Thread thread;
	private boolean running;
	
	private Board board;
	private Window window;
	
	public Game() {
		window = new Window("MineSweeper", gameWidth, gameHeight, this);
		board = new Board(numRow, numCol, numMines);
//		String s = (String)JOptionPane.showInputDialog(
//				window.getFrame(),
//				"numROws",
//				"rows",
//				JOptionPane.PLAIN_MESSAGE,
//				null,
//				null,"10");
		
		JDialog jd = new JDialog(window.getFrame(),"Set board size.");
		jd.setSize(300,300);
		jd.setLocationRelativeTo(null);
//		JTextField jtf = new JTextField("thei");
//		jtf.
//		jd.add();
		jd.setVisible(true);
		window.getMenuBar().getMenu(0).getItem(0).addActionListener(this);
		
		addMouseListener(new MouseHandler(window, board));
		
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
		g.fillRect(0, 0, gameWidth, gameHeight);
		
		board.render(g);
		
		//Mines Counter
		g.setColor(Color.BLACK);
		g.fillRect(0, gameHeight - UI_DIS, 135, UI_DIS);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font(null, 0, 20));
		g.drawString("Mines Left:  ", 0,gameHeight - 10);
		g.setColor(Color.RED);;
		g.drawString(" "+ (numMines - board.getNumFlags()), 100, gameHeight - 10);
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

	public void actionPerformed(ActionEvent e) {
		System.out.println("NewGame");
		board = new Board(numRow, numCol, numMines);
		addMouseListener(new MouseHandler(window, board));
	}
	
}
