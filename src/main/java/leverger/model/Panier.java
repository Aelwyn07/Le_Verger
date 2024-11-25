package leverger.model;

import javafx.scene.paint.Color;

public class Panier {
		
		private int nbFruit;
		private boolean estRempli;
		private Color couleur;
		
		public Panier(Color couleur, int nbFruit, boolean estRempli) {
			this.estRempli = estRempli;
			this.couleur = couleur;
			this.nbFruit = nbFruit;
		}
		
		public boolean estRempli() {
			if (nbFruit == 10) {
				estRempli = true;
			}
			return estRempli;
		}
		
		public int ajoutFruit() {
			nbFruit = nbFruit + 1;
			return nbFruit;
		}

		public Color getCouleur() {
			return couleur;
		}

		public int getNbFruit() {
			return nbFruit;
		}
}


