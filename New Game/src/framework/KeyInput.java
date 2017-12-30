package framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameObjects.Handler;
import gameObjects.Player;

public class KeyInput implements KeyListener, Constants {

	Handler handler;
	Player player;
	boolean[] keyDown = new boolean[2];


	public KeyInput(Handler handler) {
		this.handler = handler;
		for(int i = 0; i < keyDown.length;i++) {
			keyDown[i] = false;
		}
		player = handler.player;
	}

	public void keyPressed(KeyEvent e) {

		//		if(e.getKeyCode() == KeyEvent.VK_M) {
		//			try {
		//				BufferedWriter bw = new BufferedWriter(new FileWriter("res/lev.txt"));
		//				bw.write("" + Handler.LEVEL);
		//				System.out.println("saved");
		//				bw.close();
		//			} catch (IOException e1) {
		//				e1.printStackTrace();
		//			}
		//		}

			if(e.getKeyCode() == KeyEvent.VK_W && !player.isJumping()) {
				player.setDy(JUMP_HEIGHT);
				player.setJumping(true);
			}

			if(e.getModifiers() == 1) { // shift =1, ctrl = 2, alt = 8
				if(e.getKeyCode() == KeyEvent.VK_A) {
					player.setDx(-2);
					player.setDirection(-1);
					keyDown[0] = true;
				}
				
				if(e.getKeyCode() == KeyEvent.VK_D) {
					player.setDx(2);
					player.setDirection(1);
					keyDown[1] = true;
				}
				
			}else if(e.getKeyCode() == KeyEvent.VK_A) {
				player.setDx(-5);
				player.setDirection(-1);
				keyDown[0] = true;
				
			}else if(e.getKeyCode() == KeyEvent.VK_D) {
				player.setDx(5);
				player.setDirection(1);
				keyDown[1] = true;

		}
	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_A) {
			keyDown[0] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			keyDown[1] = false;
		}
		if(!keyDown[0] && !keyDown[1]) {
			player.setDx(0);
		}
	}

	public void keyTyped(KeyEvent e) {

	}
	
}
