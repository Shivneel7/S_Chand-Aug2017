package cardGame;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler implements Constants {
	
	Deck stock;
	Deck wastePile;
	Deck[] tableau;
	Deck[] foundations;
	
	public LinkedList<Card> cards = new LinkedList<Card>();
	
	public Handler() {
		stock = new Deck(SPACE,SPACE);
		wastePile = new Deck(SPACE * 2 + DECK_WIDTH,SPACE);
		
		foundations = new Deck[4];
		for(int i = 0; i < foundations.length; i ++) {
			foundations[i] = new Deck((SPACE * (i + 5)) + DECK_WIDTH * (i + 3), SPACE);
		}
		
		tableau = new Deck[7];
		for(int i = 0; i < tableau.length; i ++) {
			tableau[i] = new Deck((SPACE * (i+2)) + DECK_WIDTH * i , SPACE * 2 + DECK_HEIGHT);
		}
	}
	
	public void tick() {
		for(int i = 0; i < cards.size(); i++) {
			cards.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		stock.render(g);
		wastePile.render(g);
		
		for(Deck d:  foundations) {
			d.render(g);
		}
		
		for(Deck d:  tableau) {
			d.render(g);
		}
		
		for(int i = 0; i < cards.size(); i++) {
			cards.get(i).render(g);
		}
	}
	
	public void addObject(Card c) {
		this.cards.add(c);
	}
	
	public void removeObject(Card c) {
		this.cards.remove(c);
	}
	
	public void bringToFront(Card c) {
		this.cards.remove(c);
		this.cards.add(c);
	}
}
