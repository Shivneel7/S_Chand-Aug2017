package cardGame;

import java.awt.Color;
import java.awt.Graphics;

public class Card implements Constants{
	private int x, y;
	private String suit;
	private int number;

	public Card(int x, int y, String suit, int number) {
		this.x = x;
		this.y = y;
		this.suit = suit;
		this.number = number;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, DECK_WIDTH, DECK_HEIGHT);
		if(suit.equals("Spades") || suit.equals("Clubs") ) {
			g.setColor(Color.black);
		}
		g.drawString(""+number, x + 20, y + 50);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
