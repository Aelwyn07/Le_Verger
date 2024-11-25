package leverger.view.fonctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AffichePanier {
	
	private ImageView imgV;
	private Text nbFruits;
	public VBox contenuPanier;
	
	
	public AffichePanier() {
		this.contenuPanier = new VBox();
		this.nbFruits = new Text("x0");		
		this.imgV = new ImageView();
	}
	
	public ImageView Init() throws FileNotFoundException {
		File file = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\panier.png");
        Image img = new Image(new FileInputStream(file));
        imgV = new ImageView(img);
        imgV.setFitWidth(50);
        imgV.setFitHeight(50);
        contenuPanier.getChildren().addAll(nbFruits, imgV);    
        return imgV;
	}
	
	public Text actualiserContenu(int ajout) {
		String nb = "x"+ajout;
		nbFruits.setText(nb);
		return nbFruits;
	}
	
	public ImageView getimgV() {
		return imgV;
	}

   
}
