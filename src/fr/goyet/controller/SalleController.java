package fr.goyet.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import fr.goyet.CFunApp;
import fr.goyet.model.Billet;
import fr.goyet.model.Fitness;
import fr.goyet.model.Musculation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SalleController {

	@FXML
    private Button musculation;			// Bouton pour entrer dans la salle de musculation

    @FXML
    private Button fitness;				// Bouton pour entrer dans la salle de fitness

    @FXML
    private Button muscuRouge;			// Voyant rouge pour indiquer que la salle de musculation est complète
    
    @FXML
    private Button muscuOrange;			// Voyant orange pour indiquer que la salle de musculation commence à se remplir
    
    @FXML
    private Button muscuVert;			// Voyant vert pour indiquer que la salle de musculation est vide ou presque
    
    @FXML
    private Button fitnessRouge;		// Voyant rouge pour indiquer que la salle de fitness est complète
    
    @FXML
    private Button fitnessOrange;		// Voyant orange pour indiquer que la salle de fitness commence à se remplir
    
    @FXML
    private Button fitnessVert;			// Voyant vert pour indiquer que la salle de fitness est vide ou presque
    
    public static Musculation salleMuscu = new Musculation();						// Création de la salle de Musculation
	public static Fitness salleFitness = new Fitness();								// Création de la salle de Fitness
	public static ArrayList<Billet> listeBilletEntree = new ArrayList<Billet>();	// Création de la liste des billets d'entrées
	
	@FXML		// Initialisation de la vue
	void initialize() {
		// Si le taux d'occupation de la salle de fitness est inférieur à 70, le voyant sera vert
		if(salleFitness.getTauxOccupation() < 70) {
			fitnessRouge.setVisible(false);		// Voyant rouge invisible
			fitnessOrange.setVisible(false);	// Voyant orange invisible
			fitnessVert.setVisible(true);		// Voyant vert visible
		}
		// Si le taux d'occupation de la salle de fitness est supérieur à 70 et inférieur à 100, le voyant sera orange
		if(salleFitness.getTauxOccupation() > 70 && salleFitness.getTauxOccupation() < 100) {
			fitnessRouge.setVisible(false);		// Voyant rouge invisible
			fitnessOrange.setVisible(true);		// Voyant orange visible
			fitnessVert.setVisible(false);		// Voyant vert invisible
		}
		// Si le taux d'occupation de la salle de fitness est égal à 100, le voyant sera rouge
		if(salleFitness.getTauxOccupation() == 100) {
			fitnessRouge.setVisible(true);		// Voyant rouge visible
			fitnessOrange.setVisible(false);	// Voyant orange invisible
			fitnessVert.setVisible(false);		// Voyant vert invisible
		}
		
		// Si le taux d'occupation de la salle de musculation est inférieur à 70, le voyant sera vert
		if(salleMuscu.getTauxOccupation() < 70) {
			muscuRouge.setVisible(false);		// Voyant rouge invisible
			muscuOrange.setVisible(false);		// Voyant orange invisible
			muscuVert.setVisible(true);			// Voyant vert visible
		}
		// Si le taux d'occupation de la salle de musculation est supérieur à 70 et inférieur à 100, le voyant sera orange
		if(salleMuscu.getTauxOccupation() > 70 && salleMuscu.getTauxOccupation() < 100) {
			muscuRouge.setVisible(false);		// Voyant rouge invisible
			muscuOrange.setVisible(true);		// Voyant orange visible
			muscuVert.setVisible(false);		// Voyant vert invisible
		}
		// Si le taux d'occupation de la salle de musculation est égal à 100, le voyant sera rouge
		if(salleMuscu.getTauxOccupation() == 100) {
			muscuRouge.setVisible(true);		// Voyant rouge visible
			muscuOrange.setVisible(false);		// Voyant orange invisible
			muscuVert.setVisible(false);		// Voyant vert invisible
		}
	}
    
    @FXML	// Au clic sur le bouton "Fitness"
    void onClickFitness(ActionEvent event) throws IOException {
    	// S'il reste de la place dans la salle 
    	if(salleFitness.getNbPlaceOccupee() < salleFitness.getNbPlace()) {
			salleFitness.addFitnessPeople();						// Ajout d'une personne dans la salle de fitness
			DateFormat djour = new SimpleDateFormat("dd/MM/yy");	// Initialisation d'un format jour/mois/annee pour la date
			DateFormat dheure = new SimpleDateFormat("HH:mm");		// Initialisation d'un format heure:minute pour l'heure
			Date date = new Date(); // Fanny et Kilian				// Création de la date
			// Création d'un nouveau billet d'entree avec le nom de la salle, le jour, la date
			Billet billet = new Billet(salleFitness.getNomSalle(),djour.format(date.getTime()),dheure.format(date.getTime()));
			listeBilletEntree.add(billet);							// Ajout du billet à la liste des billets d'entrée
			CFunApp.afficheVue("View/View_Entree.fxml");			// Affichage de la vue du Billet d'entrée
		}
    }

    @FXML	// Au clic sur le bouton "Musculation"
    void onClickMusculation(ActionEvent event) throws IOException {
    	// S'il reste de la place dans la salle 
    	if(salleMuscu.getNbPlaceOccupee() < salleMuscu.getNbPlace()) {
			salleMuscu.addMuscuPeople();							// Ajout d'une personne dans la salle de musculation
			DateFormat djour = new SimpleDateFormat("dd/MM/yy");	// Initialisation d'un format jour/mois/annee pour la date
			DateFormat dheure = new SimpleDateFormat("HH:mm");		// Initialisation d'un format heure:minute pour l'heure
			Date date = new Date();									// Création de la date
			// Création d'un nouveau billet d'entree avec le nom de la salle, le jour, la date
			Billet billet = new Billet(salleMuscu.getNomSalle(),djour.format(date.getTime()),dheure.format(date.getTime()));
			listeBilletEntree.add(billet);							// Ajout du billet à la liste des billets d'entrée
			CFunApp.afficheVue("View/View_Entree.fxml");			// Affichage de la vue du Billet d'entrée
		}
    }
    
    // Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }

    // Récupère la liste des billets d'entrée
	public static ArrayList<Billet> getListeBilletEntree() {
		return listeBilletEntree;
	}

	// Permet de mettre la liste des billets d'entrée à jour
	public void setListeBilletEntree(ArrayList<Billet> listeBilletEntree) {
		SalleController.listeBilletEntree = listeBilletEntree;
	}
    
}
