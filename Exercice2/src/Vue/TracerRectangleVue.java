package Vue;
import Control.RectangleController;
import Model.RectangleModel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TracerRectangleVue implements Observer {
	
	
	//private String label ;
	private RectangleModel model ;
	private RectangleController controller ;
	private RectangleDrawing rect;
	private JFrame rectJFrame ;

	
	public TracerRectangleVue(RectangleModel model, RectangleController controller, int posx, int posy) {
		super();
		this.model = model;
		this.controller = controller ;
		rect = new RectangleDrawing((int) model.getHeight());
		
		
		JPanel panel = new JPanel();
		rectJFrame = new JFrame ("Rectangle : tracé");
		rectJFrame.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		rectJFrame.setSize (200 ,450);
		rectJFrame.setLocation (posx , posy + 50);
		panel.add(rect);
		rectJFrame.add(panel);
		rectJFrame.setVisible ( true );
		model.addObserver (this);
		
	}
	public void update(Observable o, Object arg) {
		rect.setHeight((int) model.getHeight());
		rect.refaire();
	}
}