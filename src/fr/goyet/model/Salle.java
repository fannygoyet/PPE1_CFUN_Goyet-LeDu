package fr.goyet.model;

public interface Salle {
	String getNomSalle();				// Retourne le nom de la salle
    Integer getNbPlace();				// Retourne le nombre de place
    void setNbPlace(Integer nbPlace);	// Définit le nombre de place
    Integer getNbPlaceOccupee();		// Retourne le nombre de places occupées
    Integer getNbPlaceLibre();			// Retourne le nombre de places libres
    Double getTauxOccupation();			// Retourne le taux d'occupation
}
