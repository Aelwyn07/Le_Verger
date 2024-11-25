package leverger.model;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import leverger.view.fonctions.CreateCircle;

public class Arbre {
	
	private String nom;
	private String couleur;
	public boolean estVide;
	public ArrayList<Circle> liste;
	public GridPane grid;
	public int hgap;
	public int vgap;
	
	public Arbre(String nom, String couleur, boolean estVide, GridPane grid, int hgap, int vgap) {
		this.nom = nom;
		this.couleur = couleur;
		this.estVide = estVide;
		this.liste = new ArrayList<Circle>();
		this.grid = grid;
		this.hgap = hgap;
		this.vgap = vgap;
	}
	
	public ArrayList<Circle> ajoutDesFruits(CreateCircle creerCercle, int nb) {
        
        for (Integer i = 0; i < nb; i++ ) {
        	Circle circle = creerCercle.creerRond();
    	    liste.add(circle);
        } 
		return liste;
	}
	
	public Circle cueillir() {
		return liste.remove(liste.size() - 1);
	
	}
	
	public boolean arbreVide() {
		if (liste.isEmpty()) {
			estVide = true;
		}
		return estVide;
	}
	
	public GridPane ajoutGrid() {
		grid.getChildren().clear();
        grid.setHgap(hgap);
        grid.setVgap(vgap);
        int colV = 0;
        int ligV = 1;
        
        for (Circle c : liste) {
        	grid.add(c, colV, ligV);
        	colV = colV+1;
        	if (colV == 3) {
        		colV = 0;
        		ligV = ligV+1;
        	}
        } 
		
		return grid;
	}

}
