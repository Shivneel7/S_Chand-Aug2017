package cardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Card implements Constants{
	private int x, y;
	private String suit;
	private int number;
	private boolean revealed;
	
	public Card(int x, int y, String suit, int number) {
		this.x = x;
		this.y = y;
		this.suit = suit;
		this.number = number;
	}
	
	public void render(Graphics g) {
		
		if(revealed) {
			g.setColor(Color.white);
			g.fillRect(x, y, DECK_WIDTH, DECK_HEIGHT);
			if(suit.equals("Spades") || suit.equals("Clubs") ) {
				g.setColor(Color.black);
			}else{
				g.setColor(Color.red);
			}
			g.drawString(""+number, x + 20, y + 50);
		}else {
			g.setColor(Color.black);
			g.fillRect(x, y, DECK_WIDTH, DECK_HEIGHT);
		}
		g.setColor(Color.white);
		g.drawRect(x, y, DECK_WIDTH, DECK_HEIGHT);
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

	public void tick() {
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x ,y ,DECK_WIDTH, DECK_HEIGHT);
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void reveal() {
		revealed = true;
	}
	
}
