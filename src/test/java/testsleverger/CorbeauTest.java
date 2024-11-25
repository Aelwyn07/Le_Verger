package testsleverger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import leverger.model.Corbeau;

public class CorbeauTest {
	
	@Test
	void renvoie_true_si_puzzle_complet() throws FileNotFoundException {
		//Arrange
		Corbeau corbeau = new Corbeau();
		//Act
		corbeau.creerListe();
		corbeau.creerPuzzle();
		for (int i = 0; i < 9; i++) {
		    corbeau.ajoutPiece();
		} 
		boolean estComplet = corbeau.puzzleComplet();
		//Assert
		assertTrue(estComplet);
	}
	
	
	@Test
	void renvoie_false_si_puzzle_incomplet() throws FileNotFoundException {
		//Arrange
		Corbeau corbeau = new Corbeau();
		//Act
		corbeau.creerListe();
		corbeau.creerPuzzle();
		for (int i = 0; i < 5; i++) {
		    corbeau.ajoutPiece();
		} 		
		boolean estComplet = corbeau.puzzleComplet();
		//Assert
		assertFalse(estComplet);
		
	}
	
	@Test
	void le_nombre_de_pieces_augmente_quand_une_nouvelle_piece_devient_visible() throws FileNotFoundException {
		//Arrange
		Corbeau corbeau = new Corbeau();
		//Act
		corbeau.creerListe();
		corbeau.creerPuzzle();
		int caseVisible = corbeau.ajoutPiece();
		//Assert
		assertEquals(1, caseVisible);	
	}
}
