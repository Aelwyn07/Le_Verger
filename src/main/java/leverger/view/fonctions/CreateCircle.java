package leverger.view.fonctions;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class CreateCircle {
	
	private Color couleur;
	
	public CreateCircle(Color couleur) {
		
		this.couleur = couleur;
		
	}
	
	public Circle creerRond() {
		Circle circle = new Circle();
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        circle.setRadius(20.0f);
        circle.setStroke(couleur);
        circle.setFill(couleur);
        return circle;
	}
}