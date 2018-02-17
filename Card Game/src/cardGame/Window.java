package cardGame;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends Canvas{

	private static final long serialVersionUID = -8255319694373975038L;
	private JMenuBar menuBar;	
	
	public Window(String t, int w, int h, Game game) {
		JFrame frame = new JFrame(t);
		frame.setResizable(false);
		game.setPreferredSize(new Dimension(w,h));
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		//frame.setLocation(1450, 100); //for my second monitor at home.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setJMenuBar(addMenu());
		frame.setVisible(true);
		game.start();
	}

	public JMenuBar addMenu() {
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		JMenuItem restart = new JMenuItem("Restart");
		
		restart.setActionCommand("restart");

		menu.add(restart);
		
		menuBar.add(menu);
		return menuBar;
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
