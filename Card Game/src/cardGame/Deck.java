package cardGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Deck implements Constants{

	private int x,y;
	private boolean stackable;
	
	public ArrayList<Card> deck;
	
	public Deck(int x, int y, int size, boolean stackable) {
		deck = new ArrayList<>(size);
		this.x = x;
		this.y = y;
		this.stackable = stackable;
	}
	
	public Deck(int x, int y) {
		this(x, y, 10, false);
	}

	public void tick() {
		
		for(int i = 0; i < deck.size(); i++) {
			if(stackable)
				deck.get(i).setY(y+10*i);
			else deck.get(i).setY(y);
		}
		
		if(deck.size()>0) {
			deck.get(deck.size()-1).setTop(true);
		}
		for(int i = 0; i < deck.size(); i ++) {
			deck.get(i).setX(x);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(x, y, DECK_WIDTH, DECK_HEIGHT);
		for(int i = 0; i < deck.size(); i ++) {
			deck.get(i).render(g);
		}
	}
	
	public void addCard(Card c) {
		deck.add(c);
	}
	
	public void addCard(Deck d) {
		deck.addAll(d.deck);
	}
	
	public void removeCard(Card c) {
		deck.remove(c);
	}
	
	public void clear() {
		deck.clear();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x ,y ,DECK_WIDTH, DECK_HEIGHT);
	}
	
	public boolean isEmpty() {
		return deck.isEmpty();
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return ""+deck;
	}
}
