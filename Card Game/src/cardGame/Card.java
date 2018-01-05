package cardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Card implements Constants{

	private int x, y;
	private String suit;
	private int number;
	private boolean revealed;
	private boolean isTop;
	
	public Card(int x, int y, String suit, int number) {
		this.x = x;
		this.y = y;
		this.suit = suit;
		this.number = number;
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(revealed) {
			g.setColor(Color.white);
			g.fillRect(x, y, DECK_WIDTH, DECK_HEIGHT);
			
			if(suit.equals("Spades")) {
				g.setColor(Color.black);
				g.drawString("Spades"+number, x + 20, y + 10);
				
			}else if(suit.equals("Clubs")){
				g.setColor(Color.black);
				g.drawString("Clubs"+number, x + 20, y + 10);
				
			}else if(suit.equals("Diamonds")) {
				g.setColor(Color.red);
				g.drawString("Diamonds"+number, x + 20, y + 10);
				
			}else {
				g.setColor(Color.red);
				g.drawString("Hearts"+number, x + 20, y + 10);
				
			}
			g.setColor(Color.black);
			g.drawRect(x, y, DECK_WIDTH, DECK_HEIGHT);

		}else {
			g.setColor(Color.black);
			g.fillRect(x, y, DECK_WIDTH, DECK_HEIGHT);
			g.setColor(Color.white);
			g.drawRect(x, y, DECK_WIDTH, DECK_HEIGHT);
		}
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
	
	public Rectangle getBounds() {
		if(isTop)
			return new Rectangle(x ,y ,DECK_WIDTH, DECK_HEIGHT);
		else 
			return new Rectangle(x ,y ,DECK_WIDTH, 10);
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void reveal() {
		revealed = true;
	}

	public String toString() {
		return "suit=" + suit + ", number=" + number;
	}

	
}
