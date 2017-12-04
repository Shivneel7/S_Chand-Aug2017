package flappyBird;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas{
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(game);
		game.start();
		game.requestFocus();
	}
	
	
}
