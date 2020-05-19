package fr.goyet.controller;

import java.io.IOException;

import fr.goyet.CFunApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;

public class MenuController {

	@FXML
	private MenuItem gestionnaire;		// Sous-menu pour accéder au gestionnaire
	
	@FXML
	private MenuItem accueil;			// Sous-menu pour accéder à l'accueil
	
	@FXML
	private MenuItem quitter;			// Sous-menu pour quitter l'application
	
	@FXML
	private MenuItem help;				// Sous-menu à propos

	private CFunApp cfunApp;
	
	
	@FXML		// Affichage de la vue d'identification pour accéder ensuite au gestionnaire
	void onClickGestionnaire(ActionEvent event) throws IOException {
		CFunApp.afficheVue("View/View_Identification.fxml");
	}
	
	@FXML		// Affichage de la vue accueil
	void onClickAccueil(ActionEvent event) throws IOException{
		CFunApp.afficheVue("View/View_Accueil.fxml");
	}
	
	@FXML		// Affichage du A propos
	void onClickHelp(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);		// Création d'une pop-up d'alerte, niveau de gravité : information
		alert.setTitle("A propos");							// Initialisation du titre de la pop-up
		alert.setHeaderText("Créateur:");					// Initialisation du titre
        alert.setContentText("Fanny GOYET \nKilian LE DU");	// Initialisation du contenu
        
        alert.showAndWait();								// Apparition de la pop-up
	}
	
	// Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }
	
	public void setCFunApp(CFunApp cfunApp) {
		this.cfunApp = cfunApp;
	}
}
