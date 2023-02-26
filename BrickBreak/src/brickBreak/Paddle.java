package brickBreak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Paddle extends Rect implements KeyListener {

	private int window_width;
	private int  dx;
	private boolean keyDown[];
	private int speed = 10;
	
	public Paddle(int window_width, int window_height, int paddle_thicc, int paddle_width) {
		super(window_width/2 - paddle_width/2, window_height - 100, paddle_width, paddle_thicc);
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
		if(x > window_width - width){
			x = window_width - width;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
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

}
