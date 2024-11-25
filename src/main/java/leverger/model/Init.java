package leverger.model;

import javafx.scene.image.Image;

public class Init {
	
	public boolean partie;
	public int nbTour;
	public int val;
	public Image face;
	
	public Init(boolean partie, int nbTour, int val, Image coul) {
		this.partie = partie;
		this.nbTour = nbTour;
		this.val = val;
		this.face = coul;
	}
}

