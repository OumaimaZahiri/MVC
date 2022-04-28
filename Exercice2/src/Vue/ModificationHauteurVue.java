package Vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.RectangleController;
import Model.RectangleModel;

public class ModificationHauteurVue implements Observer {
	
	protected RectangleModel model ;
	protected RectangleController controller ;
	private JFrame controlJFrame;
	private JTextField display = new JTextField ();
	private JButton minusButton = new JButton ("-");
	private JButton plusButton = new JButton ("+");
	
	
	
	public ModificationHauteurVue(RectangleModel model , final RectangleController controller , int posx , int posy ) {
		this . model = model ;
		this . controller = controller ;
		model . addObserver ( this );
		
		
		controlJFrame = new JFrame ("Rectangle : saisie de hauteur");
		controlJFrame.add( new JLabel ("Veuillez saisir la hauteur") , BorderLayout . SOUTH );
		controlJFrame.add( display , BorderLayout . CENTER );
		
		JPanel buttons = new JPanel ();
		buttons.add( minusButton );
		buttons.add( plusButton );
		controlJFrame.add(buttons, BorderLayout . NORTH );

	    controlJFrame.setVisible (true);
	    controlJFrame.setResizable(false);
	    controlJFrame.setSize (200 ,150);
		controlJFrame.setLocation (posx , posy - 100 );
		controlJFrame.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		 
		
		setDisplay (""+ (int) model.getHeight ());
		addDownListener ( new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				controller.decreaseHeight ();
			}});
		addUpListener ( new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				controller.increaseHeight ();
			}});
		addDisplayListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				double h = getDisplay ();
				controller.Text(h);
			}});
	}
	

	public void enableWarning() {
		display.setBackground (Color.RED);
		if (getDisplay()<0) {model.setHeight(0);} 
		if (getDisplay()>399) {model.setHeight(399);}
		
	}
	public void disableWarning() {
		display.setBackground (Color.WHITE);
	}
	
	public void setDisplay ( String s) {
		display . setText (s);
	}
	public double getDisplay () {
		double result = 0;
		try {
			result = Double . valueOf ( display . getText ()). doubleValue ();
		}
		catch ( NumberFormatException e ){}
		return result ;
	}
	public void addDisplayListener ( ActionListener a){ 
		display . addActionListener (a);
	}
	public void addUpListener ( ActionListener a){ 
		plusButton . addActionListener (a);
	}
	public void addDownListener ( ActionListener a){ 
		minusButton . addActionListener (a );
	}

	public void update ( Observable s, Object o) {
		setDisplay (""+ (int) model.getHeight ());
	}
}
