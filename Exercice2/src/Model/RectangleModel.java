package Model;
import java.util.Observable;

public class RectangleModel extends Observable {
	
	private double height = 20;
	
	public double getHeight (){ 
		return height ;
	}
	
	public void setHeight ( double height ){ 
		this.height = height ;
		setChanged();
		notifyObservers();
	}
}