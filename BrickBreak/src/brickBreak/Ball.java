package brickBreak;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {

	private int x;
	private int y;
	private int ball_thicc;
	private int window_width, window_height;
	private float dx = 10, dy = 10;
	private Paddle paddle;
	private int changing;

	public Ball(int window_width, int ball_thicc, int window_height, Paddle p) {
		this.ball_thicc = ball_thicc;
		this.window_width = window_width;
		this.window_height = window_height;
		this.paddle = p;
		Random rand = new Random();
		this.x = rand.nextInt(window_width);
	}

	public void setdx(int dy) {
		this.dx = dy;
	}

	public void tick() {

		if (true) {
			x += dx;
			y += dy;
		}
		if (x < 0 || x > window_width - ball_thicc) {
			dx *= -1;
		}
		if (y < 0) {
			dy *= -1;
		}
		if (x + 2 * ball_thicc > paddle.getX() && x - ball_thicc < paddle.getX() + paddle.getPaddle_W()) {
			if (y + ball_thicc > paddle.getY() && y + ball_thicc < paddle.getY() + paddle.getPaddle_THICC()) {
				if (changing <= 0) {
					dy *= -1;
					changing = (int) (paddle.getPaddle_W() / dx);
				}
			}
		}
		if (changing > 0) {
			changing--;
		}

	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, ball_thicc, ball_thicc);
	}

}
