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

	public Ball(int window_width, int ball_thicc, int window_height, Paddle p) {
		this.ball_thicc = ball_thicc;
		this.window_width = window_width;
		this.window_height = window_height;
		this.paddle = p;
		Random rand = new Random();
		this.x = rand.nextInt(window_width);
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
		if (checkCollision(paddle)) {
			dy *= -1;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, ball_thicc, ball_thicc);
	}

	public boolean checkCollision(Rect r) {
		return (x + 2 * ball_thicc > r.getX() && x - ball_thicc < r.getX() + r.getWidth()) &&
				(y + ball_thicc > r.getY() && y + ball_thicc < r.getY() + r.getHeight());
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}
}
