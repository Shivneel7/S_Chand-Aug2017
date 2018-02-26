import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter implements Constants{

	public Window window;
	public Board board;
	
	public MouseHandler(Window window, Board b) {
		this.window = window;
		this.board = b;
	}
	
	public void mousePressed(MouseEvent e) {
		int row = e.getY() / TILE_LENGTH;
		int col = e.getX() / TILE_LENGTH;
		System.out.println(row + " " + col);
		board.board[row][col].click();
		
	}
	
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getPoint());
	}
}
