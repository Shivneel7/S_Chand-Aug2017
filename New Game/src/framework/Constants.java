package framework;

import java.awt.Color;

public interface Constants {
	//Window
	public static final int GAME_WIDTH = 840;
	public static final int GAME_HEIGHT = GAME_WIDTH / 12 * 9;
	public static final String TITLE = "Shiv's Game.";
	public static final Color BACKGROUND_COLOR = Color.black;
	
	//player
	public static final int PLAYER_WIDTH = 32;
	public static final int PLAYER_HEIGHT  = 64;
	public static final float JUMP_HEIGHT = -12f;
	public static final Color PLAYER_COLOR = Color.blue;
	
	
	//Block
	public static final int BLOCK_WIDTH = 32;
	public static final int BLOCK_HEIGHT = BLOCK_WIDTH;
	public static final Color BLOCK_COLOR = Color.white;
	
	public static final Color DEATH_COLOR = Color.red;
	public static final Color GOAL_COLOR = Color.green;
	
}
