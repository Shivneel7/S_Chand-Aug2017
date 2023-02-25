package brickBreak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Paddle implements KeyListener {

	private int x;
	private int y;
	private int paddle_W;
	private int paddle_THICC;
	private int window_width;
	private int  dx;
	private boolean keyDown[];
	private int speed = 10;
	
	public Paddle(int window_width, int window_height, int paddle_thicc, int paddle_width) {
		this.x = window_width/2-paddle_width/2;
		this.y = window_height - 100;
		this.paddle_THICC = paddle_thicc;
		this.paddle_W = paddle_width;
		this.window_width = window_width;
		keyDown = new boolean[2];
	}

	public void setdx(int dy) {
		this.dx = dy;
	}

	public void tick() {
		x += dx;
		if(x < 0){
			x = 0;
		}
		if(x > window_width - paddle_W){
			x = window_width - paddle_W;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, paddle_W, paddle_THICC);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(isKey(e,"D") && !keyDown[0]){
			keyDown[0] = true;
			dx += speed;
		}
		if(isKey(e,"A") && !keyDown[1]){
			keyDown[1] = true;
			dx += -speed;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(isKey(e,"D") && keyDown[0]){
			keyDown[0] = false;
			dx += -speed;
		}
		if(isKey(e,"A") && keyDown[1]){
			keyDown[1] = false;
			dx += speed;
		}
	}

	public boolean isKey(KeyEvent e, char key){
		return (KeyEvent.getKeyText(e.getKeyCode())).equals(""+key);
	}

	public boolean isKey(KeyEvent e, String key){
		return (KeyEvent.getKeyText(e.getKeyCode())).equals(""+key);
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

	public int getPaddle_W() {
		return paddle_W;
	}

	public void setPaddle_W(int paddle_W) {
		this.paddle_W = paddle_W;
	}

	public int getPaddle_THICC() {
		return paddle_THICC;
	}

	public void setPaddle_THICC(int paddle_THICC) {
		this.paddle_THICC = paddle_THICC;
	}
}
