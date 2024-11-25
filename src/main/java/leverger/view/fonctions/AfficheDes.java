package leverger.view.fonctions;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class AfficheDes {
	public ImageView couleurFace;
	
	public AfficheDes(ImageView res) {
		this.couleurFace = res;
	}
	
	public ImageView afficheFace(Image face) {
		couleurFace.setFitWidth(150);
		couleurFace.setPreserveRatio(true);
		couleurFace.setImage(face);
		return couleurFace;
	}
}
