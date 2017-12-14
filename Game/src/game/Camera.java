package game;

public class Camera {
	private int x;
	private int y;
	
	public Camera(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick (GameObject player) {
		//x = -player.getX() + Game.WIDTH/2;
		x += ((-player.getX()-(x/2)) - x) * .5;
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
}
