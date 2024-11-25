package testsleverger;
import leverger.model.*;
import leverger.view.fonctions.CreateCircle;
import leverger.application.levergerApplicationConsole;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ArbreTest {
	
	
	@Test
	void arbre_vide_renvoie_true() {	
		//Arrange
		GridPane gr = new GridPane();
		Arbre arbre = new Arbre("arbre","jaune",false, gr, 3, 4);
		arbre.ajoutDesFruits(new CreateCircle(Color.BLUE), 0);
		//Act 
		boolean result = arbre.arbreVide();
		//Assert	
		assertTrue(result);
	}
	
	@Test
	void arbre_non_vide_renvoie_faux() {
		//Arrange
		GridPane gr = new GridPane();
		Arbre arbre = new Arbre("arbre","jaune",false, gr, 3, 4);
		arbre.ajoutDesFruits(new CreateCircle(Color.BLUE), 10);
		//Act 
		boolean result = arbre.arbreVide();
		//Assert	
		assertFalse(result);
	}
	
	@Test
	void cueillir_enleve_un_fruit() {	
		//Arrange
		GridPane gr = new GridPane();
		Arbre arbre = new Arbre("arbre","jaune",false, gr, 3, 4);
		arbre.ajoutDesFruits(new CreateCircle(Color.BLUE), 10);
		//Act
		arbre.cueillir();
		int result = arbre.liste.size();
		//Assert
		assertEquals(9, result);
	}
	
	
}
