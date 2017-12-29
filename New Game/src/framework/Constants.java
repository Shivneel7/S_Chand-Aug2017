package framework;

import java.awt.Color;

public interface Constants {
	//Window
	public static final int GAME_WIDTH = 840;
	public static final int GAME_HEIGHT = GAME_WIDTH / 12 * 9;
	public static final String TITLE = "Shiv's Game.";
	public static final Color BACKGROUND_COLOR = Color.black;
	
	//Other
	public static final float GRAVITY = .5f;
	public static final int NUMBER_OF_LIVES = 3;
	
	//player
	public static final int PLAYER_WIDTH = 32;
	public static final int PLAYER_HEIGHT  = 64;
	public static final float JUMP_HEIGHT = -11f;
	public static final Color PLAYER_COLOR = Color.blue;
	
	//Shooter
	public static final int SHOOTER_WIDTH = 24;
	public static final int SHOOTER_HEIGHT = 48;
	public static final Color SHOOTER_COLOR = new Color(223,102,13);
	
	//Bullet
	public static final Color BULLET_COLOR = Color.red;
	public static final int BULLET_WIDTH = 8;
	public static final int BULLET_HEIGHT = BULLET_WIDTH;
	public static final int BULLET_SPEED = 7;
	
	// Enemy
	public static final int ENEMY_WIDTH = 32;
	public static final int ENEMY_HEIGHT = 32;
	public static final Color ENEMY_COLOR = Color.darkGray;
	
	//Block
	public static final int BLOCK_WIDTH = 32;
	public static final int BLOCK_HEIGHT = BLOCK_WIDTH;
	public static final Color BLOCK_COLOR = Color.white;
	
	public static final Color DEATH_BLOCK_COLOR = Color.red;
	public static final Color GOAL_COLOR = Color.green;
	
	//Coin
	public static final int COIN_SIZE = 8;
	public static final Color COIN_COLOR = new Color(231, 188, 20);
	
}
