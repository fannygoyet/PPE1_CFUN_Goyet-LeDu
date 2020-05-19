package fr.goyet.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fr.goyet.CFunApp;
import fr.goyet.model.Billet;
import fr.goyet.tools.Outils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SortieController {

	@FXML
    private Button payer;				// Bouton pour payer

    @FXML
    private TextField numBillet;		// Zone de texte pour écrire le nom du billet d'entrée de l'utilisateur souhaitant sortir

    @FXML
    private Label messageStatut;		// Label qui sert à afficher un message si le numéro du billet n'a pas été trouvé
    
    // Récupération de la liste des billets d'entrée créée dans SalleController
    public ArrayList<Billet> listeBilletEntree = SalleController.getListeBilletEntree();
    // Création de la liste des billets de sortie
    public static ArrayList<Billet> listeBilletSortie = new ArrayList<Billet>();
    
    @FXML		// Création d'un billet de sortie
    void onClickSortir(ActionEvent event) throws IOException, ParseException {
    	Integer num = Integer.parseInt(numBillet.getText());			// Récupération de la valeur entrée dans la zone de texte
    	for(Billet unBillet : SalleController.listeBilletEntree) {		// Recherche du numéro précédemment récupéré parmi ceux existant dans la liste de billet d'entrée
    		if(unBillet.getNumBilletEntree() == num) {					// Si un billet correspond à celui recherché
    			
    			DateFormat djour = new SimpleDateFormat("dd/MM/yy");	// Initialisation d'un format jour/mois/annee pour la date
    			DateFormat dheure = new SimpleDateFormat("HH:mm");		// Initialisation d'un format heure:minute pour l'heure
    			Date date = new Date(); // Fanny et Kilian				// Création de la date
    			String fin = dheure.format(date.getTime());				// Récupération de l'heure au moment du clic sur "Sortir"
    			String deb = unBillet.getHeure();						// Récupération de l'heure d'entrée sur le billet d'entrée
    			
    			int temps = Outils.calculTemps(deb,fin);				// Calcul du temps entre le début et la fin de la séance passé à la salle
    			Double montant = Outils.calculMontant(temps);			// Calcul du montant pour le temps passé à la salle
    			Billet billetSortie = new Billet(djour.format(date.getTime()),fin, montant);	// Création du billet de sortie avec le jour, l'heure de fin et le montant
    			listeBilletSortie.add(billetSortie);					// Ajout du billet de sortie à la liste
    			
    			sortirPeople(unBillet);									// Suppression de la présence de l'utilisateur dans la salle
    			SalleController.listeBilletEntree.remove(unBillet);		// Suppression du billet d'entrée de l'utilisateur
    			
    			
    			CFunApp.afficheVue("View/View_Payer.fxml");				// Affichage de la vue du billet de sortie
    		} else {
    			messageStatut.setText("Je n'ai pas trouvé le billet");	// Affichage du message dans le cas où le billet n'a pas été trouvé
    		}
    	}
    }
    
    // Retirer un utilisateur d'une salle
    public void sortirPeople(Billet unBillet) {
    	String typeSalle = unBillet.getNomSalle();			// Récupérer le nom de la salle à partir du billet d'entrée
    	if(typeSalle == "Fitness") {						// Si la salle concernée est la salle de fitness
    		SalleController.salleFitness.removePeople();	// Retirer un utilisateur de la salle de fitness
    	} else if(typeSalle == "Musculation"){				// Si la salle concernée est la salle de musculation
    		SalleController.salleMuscu.removePeople();		// Retirer un utilisateur de la salle de musculation
    	}
    }

    // Récupère la liste des billets d'entrée
	public static ArrayList<Billet> getListeBilletSortie() {
		return listeBilletSortie;
	}
	
	// Permet de mettre la liste des billets d'entrée à jour
	public void setListeBilletSortie(ArrayList<Billet> listeBilletSortie) {
		SortieController.listeBilletSortie = listeBilletSortie;
	}
	
	// Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }
}
