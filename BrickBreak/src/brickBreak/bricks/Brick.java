package brickBreak.bricks;

import java.awt.Color;
import java.awt.Graphics;

import brickBreak.Rect;

public class Brick extends Rect{
    private Color c;

    public Brick(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        c = color;
    }

    public void render(Graphics g){
        g.setColor(c);
		g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.drawString("1", x, y);
    }
}