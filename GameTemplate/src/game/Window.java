package game;

import java.awt.Dimension;

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
		frame.setVisible(true);
		game.start();
	}
	
}
