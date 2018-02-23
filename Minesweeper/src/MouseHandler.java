import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

	public MouseHandler() {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		System.err.println(e.getPoint());
	}
	
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getPoint());
	}
}
