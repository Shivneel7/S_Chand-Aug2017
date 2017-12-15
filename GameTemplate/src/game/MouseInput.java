package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter{
	
	private Handler handler;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}

	public void mouseMoved(MouseEvent e){
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getID() == ID.Player) {
				handler.object.get(i).setX(e.getX());
				handler.object.get(i).setY(e.getY());
			}
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getPoint().toString());
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println(e.getWheelRotation());
	}
}
