package leverger.application;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import leverger.model.*;
import leverger.view.*;
import leverger.view.fonctions.AfficheDes;
import leverger.view.fonctions.AffichePanier;
import leverger.view.fonctions.CreateCircle;

public class levergerApplicationConsole extends javafx.application.Application {
	
	public void start(Stage primaryStage) throws FileNotFoundException {
					
		BorderPane root = new BorderPane();
		
		
		File file = new File("C:\\Users\\Administrateur\\Desktop\\Cours\\BUT INFO\\Semestre 2\\SAE\\S2.01\\saebut1\\leverger\\images\\image.png");
		Image img1 = new Image(new FileInputStream(file));	
		
        BackgroundImage bImg = new BackgroundImage(img1,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundRepeat.NO_REPEAT,
                                                   BackgroundPosition.DEFAULT,
                                                   new BackgroundSize(1.0, 1.0, true, true, false, false));
        Background bGround = new Background(bImg);
        root.setBackground(bGround);
        
        final Init init = new Init(true, 0, 0, null);
        
        HBox hbox = new HBox();		
		final Tour afficheTour = new Tour();
		hbox.getChildren().add(afficheTour.nbTour);
        hbox.setAlignment(Pos.CENTER);
        afficheTour.nbTour.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		root.setTop(hbox);
         
		GridPane grid = new GridPane();
       	   
        //création du dés	
		
      	final Des de1 = new Des(5);
      		
        // Boutons et texte
        VBox vboxBouton = new VBox();
        
        Button boutonLancer = new Button();
        boutonLancer.setText("lancer le dé");
        vboxBouton.getChildren().add(boutonLancer);
        vboxBouton.setAlignment(Pos.BASELINE_LEFT);
        
        Text texteFin = new Text("");
        texteFin.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        vboxBouton.getChildren().add(texteFin);
        
        Separator separator = new Separator();
        separator.setPrefHeight(50); 
        vboxBouton.getChildren().add(separator);
        
        Button boutonQuitter = new Button();
        boutonQuitter.setText("Quitter");
        vboxBouton.getChildren().add(boutonQuitter);
        vboxBouton.setAlignment(Pos.CENTER_RIGHT);
       
        grid.add(vboxBouton,  1, 1);
		
     
        // Dés
        
        StackPane cadreDes = new StackPane();
        Rectangle rect = new Rectangle();
        rect.setX(2);
        rect.setY(2);
        rect.setWidth(150);
        rect.setHeight(150);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        
        ImageView imV = new ImageView();
        final AfficheDes resultDe = new AfficheDes(imV);
        cadreDes.getChildren().addAll(resultDe.couleurFace, rect);
        resultDe.couleurFace.toFront();
           
        grid.add(cadreDes, 2, 1);
        grid.setHgap(225);
        grid.setVgap(30);
        
        
        // Corbeau
        
        Corbeau corbeau = new Corbeau();
        corbeau.creerListe();
        corbeau.creerPuzzle();
        
        HBox hboxCorbeau = new HBox();
        hboxCorbeau.getChildren().add(corbeau.grid);
        hboxCorbeau.setMargin(corbeau.grid, new Insets(60, 0, 0, 920));
        root.getChildren().add(hboxCorbeau);
      
        
        //Création des paniers
        
        Panier panierBleu = new Panier(Color.BLUE, 0, false);
        Panier panierRouge = new Panier(Color.RED, 0, false);
        Panier panierVert = new Panier(Color.GREEN, 0, false);
        Panier panierJaune = new Panier(Color.YELLOW, 0, false);
        
        
        // Création des fruits
        
        CreateCircle c1 = new CreateCircle(Color.BLUE);
        CreateCircle c2 = new CreateCircle(Color.RED);
        CreateCircle c3 = new CreateCircle(Color.YELLOW);
        CreateCircle c4 = new CreateCircle(Color.GREEN);
                  
        GridPane gridB = new GridPane();    
        GridPane gridR = new GridPane();    
        GridPane gridJ = new GridPane();            
        GridPane gridV = new GridPane();
        
        // Création des arbres
         
        final Arbre arbreJaune = new Arbre("arbre jaune","jaune",false, gridJ, 35, 6);
		final Arbre arbreVert = new Arbre("arbre vert","vert",false, gridV, 30, 20);
		final Arbre arbreRouge = new Arbre("arbre rouge","rouge",false, gridR, 40, 22);
		final Arbre arbreBleu = new Arbre("arbre bleu","bleu",false, gridB, 30, 25);
		
		// Ajouts des fruits
		
		arbreJaune.ajoutDesFruits(c3, 10);
		arbreRouge.ajoutDesFruits(c2, 10);
		arbreBleu.ajoutDesFruits(c1, 10);
		arbreVert.ajoutDesFruits(c4, 10);
        arbreJaune.ajoutGrid();
        arbreVert.ajoutGrid();
        arbreRouge.ajoutGrid();
        arbreBleu.ajoutGrid();
	
        GridPane grid2 = new GridPane();
        
        // Définir la largeur par défaut des colonnes
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(80);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(130);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(110);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(100);

        grid2.getColumnConstraints().addAll(column1, column2, column3, column4);
      
        GridPane.setMargin(gridB, new Insets(15, 0,0,15));
        GridPane.setMargin(gridR, new Insets(20, 0,0,95));  
        GridPane.setMargin(gridJ, new Insets(110, 0,0,40));
        GridPane.setMargin(gridV, new Insets(0, 0,0,10));
        grid2.add(arbreBleu.grid, 0, 1);
        grid2.add(gridR, 1, 1);					
        grid2.add(gridJ, 2, 1);
        grid2.add(gridV, 3, 1);
        grid2.setHgap(110);
        grid2.setVgap(80);
        
      
        //Import des paniers
        
        HBox hboxPanier = new HBox();
        
        AffichePanier affichePanierRouge = new AffichePanier();
        AffichePanier affichePanierBleu = new AffichePanier();
        AffichePanier affichePanierVert = new AffichePanier();
        AffichePanier affichePanierJaune = new AffichePanier();
        
        affichePanierRouge.Init();
        affichePanierBleu.Init();
        affichePanierVert.Init();
        affichePanierJaune.Init();
         
        hboxPanier.getChildren().addAll(affichePanierBleu.contenuPanier,affichePanierRouge.contenuPanier,affichePanierJaune.contenuPanier,affichePanierVert.contenuPanier); 
         
        Insets panier1 = new Insets(631, 10, 0, 220);
        hboxPanier.setMargin(affichePanierBleu.contenuPanier, panier1);
        Insets panier2 = new Insets(631, 10, 0, 50);
        hboxPanier.setMargin(affichePanierRouge.contenuPanier, panier2);
        Insets panier3 = new Insets(631, 10, 0, 280);
        hboxPanier.setMargin(affichePanierJaune.contenuPanier, panier3);
        Insets panier4 = new Insets(631, 10, 0, 220);
        hboxPanier.setMargin(affichePanierVert.contenuPanier, panier4);
      	
        
        // Ajout des éléments sur la scène
        
        VBox vbox1 = new VBox();
        vbox1.getChildren().add(grid);
        vbox1.getChildren().add(grid2);
      
        root.getChildren().add(hboxPanier);
        root.setCenter(vbox1);
       
       
        Scene scene = new Scene(root, 1280, 702);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
		// Partie    
        
        boutonQuitter.setOnMouseClicked(new EventHandler<MouseEvent>() {
        	public void handle(MouseEvent event) {
        		Platform.exit();
        	}
        });
        
        
		boutonLancer.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
					
				if ((arbreJaune.estVide == true) && (arbreRouge.estVide == true) && (arbreVert.estVide == true) && (arbreBleu.estVide == true)) {
				}
				
				else {
					
					init.nbTour = init.nbTour + 1;
					init.val = de1.tirage();
					init.face = de1.afficher(init.val);
					resultDe.afficheFace(init.face);
					afficheTour.incrementeTour(init.nbTour);	
					

					if ((init.val == 1) && (arbreJaune.estVide == false)) {
						arbreJaune.cueillir();
						arbreJaune.arbreVide();
						arbreJaune.ajoutGrid();
						int nb = panierJaune.ajoutFruit();
						affichePanierJaune.actualiserContenu(nb);
					}
				
					else if ((init.val == 4) && (arbreVert.estVide == false)) {
						arbreVert.cueillir();
						arbreVert.arbreVide();
						arbreVert.ajoutGrid();
						int nb = panierVert.ajoutFruit();
						affichePanierVert.actualiserContenu(nb);
					}
				
					else if ((init.val == 2) && (arbreRouge.estVide == false)) {
						arbreRouge.cueillir();
						arbreRouge.arbreVide();
						arbreRouge.ajoutGrid();
						int nb = panierRouge.ajoutFruit();
						affichePanierRouge.actualiserContenu(nb);
					}

					else if ((init.val == 3) && (arbreBleu.estVide == false)) {
						arbreBleu.cueillir();
						arbreBleu.arbreVide();
						arbreBleu.ajoutGrid();
						int nb = panierBleu.ajoutFruit();
						affichePanierBleu.actualiserContenu(nb);
					}
					
					else if (init.val == 5) {
						corbeau.ajoutPiece();
					}
				}
				corbeau.puzzleComplet();
				if ((arbreJaune.estVide == true) && (arbreRouge.estVide == true) && (arbreVert.estVide == true) && (arbreBleu.estVide == true) && (corbeau.estComplet == false)) {
					init.partie = false;
					boutonLancer.setVisible(false);
					String txtFin = "Vous avez gagné en "+ init.nbTour + " tours ! ";
					texteFin.setText(txtFin);
					rect.setVisible(false);
					cadreDes.setVisible(false);	
				}
				
				else if ((corbeau.estComplet == true)) {
					init.partie = false;
					boutonLancer.setVisible(false);
					String txtFin = "Le corbeau a gagné après "+ init.nbTour + " tours ! ";
					texteFin.setText(txtFin);
					rect.setVisible(false);
					cadreDes.setVisible(false);	
				}
			}
		});
	}
	
	public static void main(String[] args) {		
		Application.launch(args);
	}
		
}

