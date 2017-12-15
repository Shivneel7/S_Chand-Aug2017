package game;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window{

	public Window(int w, int h, String title, Game game) {
		JFrame frame = new JFrame(title);

		game.setPreferredSize(new Dimension(w,h));
		frame.add(game);
		frame.pack(); //frame.setSize(w,h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}
	
}
