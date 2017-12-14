package game;

import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject{

	public Block(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.drawRect(x, y, 32, 32);
	}


}
