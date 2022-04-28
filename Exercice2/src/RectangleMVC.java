
import Control.RectangleController;
import Model.RectangleModel;
import Vue.*;


public class RectangleMVC {
	public RectangleMVC () {
			RectangleModel model = new RectangleModel();
			RectangleController controllerHaut = new RectangleController(model);
			RectangleController controllerRect = new RectangleController(model);
			ModificationHauteurVue hauteurVue = new ModificationHauteurVue(model , controllerHaut, 100, 200);
			TracerRectangleVue rectangleVue = new TracerRectangleVue(model, controllerRect, 100, 200);
			controllerHaut.setView(hauteurVue);
	}
	public static void main ( String args []) {
		new RectangleMVC ();
	}
}