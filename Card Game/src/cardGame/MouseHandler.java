package cardGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter implements Constants {
	
	private Handler handler;
	
	//private Card held;
	private Deck held;
	
	public MouseHandler(Handler handler) {
		this.handler = handler;
		held = handler.held;
	}

	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < handler.decks.length - 1; i++) {
			Deck tempDeck = handler.decks[i];
			//System.out.println(tempDeck);

			if(tempDeck.deck.size() > 0) {
				for(int j = 0; j < tempDeck.deck.size(); j ++) {
					Card tempCard = tempDeck.deck.get(j);
					
					if(tempCard.getBounds().contains(e.getPoint())) {
						held.addCard(tempDeck);
						tempDeck.clear();
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		for(int i = 0; i < handler.decks.length-1; i++) {
			Deck tempDeck = handler.decks[i];

			if(tempDeck.getBounds().contains(e.getPoint())) {
				tempDeck.addCard(held);
				held.clear();
				held.setX(GAME_WIDTH);
			}
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(!held.isEmpty()) {
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
