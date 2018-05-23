import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Game extends Canvas implements Runnable, Constants, ActionListener {

	private static final long serialVersionUID = 150789955774302817L;

	public static int numRow = NUM_ROW, numCol = NUM_COL, numMines = NUM_MINES, gameHeight = GAME_HEIGHT,
			gameWidth = GAME_WIDTH;

	private Thread thread;
	private boolean running;

	private Board board;
	private Window window;

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
			g.drawString("Mines Left:  ", 0, gameHeight - 10);
			g.setColor(Color.RED);
			g.drawString(" " + (numMines - board.getNumFlags()), 100, gameHeight - 10);
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

	public static int clamp(int x, int min, int max) {
		if (x < min) {
			return min;
		} else if (x > max) {
			return max;
		}
		return x;
	}

	public void actionPerformed(ActionEvent e) {
		resetBoard();
	}

	public void resetBoard() {
		window.setVisibility(false);
		String[] options = { "10x10", "15x15", "15x30", "Custom" };
		int option = JOptionPane.showOptionDialog(window.getFrame(), "Select difficulty", "Options", JOptionPane.DEFAULT_OPTION,
				JOptionPane.DEFAULT_OPTION, null, options, "10");
		if (option == 0) {
			numRow = 10;
			numCol = 10;
			numMines = 15;
		} else if (option == 1) {
			numRow = 15;
			numCol = 15;
			numMines = 30;
		} else if (option == 2) {
			numRow = 15;
			numCol = 30;
			numMines = 99;
		} else if (option == 3) {
			Object tempRow = JOptionPane.showInputDialog(window.getFrame(), "How many rows?\nPlease enter a digit.", "Options",
				JOptionPane.DEFAULT_OPTION, null, null, "10");
			if(tempRow != null) {
				numRow = Integer.parseInt(tempRow.toString());
			}
			Object tempCol = JOptionPane.showInputDialog(window.getFrame(), "How many columns?\nPlease enter a digit.", "Options",
					JOptionPane.DEFAULT_OPTION, null, null, "10");
			if(tempCol != null) {
				numCol = Integer.parseInt(tempCol.toString());
			}
			Object tempMines = JOptionPane.showInputDialog(window.getFrame(), "How many mines?\nPlease enter a digit.","Options",
					JOptionPane.PLAIN_MESSAGE, null, null, "10");
			if(tempMines != null) {
				numMines = clamp(Integer.parseInt(tempMines.toString()),0,numRow*numCol);
			}
		}
		gameHeight = numRow * TILE_LENGTH + UI_DIS;
		gameWidth = numCol * TILE_LENGTH;
		
		window.changeSize(new Dimension(gameWidth, gameHeight), this);
		window.setVisibility(true);
		
		board = new Board(numRow, numCol, numMines);
		addMouseListener(new MouseHandler(window, board));
	}
	
	public static double clamp(double x, double min, double max) {
		if(x < min) {
			return min;
		}else if(x>max) {
			return max;
		}else {
			return x;
		}
	}
}
