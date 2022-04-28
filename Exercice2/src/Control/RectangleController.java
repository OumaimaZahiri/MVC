package Control;
import Model.*;
import Vue.*;

public class RectangleController {
	private RectangleModel model ;
	private ModificationHauteurVue view = null;
	
	public RectangleController ( RectangleModel m) {
		model = m;
	}
	
	public void increaseHeight() {
		model.setHeight(model.getHeight()+1);
		control();
	}
	
	public void decreaseHeight() {
		model.setHeight(model.getHeight()-1);
		control();
	}
	
	public void Text(double h) {
		model.setHeight(h);
		control();
	}

	
	public void control() {
		if(view != null) {
            if ((model.getHeight() >= 399)||(model.getHeight() < 0)) {
                view.enableWarning();
            } else {
                view.disableWarning();
            }
        }
	}
	
	public void setView(ModificationHauteurVue view) {
		this.view = view;
	}
	
	}