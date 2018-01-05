package cardGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter implements Constants {
	
	private Handler handler;
	
	private Card held;
	
	public MouseHandler(Handler handler) {
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e) {
		if(held == null) {
			for(int i = 0; i < handler.decks.length; i++) {
				Deck tempDeck = handler.decks[i];
				//System.out.println(tempDeck);
				if(tempDeck.deck.size() > 0) {
					for(int j = 0; j < tempDeck.deck.size(); j ++) {
						if(tempDeck.deck.get(j).getBounds().contains(e.getPoint())) {
							held = handler.decks[i].deck.get(j);
							handler.addCard(held);
							held.reveal();
							tempDeck.removeCard(held);
						}
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(held != null) {
			for(int i = 0; i < handler.decks.length; i++) {
				Deck tempDeck = handler.decks[i];
				if(tempDeck.getBounds().contains(e.getPoint())) {
					held.setX(tempDeck.getX());
					held.setY(tempDeck.getY());
					tempDeck.addCard(held);
				}
			}
			held = null;
		}
		handler.removeCard(held);
	}

	public void mouseDragged(MouseEvent e) {
		if(held != null) {
			held.setX(e.getX() - DECK_WIDTH/2);
			held.setY(e.getY() - DECK_HEIGHT/2);
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
