package leverger.model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

public class Des {
	
	private int nbFaces;
	public List<Image> faces;
	
	public Des(int nbFaces) throws FileNotFoundException {
		this.nbFaces = nbFaces;
		this.faces = creationFace();
	}
	
	private List<Image> creationFace() throws FileNotFoundException {
		
		List<Image> faces = new ArrayList<>();
		
		File fileJ = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\jaune.jpg");
	    Image imageJ = new Image(new FileInputStream(fileJ));		
		File fileR = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\rouge.png");
		Image imageR = new Image(new FileInputStream(fileR));		
		File fileB = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\bleu.jpg");
		Image imageB = new Image(new FileInputStream(fileB));	
		File fileV = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\vert.jpg");
		Image imageV = new Image(new FileInputStream(fileV));
		File fileC = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\corbeauFace.png");
		Image imageC = new Image(new FileInputStream(fileC));
		File fileP = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\panier.png");
		Image imageP = new Image(new FileInputStream(fileP));
		faces.add(imageJ);
		faces.add(imageR);
		faces.add(imageB);
		faces.add(imageV);
		faces.add(imageC);
		faces.add(imageP);
		
		return faces;	
	}
	
	public int tirage() {
		
		int res;
		res = (int)(Math.random() * nbFaces) + 1;
		return res;	
	}
	
	
	public Image afficher(int res) {
		Image coul = (Image)faces.get(res-1);
		return coul;
	}
}