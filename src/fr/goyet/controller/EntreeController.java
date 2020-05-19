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

public class EntreeController {
	
	@FXML
    private Label numEntree;			// Numéro du billet d'entrée

	@FXML
	private Label idSalle;				// Identifiant de la salle

    @FXML
    private Label dateEntree;			// Date du billet d'entrée

    @FXML
	private Label heureEntree;			// Heure du billet d'entrée

    @FXML
    private Button imprimer;			// Bouton imprimer
    
    // Récupération de la liste des billets d'entrée créée dans SalleController
    public ArrayList<Billet> listeBilletEntree = SalleController.getListeBilletEntree();
    
    @FXML		// Initialisation de la vue 
    public void initialize() {
    	// Récupération du billet d'entrée en cours de traitement
    	Billet billetEnCours = Outils.recupBilletEnCours(listeBilletEntree);
    	// Initialisation des données du billet en cours
		initialisationBillet(billetEnCours);
    }
    
    public void setMainApp(CFunApp mainApp) {
	}

    @FXML		// Changer de vue
    void onClickImprimer(ActionEvent event) throws IOException {
    	CFunApp.afficheVue("View/View_Accueil.fxml");	// Affichage de la vue de l'accueil
    }
    
    // Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }
    
    // Initialisation des valeurs du billet en cours
    public void initialisationBillet(Billet billet) {
    	numEntree.setText(Integer.toString(billet.getNumBilletEntree()));	// Initialisation du numéro du billet d'entrée
		idSalle.setText(billet.getNomSalle());								// Initialisation du nom de la salle
		dateEntree.setText(billet.getDate());								// Initialisation de la date
		heureEntree.setText(billet.getHeure());								// Initialisation de l'heure
    }

}
