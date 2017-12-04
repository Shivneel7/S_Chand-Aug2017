package flappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_UP) {
			Game.bird.jump();
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
	
}
