import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;

public class Window{

	public Window(int w, int h, String title, Game game) {
		JFrame frame = new JFrame(title);
		frame.setResizable(false);
		game.setPreferredSize(new Dimension(w,h));
		frame.add(game);
		frame.pack(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Options");
		MenuItem mi = new MenuItem("New Game");
		mi.setActionCommand("restart");
		mi.addActionListener(game);
		menu.add(mi);
		menuBar.add(menu);
		frame.setMenuBar(menuBar);


		frame.setVisible(true);
		game.start();
	}
	
}
