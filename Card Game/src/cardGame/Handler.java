package cardGame;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;


public class Handler implements Constants {
	
	Deck[] decks = new Deck[13];
	
	Deck stock;
	Deck wastePile;
	Deck[] tableau;
	Deck[] foundations;
	Random r;
	
	public LinkedList<Card> cards = new LinkedList<Card>();
	Card heldCard;
	
	public Handler() {
		r = new Random();
		
		for(int i = 1; i <= 13; i ++) {
			cards.add(new Card(0, 0, "Spades", i));
		}
		for(int i = 1; i <= 13; i ++) {
			cards.add(new Card(0, 0, "Hearts", i));
		}
		for(int i = 1; i <= 13; i ++) {
			cards.add(new Card(0, 0, "Clubs", i));
		}
		for(int i = 1; i <= 13; i ++) {
			cards.add(new Card(0, 0, "Diamonds", i));
		}
		
		makeBoard();
		
		for(int i = 0; i < 7; i ++) {
			for(int j = 0; j < tableau[i].deck.size(); j++) {
				cards.add(tableau[i].deck.get(j));
			}
		}
		for(int i = 0; i < stock.deck.size(); i ++) {
			cards.add(stock.deck.get(i));
		}
	}
	
	public void makeBoard() {
		tableau = new Deck[7];
		int numCards = 52;
		for(int i = 0; i < tableau.length; i ++) {
			tableau[i] = new Deck((SPACE * (i+2)) + DECK_WIDTH * i , SPACE * 2 + DECK_HEIGHT, i+1, true);
			for(int j = 0; j <= i; j++) {
				Card temp = cards.get(r.nextInt(numCards));
				tableau[i].addCard(temp);
				decks[i+6] = tableau[i];
				temp.setX((SPACE * (i+2)) + DECK_WIDTH * i);
				temp.setY((SPACE * 2 + DECK_HEIGHT));
				cards.remove(temp);
				numCards--;
			}
		}
		
		stock = new Deck(SPACE,SPACE, 24, false);
		decks[0] = stock;
		for(int i = 0; i < 24; i++) {
			Card temp = cards.get(r.nextInt(cards.size()));
			stock.addCard(temp);
			temp.setX((SPACE));
			temp.setY((SPACE));
			cards.remove(temp);
		}
		
		wastePile = new Deck(SPACE * 2 + DECK_WIDTH,SPACE);
		decks[1] = wastePile;
		
		foundations = new Deck[4];
		for(int i = 0; i < foundations.length; i ++) {
			foundations[i] = new Deck((SPACE * (i + 5)) + DECK_WIDTH * (i + 3), SPACE, 13, false);
			decks[i+2] = foundations[i];
		}
	}
	
	public void tick() {
		for(Deck d: decks) {
			d.tick();
		}
	}
	
	public void render(Graphics g) {
		for(Deck d: decks) {
			d.render(g);
		}
		if(heldCard != null) {
			heldCard.render(g);
		}
	}
	
	public void addCard(Card c) {
		heldCard = c;
	}
	
	public void removeCard(Card c) {
		heldCard = null;
	}
	
	public void bringToFront(Card c) {
		this.cards.remove(c);
		this.cards.add(c);
	}
}
