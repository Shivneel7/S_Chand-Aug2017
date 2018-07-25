import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable, Constants, ActionListener {

	private static final long serialVersionUID = 150789955774302817L;

	public static int numRow = NUM_ROW, numCol = NUM_COL, numMines = NUM_MINES, gameHeight = GAME_HEIGHT,
			gameWidth = GAME_WIDTH;

	public boolean loss = false;

	private Thread thread;
	private boolean running;

	private Board board;
	private Window window;

	private long startTime, lossTime;

	public Game() {
		window = new Window("MineSweeper", 0, 0, this);
		resetBoard();
		window.getMenuBar().getMenu(0).getItem(0).addActionListener(this);
	}

	public static void main(String[] args) {
		new Game();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////////////////////////
		if (board != null) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, gameWidth, gameHeight);

			board.render(g);

			// Mines Counter
			g.setColor(Color.BLACK);
			g.fillRect(0, gameHeight - UI_DIS, gameWidth, UI_DIS);

			g.setColor(Color.WHITE);
			g.setFont(new Font(null, 0, 20));
			g.drawString("Mines Left:", 10, gameHeight - 40);
			g.setColor(Color.RED);
			g.drawString(" " + (numMines - board.getNumFlags()), 110, gameHeight - 40);

			// Timer

			long seconds = (System.currentTimeMillis() - startTime) / 1000;

			g.setColor(Color.WHITE);
			g.drawString("Timer: ", 10, gameHeight - 10);
			g.setColor(Color.RED);
			if (loss) {
				g.drawString("" + lossTime, 70, gameHeight - 10);
				g.setColor(Color.black);
				g.setFont(new Font(null, 0, 40));
				g.drawString("you lost.", 0, GAME_HEIGHT - UI_DIS);
			} else {
				g.drawString("" + seconds, 70, gameHeight - 10);
			}

		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, gameWidth, gameHeight);

		}
		/////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}

	private void tick() {
		if (board != null) {
			board.tick();
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
				// System.out.println("FPS: "+ frames);
				frames = 0;
			}
		}
		stop();
	}

	public synchronized void start() {
		if (!running) {
			thread = new Thread(this);
			thread.start();
			running = true;
		} else
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

	public void actionPerformed(ActionEvent e) {
		resetBoard();
	}

	public void resetBoard() {
		loss = false;
		window.setVisibility(false);
		String[] options = { "10x10", "15x15", "15x30", "Custom" };
		int option = JOptionPane.showOptionDialog(window.getFrame(), "Select difficulty", "Options",
				JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, "10");
		if (option == 0) {
			numRow = 10;
			numCol = 10;
			numMines = 15;
		} else if (option == 1) {
			numRow = 15;
			numCol = 15;
			numMines = 45;
		} else if (option == 2) {
			numRow = 15;
			numCol = 30;
			numMines = 99;
		} else if (option == 3) {
			Object tempRow = JOptionPane.showInputDialog(window.getFrame(), "How many rows?\nPlease enter a digit.",
					"Options", JOptionPane.DEFAULT_OPTION, null, null, ""+NUM_ROW);
			if (tempRow != null) {
				numRow = Integer.parseInt(tempRow.toString());
			}
			Object tempCol = JOptionPane.showInputDialog(window.getFrame(), "How many columns?\nPlease enter a digit 7 or greater.",
					"Options", JOptionPane.DEFAULT_OPTION, null, null, ""+NUM_COL);
			if (tempCol != null) {
				numCol = clampMin(Integer.parseInt(tempCol.toString()), 7);
			}
			Object tempMines = JOptionPane.showInputDialog(window.getFrame(), "How many mines?\nPlease enter a digit.",
					"Options", JOptionPane.PLAIN_MESSAGE, null, null, ""+NUM_MINES);
			if (tempMines != null) {
				numMines = clamp(Integer.parseInt(tempMines.toString()), 0, numRow * numCol);
			}
		}
		gameHeight = numRow * TILE_LENGTH + UI_DIS;
		gameWidth = numCol * TILE_LENGTH;

		window.changeSize(new Dimension(gameWidth, gameHeight), this);
		window.setVisibility(true);

		board = new Board(numRow, numCol, numMines, this);
		for (MouseListener m : getMouseListeners()) {
			this.removeMouseListener(m);
		}
		addMouseListener(new MouseHandler(window, board));
		startTime = System.currentTimeMillis();
	}

	public void lose() {
		loss = true;
		lossTime = (System.currentTimeMillis() - startTime) / 1000;
		String[] options = { "Yes", "No", "Back to board" };
		int playAgain = JOptionPane.showOptionDialog(window.getFrame(), "Would you like to play again?", "You Lost",
				JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, null);
		if (playAgain == 0) {
			resetBoard();
		} else if (playAgain == 1) {
			System.exit(0);
		}
	}
	
	public void win() {
		
	}

	public static double clamp(double x, double min, double max) {
		if (x < min) {
			return min;
		} else if (x > max) {
			return max;
		} else {
			return x;
		}
	}

	public static int clamp(int x, int min, int max) {
		if (x < min) {
			return min;
		} else if (x > max) {
			return max;
		}
		return x;
	}
	
	public static int clampMin(int x, int min) {
		if(x<min) {
			return min;
		}
		return x;
	}


}
