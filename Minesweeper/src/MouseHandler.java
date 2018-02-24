import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter implements Constants{

	public Window window;
	public MouseHandler(Window window) {
		this.window = window;
	}
	
	public void mouseClicked(MouseEvent e) {
		//window.changeSize(GAME_WIDTH, GAME_HEIGHT);
	}
	
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getPoint());
	}
}
