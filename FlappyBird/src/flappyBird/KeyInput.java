package flappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	Bird bird;
	
	public KeyInput(Bird bird) {
		this.bird = bird;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SPACE) {
			bird.jump();
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
	
}
