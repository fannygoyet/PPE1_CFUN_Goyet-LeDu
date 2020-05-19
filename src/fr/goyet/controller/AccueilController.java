package fr.goyet.controller;

import java.io.IOException;
import java.util.ArrayList;

import fr.goyet.CFunApp;
import fr.goyet.model.Billet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AccueilController {
	
	@FXML
    private Button entrer;				// Bouton pour entrer : vue Salle

    @FXML
    private Button sortir;				// Bouton pour sortir : vue Sortie
    
    @FXML
    private Label action;				// Message pour avertir d'une action impossible dans certains cas
    
    
    // Récupération de la liste des billets d'entrée créée dans Salle Controller
    public ArrayList<Billet> listeBilletEntree = SalleController.getListeBilletEntree();

    @FXML		// Initialisation de la vue 
    public void initialize() {
    	if(listeBilletEntree.size()-1 == 0) {		// Si la taille de la liste des billets d'entrée est égal à 0
    		action.setVisible(true);				// Message d'erreur qui s'affiche "Action impossible" pour cliquer sur le bouton sortir
    	} else {
    		action.setVisible(false);				// Message invisible
    	}
    }
    @FXML		// Changer de vue
    public void onClickEntrer(ActionEvent event) throws IOException {
    	CFunApp.afficheVue("View/View_Salle.fxml");	// Affichage de la vue Salle
    }

    @FXML	// Initialisation de la vue 
    public void onClickSortir(ActionEvent event) throws IOException {
    	if(listeBilletEntree.size() == 0) {			// Si la taille de la liste des billets d'entrée est égal à 0
    		action.setVisible(true);				// Message d'erreur qui s'affiche "Action impossible" pour cliquer sur le bouton sortir
    	} else {
    		CFunApp.afficheVue("View/View_Sortie.fxml");	// Affichage de la vue Sortie
    	}
    }
    
    // Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }
}
