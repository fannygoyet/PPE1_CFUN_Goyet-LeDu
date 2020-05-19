package fr.goyet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fr.goyet.CFunApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IdentificationController implements Initializable {

	@FXML
    private TextField user;				// Zone de texte pour entrer l'identifiant

    @FXML
    private PasswordField password;		// Zone de texte pour entrer le mot de passe

    @FXML
    private Button login;				// Bouton pour se connecter
    
    @FXML
    private Label status;				// Label qui permet d'afficher si les identifiants sont erronés 
    

    @FXML		// Se connecter
    void makeLogin(ActionEvent event) throws IOException {
    	String username = user.getText();		// Récupération du texte saisie pour l'identifiant
    	String pass = password.getText();		// Récupération du texte saisie pour le mot de passe
    	// Si les textes saisies correspondent à l'identifiant et au mot de passe
    	if(username.equals("admin") && pass.contentEquals("admin")) {
    		CFunApp.afficheVue("View/View_Gestionnaire.fxml");	// Affichage de la vue Gestionnaire
    	} else {	// Autrement
    		if (!username.equals("admin")) {				// Si l'identifiant ne correspond pas
    			status.setText("Identifiant incorrect");	// Affichage du message correspondant
        	}
    		if(!pass.contentEquals("admin")) {				// Si le mot de passe ne correspond pas
    			status.setText("Mot de passe incorrect");	// Affichage du message correspondant
        	}
    		if(!username.equals("admin") && !pass.contentEquals("admin")) {	// Si ni l'un, ni l'autre ne correspondent
    			status.setText("Identifiant et mot de passe incorrect");	// Affichage du message correspondant
    		}
    	}
	}
	
    // Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	

}
