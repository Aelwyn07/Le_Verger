package testsleverger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import javafx.scene.paint.Color;
import leverger.model.Panier;

public class PanierTest {
	
	@Test
	void renvoie_true_quand_le_panier_est_rempli() {
		//Arrange
		Panier panier = new Panier(Color.BLUE, 10, false);
		boolean resultat;
		//Act
		resultat = panier.estRempli();
		//Assert
		assertTrue(resultat);
	}
	
	@Test
	void renvoie_false_quand_le_panier_est_vide() {
		//Arrange
		Panier panier = new Panier(Color.BLUE, 0, false);
		boolean resultat;
		//Act
		resultat = panier.estRempli();
		//Assert
		assertFalse(resultat);
	}
	
	@Test
	void renvoie_false_quand_le_panier_est_non_rempli() {
		//Arrange
		Panier panier = new Panier(Color.BLUE, 5, false);
		boolean resultat;
		//Act
		resultat = panier.estRempli();
		//Assert
		assertFalse(resultat);
	}
	
	@Test 
	void incrementer_un_fruit_dans_le_panier_augmente_le_nombre_de_fruit_de_1() {
		//Arrange
		Panier panier = new Panier(Color.BLUE, 1, false);
		int resultat;
		//Act
		resultat = panier.ajoutFruit();
		//Assert
		assertEquals(2, resultat);
	}
}
