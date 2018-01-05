package cardGame;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter implements Constants {
	
	private Handler handler;
	private Card card;
	
	public MouseHandler(Handler handler) {
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < handler.cards.size(); i ++) {
			if(handler.cards.get(i).getBounds().contains(e.getPoint())) {
				card = handler.cards.get(i);
				handler.bringToFront(card);
				card.reveal();
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(handler.tableau[0].getBounds().contains(e.getPoint())) {
			card.setX(handler.tableau[0].getX());
			card.setY(handler.tableau[0].getY());
			handler.tableau[0].addCard(card);
		}
		card = null;
	}

	public void mouseDragged(MouseEvent e) {
		if(card != null) {
			card.setX(e.getX() - DECK_WIDTH/2);
			card.setY(e.getY() - DECK_HEIGHT/2);
		}
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
