package cardGame;

public interface Constants {

	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	public static final int SLOTS = 7;
	
	public static final int SPACE = 20;
	
	public static final int DECK_WIDTH = (GAME_WIDTH-((SLOTS + 2) * SPACE))/SLOTS;
	public static final int DECK_HEIGHT = (int) (DECK_WIDTH * 1.4);


	
}
