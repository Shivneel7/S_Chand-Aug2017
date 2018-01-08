package cardGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter implements Constants {
	
	private Deck[] decks;
	private Deck held;
	private Deck stock;
	private Deck wastePile;
	
	public MouseHandler(Handler handler) {
		decks = handler.getDecks();
		held = decks[13];
		stock = decks[0];
		wastePile = decks[1];
	}

	public void mousePressed(MouseEvent e) {
		if(stock.getBounds().contains(e.getPoint())) {
			for(int i = 0; i < 3; i++) {
				if(stock.deck.size() >0) {
					wastePile.addCard(stock.getTopCard());
				}
			}
		}else if(wastePile.getBounds().contains(e.getPoint())){
			held.addCard(wastePile.getTopCard());
			
		}else {
			for(int i = 0; i < decks.length - 1; i++) {
				Deck tempDeck = decks[i];
				
				if(tempDeck.deck.size() > 0 && tempDeck.getID() != DeckID.FOUNDATION && tempDeck.getID() != DeckID.HELD) {
					for(int j = 0; j < tempDeck.deck.size(); j ++) {
						Card tempCard = tempDeck.deck.get(j);

						if(tempCard.getBounds().contains(e.getPoint())) {
							Card.held = true;
							held.addCard(tempDeck.getTopCard());
							held.setX(e.getX()- CARD_WIDTH/2);
							held.setY(e.getY());
						}
					}
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		for(int i = 0; i < decks.length-1; i++) {
			Deck tempDeck = decks[i];

			if(tempDeck.getBounds().contains(e.getPoint())) {
				tempDeck.addCard(held);
				held.clear();
				Card.held = false;
				held.setX(GAME_WIDTH);
			}
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(!held.isEmpty()) {
			held.setX(e.getX()- CARD_WIDTH/2);
			held.setY(e.getY());
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
