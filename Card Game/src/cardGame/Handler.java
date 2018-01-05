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
		makeBoard();
		for(int i = 0; i < 13; i++) {
			Card temp = new Card(SPACE, SPACE,  "Spades", i + 1);
			cards.add(temp);
			stock.addCard(temp);
		}
		for(int i = 0; i < 13; i++) {
			Card temp = new Card(SPACE, SPACE,  "Clubs", i + 1);
			cards.add(temp);
			stock.addCard(temp);
		}
		for(int i = 0; i < 13; i++) {
			Card temp = new Card(SPACE, SPACE,  "Hearts", i + 1);
			cards.add(temp);
			stock.addCard(temp);
		}
		for(int i = 0; i < 13; i++) {
			Card temp = new Card(SPACE, SPACE,  "Diamonds", i + 1);
			cards.add(temp);
			stock.addCard(temp);
		}
	}
	
	public void makeBoard() {
		stock = new Deck(SPACE,SPACE, 52);
		wastePile = new Deck(SPACE * 2 + DECK_WIDTH,SPACE);
		
		foundations = new Deck[4];
		for(int i = 0; i < foundations.length; i ++) {
			foundations[i] = new Deck((SPACE * (i + 5)) + DECK_WIDTH * (i + 3), SPACE, 13);
		}
		
		tableau = new Deck[7];
		for(int i = 0; i < tableau.length; i ++) {
			tableau[i] = new Deck((SPACE * (i+2)) + DECK_WIDTH * i , SPACE * 2 + DECK_HEIGHT, i+1);
//			tableau[i].addCard(new Card((SPACE * (i+2)) + DECK_WIDTH * i, SPACE * 2 + DECK_HEIGHT
//					, "Spades", 2));
		}
	}
	
	public void tick() {
		stock.tick();
		wastePile.tick();
		
		for(Deck d:  foundations) {
			d.tick();
		}
		
		for(Deck d:  tableau) {
			d.tick();
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