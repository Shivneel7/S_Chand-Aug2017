import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends Canvas {

	private static final long serialVersionUID = -8255319694373975038L;
	
	private JFrame frame;
	
	public Window(String name, int width, int height, Game game) {
		frame = new JFrame(name);
		frame.setResizable(true);
		game.setPreferredSize(new Dimension(width, height));
		frame.add(game);
		frame.pack();
		frame.setLocationRelativeTo(null);
		//frame.setLocation(1450, 100); //for my second monitor at home.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setJMenuBar(addMenu());
		JMenuBar j = new JMenuBar();
		j.add(new JMenu("test").add(new JMenuItem("test")));
		frame.setJMenuBar(j);
		frame.setVisible(true);
		game.start();
	}
	
	public void changeSize(int width, int height) {
		frame.setSize(width, height);
	}
	
	//add Menu;
}
