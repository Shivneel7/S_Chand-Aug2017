package cardGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	
	private DeckHandler handler;
	private Card test;
	
	public MouseHandler(DeckHandler handler) {
		this.handler = handler;
		test = handler.tableau[0].deck.get(handler.tableau[0].deck.size() - 1);
	}
	
	public void mousePressed(MouseEvent e) {
		test.setX(e.getX());
		test.setY(e.getY());
	}
	
	public void mouseReleased(MouseEvent e) {
		test.setX(e.getX());
		test.setY(e.getY());
	}
	
	public void mouseDragged(MouseEvent e) {
		test.setX(e.getX());
		test.setY(e.getY());
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}
	
	//Checks if mouse was in a rectangle
	public boolean getClick(int mx, int my, int x, int y, int width, int height) {
		if(mx < width + x && mx > x && my < height+y && my > y) {
			return true;
		}else return false;
	}
	
}
