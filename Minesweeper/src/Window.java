import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Window extends Canvas {

	private static final long serialVersionUID = -8255319694373975038L;

	private JFrame frame;
	private JMenuBar menuBar;
	
	public Window(String name, int width, int height, Game game) {
		frame = new JFrame(name);
		frame.setResizable(false);
		game.setPreferredSize(new Dimension(width, height + 20));
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		// frame.setLocation(1450, 100); //for my second monitor at home.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(addMenu());
		
		frame.setVisible(true);
		game.start();
	}

	public void changeSize(int width, int height) {
		frame.setSize(width, height);
	}

	public JMenuBar addMenu() {
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		JMenuItem restart = new JMenuItem("New Game");

		restart.setActionCommand("restart");

		menu.add(restart);

		menuBar.add(menu);
		return menuBar;
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
