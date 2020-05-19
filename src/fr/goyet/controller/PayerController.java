package fr.goyet.controller;

import java.io.IOException;
import java.util.ArrayList;

import fr.goyet.CFunApp;
import fr.goyet.model.Billet;
import fr.goyet.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PayerController {
	
	@FXML
    private Label numSortie;			// Numéro du billet de sortie

    @FXML
    private Label dateSortie;			// Date du billet de sortie

    @FXML
    private Label heureSortie;			// Heure du billet de sortie

    @FXML
    private Label montant;				// Montant du billet de sortie

    @FXML
    private Button payer;				// Bouton pour changer de vue
    
    // Récupération de la liste des billets de sortie créée dans SortieController
    public ArrayList<Billet> listeBilletSortie = SortieController.getListeBilletSortie();

    @FXML		// Initialisation de la vue 
    public void initialize() {
    	// Récupération du billet de sortie en cours de traitement
    	Billet billetEnCours = Outils.recupBilletEnCours(listeBilletSortie);
		// Initialisation des données du billet en cours
		initialisationBillet(billetEnCours);
    }
    
    public void setMainApp(CFunApp mainApp) {
   	}
    
    @FXML		// Changer de vue
    void onClickPayer(ActionEvent event) throws IOException {
    	CFunApp.afficheVue("View/View_Accueil.fxml");	// Affichage de la vue de l'accueil
    }
    
    // Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }
    
    // Initialisation des valeurs du billet en cours
    public void initialisationBillet(Billet billetEnCours) {
    	numSortie.setText(Integer.toString(billetEnCours.getNumBilletSortie()));	// Initialisation du numéro du billet de sortie		
		dateSortie.setText(billetEnCours.getDate());								// Initialisation de la date
		heureSortie.setText(billetEnCours.getHeure());								// Initialisation de l'heure
		montant.setText((billetEnCours.getMontant()).toString() + " €");			// Initialisation du montant
    }
}
