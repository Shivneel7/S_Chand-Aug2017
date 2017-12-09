package flappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import flappyBird.Game.STATE;

public class KeyInput implements KeyListener {

	Bird bird;
	Game game;
	
	public KeyInput(Bird bird, Game game) {
		this.bird = bird;
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SPACE) {
			bird.jump();
		}
		if(e.getKeyCode() == e.VK_ESCAPE) {
			if(game.gameState == STATE.Game){
				game.gameState = STATE.Paused;
				game.stopBackground();
			}else if(game.gameState == STATE.Paused) {
				game.gameState = STATE.Game;
				game.restartBackground();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
	
}
