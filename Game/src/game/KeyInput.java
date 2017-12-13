package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private Audio test = new Audio("/test.wav");
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		for(int i = 0; i < keyDown.length;i++) {
			keyDown[i] = false;
		}
		
	}
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_SPACE) {
			test.play();
		}
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getID() == ID.Player) {
				if(e.getKeyCode() == e.VK_LEFT) {
					temp.setdx(-5);
					keyDown[0] = true;
				}
				if(e.getKeyCode() == e.VK_RIGHT) {
					temp.setdx(5);
					keyDown[1] = true;
				}
				if(e.getKeyCode() == e.VK_UP) {
					temp.setdy(-5);
					keyDown[2] = true;
				}
				if(e.getKeyCode() == e.VK_DOWN) {
					temp.setdy(5);
					keyDown[3] = true;
					
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == e.VK_SPACE) {
			test.stop();
		}
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getID() == ID.Player) {
				if(e.getKeyCode() == e.VK_LEFT) keyDown[0] = false;
				if(e.getKeyCode() == e.VK_RIGHT) keyDown[1] = false;
				if(e.getKeyCode() == e.VK_UP) keyDown[2] = false;
				if(e.getKeyCode() == e.VK_DOWN) keyDown[3] = false;
				
				if(!keyDown[0] && !keyDown[1]) temp.setdx(0);
				if(!keyDown[2] && !keyDown[3]) temp.setdy(0);
			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}
