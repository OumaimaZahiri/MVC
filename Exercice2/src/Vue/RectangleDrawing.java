package Vue;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class RectangleDrawing extends JComponent {
	private int height = 20;
	
	RectangleDrawing(int h) {
        setPreferredSize(new Dimension(200, 400)); 
    }
	public void setHeight(int h) {
		 height = h;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(10, 10, 10, height);
	}
	public void refaire(){
		this.repaint(0);
	}
}