package fr.goyet.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GestionnaireController {

	@FXML
    private Label nbPlaceM;				// Nombre de places en musculation

    @FXML
    private Label nbPlaceOccupeeM;		// Nombre de places occupées en musculation

    @FXML
    private Label nbPlaceLibreM;		// Nombre de places libres en musculation

    @FXML
    private Label tauxOccupationM;		// Taux d'occupation en musculation

    @FXML
    private Label nbPlaceF;				// Nombre de places en fitness

    @FXML
    private Label nbPlaceOccupeeF;		// Nombre de places occupées en fitness

    @FXML
    private Label nbPlaceLibreF;		// Nombre de places libres en fitness

    @FXML
    private Label tauxOccupationF;		// Taux d'occupation en fitness
	
    @FXML		// Initialisation de la vue et des variables
    void initialize() {
    	nbPlaceM.setText((SalleController.salleMuscu.getNbPlace()).toString());
    	nbPlaceOccupeeM.setText((SalleController.salleMuscu.getNbPlaceOccupee()).toString());
    	nbPlaceLibreM.setText((SalleController.salleMuscu.getNbPlaceLibre()).toString());
    	tauxOccupationM.setText((SalleController.salleMuscu.getTauxOccupation()).toString() + " %");
    	
    	nbPlaceF.setText((SalleController.salleFitness.getNbPlace()).toString());
    	nbPlaceOccupeeF.setText((SalleController.salleFitness.getNbPlaceOccupee()).toString());
    	nbPlaceLibreF.setText((SalleController.salleFitness.getNbPlaceLibre()).toString());
    	tauxOccupationF.setText((SalleController.salleFitness.getTauxOccupation()).toString() + " %");    	
    }
    
    @FXML		// Ajout de place dans la salle de musculation
    void onClickMoinsMuscu(ActionEvent event) throws IOException{
    	SalleController.salleMuscu.setNbPlace(SalleController.salleMuscu.getNbPlace() - 1);
    			// Recalcule de toutes les autres données
    	nbPlaceM.setText((SalleController.salleMuscu.getNbPlace()).toString());
    	nbPlaceOccupeeM.setText((SalleController.salleMuscu.getNbPlaceOccupee()).toString());
    	nbPlaceLibreM.setText((SalleController.salleMuscu.getNbPlaceLibre()).toString());
    	tauxOccupationM.setText((SalleController.salleMuscu.getTauxOccupation()).toString() + " %");
    	
    }
    
    @FXML		// Suppresion de place dans la salle de musculation
    void onClickPlusMuscu(ActionEvent event) throws IOException{
    	SalleController.salleMuscu.setNbPlace(SalleController.salleMuscu.getNbPlace() + 1);
    			// Recalcule de toutes les autres données
    	nbPlaceM.setText((SalleController.salleMuscu.getNbPlace()).toString());
    	nbPlaceOccupeeM.setText((SalleController.salleMuscu.getNbPlaceOccupee()).toString());
    	nbPlaceLibreM.setText((SalleController.salleMuscu.getNbPlaceLibre()).toString());
    	tauxOccupationM.setText((SalleController.salleMuscu.getTauxOccupation()).toString() + " %");
    }
    
    @FXML		// Ajout de place dans la salle de fitness
    void onClickMoinsFitness(ActionEvent event) throws IOException{
    	SalleController.salleFitness.setNbPlace(SalleController.salleFitness.getNbPlace() - 1);
    			// Recalcule de toutes les autres données
    	nbPlaceF.setText((SalleController.salleFitness.getNbPlace()).toString());
    	nbPlaceOccupeeF.setText((SalleController.salleFitness.getNbPlaceOccupee()).toString());
    	nbPlaceLibreF.setText((SalleController.salleFitness.getNbPlaceLibre()).toString());
    	tauxOccupationF.setText((SalleController.salleFitness.getTauxOccupation()).toString() + " %");    
    }
    
    @FXML		// Suppresion de place dans la salle de fitness
    void onClickPlusFitness(ActionEvent event) throws IOException{
    	SalleController.salleFitness.setNbPlace(SalleController.salleFitness.getNbPlace() + 1);
    			// Recalcule de toutes les autres données
    	nbPlaceF.setText((SalleController.salleFitness.getNbPlace()).toString());
    	nbPlaceOccupeeF.setText((SalleController.salleFitness.getNbPlaceOccupee()).toString());
    	nbPlaceLibreF.setText((SalleController.salleFitness.getNbPlaceLibre()).toString());
    	tauxOccupationF.setText((SalleController.salleFitness.getTauxOccupation()).toString() + " %");    
    }
    
    // Au clic, quitter l'application
    public void onClickQuitter() {
    	System.exit(0);
    }
}
