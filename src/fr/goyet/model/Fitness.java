package fr.goyet.model;

public class Fitness implements Salle {
	
	private String nomSalle = "Fitness";
	private static int nbPlace = 5;
	private static int nbPlaceOccupee = 0;
	
	/**
	 * Constructeur vide
	 */
	public Fitness() {
	}

	@Override		// Retourne le nom de la salle
	public String getNomSalle() {
		return nomSalle;
	}

	@Override		// Retourne le nombre de place
	public Integer getNbPlace() {
		return nbPlace;
	}
	
	// Définit le nombre de place
	public void setNbPlace(Integer nbPlace) {
		Fitness.nbPlace= nbPlace;
	}

	@Override		// Retourne le nombre de places occupées
	public Integer getNbPlaceOccupee() {
		return nbPlaceOccupee;
	}

	@Override		// Retourne le taux d'occupation
	public Double getTauxOccupation() {
		double nbPlaceOccupees = nbPlaceOccupee;
        double nbPlaces = nbPlace;
        Double tauxOccupation = (nbPlaceOccupees / nbPlaces) * 100.0;
        tauxOccupation = (double) Math.round(tauxOccupation*100.0)/100.0;
        return tauxOccupation;
	}
	
	// Ajoute quelqu'un dans la salle
	public void addFitnessPeople() {
		nbPlaceOccupee++;
	}
	
	// Supprime quelqu'un de la salle
	public void removePeople() {
		nbPlaceOccupee = nbPlaceOccupee -1;
	}

	@Override		// Retourne le nombre de places libres
	public Integer getNbPlaceLibre() {
		return nbPlace - nbPlaceOccupee;
	}
}
