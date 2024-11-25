package leverger.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class Corbeau {
	
	public ArrayList<ImageView> liste;
	public List<Integer> listeIndice;
	public boolean estComplet;
	public int caseVisible;
	public GridPane grid;
	
	public Corbeau() {
		this.liste = new ArrayList<ImageView>();
		this.estComplet = false;
		this.caseVisible = 0;
		this.grid = new GridPane();
		this.listeIndice = Arrays.asList(1,2,3);
	}
	
	public ImageView ajoutImage(String nom) throws FileNotFoundException {
		String str = "C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\"+nom+".png";
		File file = new File(str);
        Image img = new Image(new FileInputStream(file));
        ImageView imgV = new ImageView(img);
        imgV.setFitWidth(87.5);
        imgV.setFitHeight(37.75);
        imgV.setVisible(false);
        return imgV;
	}
	
	public ArrayList<ImageView> creerListe() throws FileNotFoundException {	
		ImageView case1, case2, case3, case4, case5, case6, case7, case8, case9 = new ImageView();
		case1 = ajoutImage("p1");
		case2 = ajoutImage("p2");
		case3 = ajoutImage("p3");
		case4 = ajoutImage("p4");
		case5 = ajoutImage("p5");
		case6 = ajoutImage("p6");
		case7 = ajoutImage("p7");
		case8 = ajoutImage("p8");
		case9 = ajoutImage("p9");
		liste.add(case1);
		liste.add(case2);
		liste.add(case3);
		liste.add(case4);
		liste.add(case5);
		liste.add(case6);
		liste.add(case7);
		liste.add(case8);
		liste.add(case9);	
		return liste;		
	}
	
	
	public GridPane creerPuzzle() {
		
        int colV = 0;
        int ligV = 1;
        
        for (ImageView c : liste) {
        	grid.add(c, colV, ligV);
        	colV = colV+1;
        	if (colV == 3) {
        		colV = 0;
        		ligV = ligV+1;
        	}
        } 
		return grid;
	}
	
	
	public int ajoutPiece() {
		int res;
		res = (int)(Math.random() * liste.size()) + 1;
		ImageView coul = (ImageView)liste.get(res-1);
		coul.setVisible(true);
		caseVisible = caseVisible + 1;
		liste.remove(res-1);
		return caseVisible;
	}
	
	public boolean puzzleComplet() {
		if (caseVisible == 9) {
			estComplet = true;
		}
		return estComplet;
	}
}
