package game;

import java.awt.Canvas;
import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -3433977395782317401L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setSize(width , height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.add(game);
		game.start();
	}
	
}
