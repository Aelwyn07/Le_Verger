package leverger.model;

import javafx.scene.text.Text;

public class Tour {
	public Text nbTour;
	
	public Tour() {
		this.nbTour = new Text();
	}
	
	public Text incrementeTour(int nb) {
		String txt = "Tour n°"+nb;
		nbTour.setText(txt);
		return nbTour;
	}
}



