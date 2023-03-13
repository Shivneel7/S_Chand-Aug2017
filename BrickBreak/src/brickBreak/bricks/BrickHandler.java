package brickBreak.bricks;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import brickBreak.Ball;

public class BrickHandler {

    private ArrayList<Brick> bricks;
    private static int NUM_COL = 10;
    private static int NUM_ROW = 5;

    private int window_width, window_height;
    private int b_height, b_width;

    private Ball ball;

    public BrickHandler(int ww, int wh, Ball b) {
        window_width = ww;
        window_height = wh;
        b_width = ww / NUM_COL;
        b_height = 45;
        this.ball = b;

        bricks = new ArrayList<>();

        for (int col = 0; col < NUM_COL; col++) {
            for (int row = 0; row < NUM_ROW; row++) {
                Color c = Color.RED;
                if (col % 2 == 0 && row % 2 == 0)
                    c = Color.yellow;
                else if (row % 2 == 0)
                    c = Color.green;
                else if (col % 2 == 0) {
                    c = Color.cyan;
                }

                bricks.add(new Brick(col * b_width, row * b_height, b_width, b_height, c));
            }
        }
    }

    public void render(Graphics g) {
        for (Brick b : bricks) {
            b.render(g);
        }
    }

    public void tick() {
        for (Iterator<Brick> i = bricks.iterator(); i.hasNext();) {
            Brick b = i.next();
            if (ball.checkCollision(b)) {
                ball.setDy(ball.getDy()*-1);
                i.remove();
            }
        }
    }

}
