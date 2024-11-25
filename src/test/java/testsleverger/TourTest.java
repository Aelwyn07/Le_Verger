package testsleverger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.scene.text.Text;
import leverger.model.Tour;

public class TourTest {
	
	@Test
	void le_nombre_de_tour_augmente_quand_la_fonction_est_appelee() {
		//Arrange
		Tour tour = new Tour();
		//Act
		Text result = tour.incrementeTour(4);
		//Assert
		assertEquals("Tour n°4", result.getText());
		
	}
}
