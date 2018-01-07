package cardGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Card implements Constants{

	private int x, y, number;
	private Suit suit;

	private boolean revealed = true;
	private boolean isTop;
	
	public Card(int x, int y, Suit suit, int number) {
		this.x = x;
		this.y = y;
		this.suit = suit;
		this.number = number;
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(revealed) {
			//placeholder for graphics.
			//card back
			g.setColor(Color.white);
			g.fillRect(x, y, CARD_WIDTH, CARD_HEIGHT);
			//card text
			g.setColor(suit.color());
			
			g.drawString("" +suit+number, x + 17, y + 13);
			//card border
			g.setColor(Color.black);
			g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);

		}else {
			g.setColor(Color.black);
			g.fillRect(x, y, CARD_WIDTH, CARD_HEIGHT);
			g.setColor(Color.white);
			g.drawRect(x, y, CARD_WIDTH, CARD_HEIGHT);
		}
	}
	
	public Rectangle getBounds() {
		if(isTop)
			return new Rectangle(x ,y ,CARD_WIDTH, CARD_HEIGHT);
		else 
			return new Rectangle(x ,y ,CARD_WIDTH, STACK_SPACING);
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
