package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			
			if(temp.getID() == ID.Player) {
				if(e.getKeyCode() == e.VK_LEFT) {
					temp.setdx(-5);
				}
				if(e.getKeyCode() == e.VK_RIGHT) {
					temp.setdx(5);
				}
				if(e.getKeyCode() == e.VK_UP) {
					while(true) {
						if(temp.getY() > 350) {
							temp.setdy(-1);
						}
						temp.setY(400);
					}
				}
//				if(e.getKeyCode() == e.VK_DOWN) {
//					temp.setdy(5);
//				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getID() == ID.Player) {
				if(e.getKeyCode() == e.VK_LEFT) {
					temp.setdx(0);
				}
				if(e.getKeyCode() == e.VK_RIGHT) {
					temp.setdx(0);
				}
				if(e.getKeyCode() == e.VK_UP) {
					temp.setdy(0);
				}
//				if(e.getKeyCode() == e.VK_DOWN) {
//					temp.setdy(0);
//				}
			}
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}
