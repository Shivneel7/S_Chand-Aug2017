import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable, ActionListener, KeyListener {
	private static final long serialVersionUID = 7364682855700581664L;

	public static final int WIDTH = 1200, HEIGHT = WIDTH / 12 * 9;

	public static int numRow = 20;

	public static int numCol = 20;

	public static int numMines = 77;

	public Board board;

	private Thread thread;
	private boolean running = false;
	private long startTime = 0, endTime = 0, seconds = 0;;
	Window window;

	public Game() {
		window = new Window(WIDTH, HEIGHT, "Game", this);
		this.addKeyListener(this);
		resetBoard();
	}

	public void resetBoard() {
		board = new Board(numRow, numCol, numMines, this);
		for (MouseListener m : getMouseListeners()) {
			this.removeMouseListener(m);
		}
		addMouseListener(new MouseHandler(window, board));
		startTime = 0;
		endTime = 0;
		seconds = 0;
	}

	public void actionPerformed(ActionEvent e) {
		resetBoard();
	}

	public static void main(String[] args) {
		new Game();
	}

	public synchronized void start() {
		if (running) {
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
		} catch (Exception e) {
			e.printStackTrace();
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

	public void tick() {
		if (board != null) {
			board.tick();
			seconds = (System.currentTimeMillis() - startTime) / 1000;
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		/////////////////////////////////////////////////////
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		board.render(g);

		g.setFont(new Font(null, 0, 50));
		g.setColor(Color.WHITE);

		if (endTime != 0) {
			g.drawString("" + endTime + " seconds", 10, HEIGHT - 60);
		} else if (startTime != 0) {
			g.drawString("Timer: " + seconds + " seconds", 10, HEIGHT - 60);
		}
		g.drawString("Mines Left: " + (numMines - board.getNumFlags()), 10, HEIGHT - 120);
		/////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}

	public static int clamp(int x, int min, int max) {
		if (x < min) {
			return min;
		} else if (x > max) {
			return max;
		}
		return x;
	}

	public void errorMessage() {
		endTime = (System.currentTimeMillis() - startTime) / 1000;

		JOptionPane.showMessageDialog(null, "Mines not correcty flagged\nPlease Try Again.", "Flags Incorrect",
				JOptionPane.ERROR_MESSAGE);
	}

	public void win() {
		endTime = (System.currentTimeMillis() - startTime) / 1000;
		JOptionPane.showMessageDialog(null, "You won. I fucking hate you zee you stupid cunt");
	}

	public void startTimer() {
		if (startTime == 0)
			startTime = System.currentTimeMillis();
	}

	public void lose() {
		endTime = (System.currentTimeMillis() - startTime) / 1000;
		JOptionPane.showMessageDialog(null, "You fucking lose kid. Get good. LMAO. TRASH KID", "L",
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 82 || e.getKeyCode() == 32){
			resetBoard();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}