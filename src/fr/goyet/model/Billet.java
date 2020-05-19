package fr.goyet.model;

public class Billet {
	
	// Variable
	private static Integer compteurBilletEntree = 0;
	private static Integer compteurBilletSortie = 0;
	
	private Integer numBilletEntree;
	private Integer numBilletSortie;
	private String nomSalle;
	private String date;
	private String heure;
	private Double montant;
		
	/**
	 * Constructeur de billet de sortie
	 * @param date
	 * @param heure
	 * @param montant
	 */
	public Billet(String date, String heure, Double montant) {
		this.setNumBilletSortie(compteurBilletSortie);
		this.date = date;
		this.heure = heure;
		this.montant = montant;

		Billet.compteurBilletSortie = Billet.compteurBilletSortie+1;
	}	

	/**
	 * Constructeur de billet d'entrée
	 * @param nomSalle
	 * @param date
	 * @param heure
	 */
	public Billet(String nomSalle, String date, String heure) {
		this.setNumBilletEntree(compteurBilletEntree);
		this.nomSalle = nomSalle;
		this.date = date;
		this.heure = heure;
		
		Billet.compteurBilletEntree = compteurBilletEntree+1;
	}
	
	// Définition du numéro du billet de sortie
	private void setNumBilletSortie(Integer compteurBilletSortie) {
		numBilletSortie = compteurBilletSortie + 1;		// ancien numéro de billet + 1
	}
	
	/**
	 * Définition du numéro du billet d'entrée
	 * @param compteurBilletEntree
	 */
	private void setNumBilletEntree(Integer compteurBilletEntree) {
		numBilletEntree = compteurBilletEntree + 1;		// ancien numéro de billet + 1
	}
	
	/**
	 * @return le nom de la salle
	 */
	public String getNomSalle() {
		return nomSalle;
	}
	
	/**
	 * Définit le nom de la salle
	 * @param nomSalle
	 */
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	
	/**
	 * @return la date du billet
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Définit la date du billet
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @return l'heure du billet
	 */
	public String getHeure() {
		return heure;
	}
	
	/**
	 * Définit l'heure du billet
	 * @param heure
	 */
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	/**
	 * @return le montant du billet
	 */
	public Double getMontant() {
		return montant;
	}
	
	/**
	 * Définit la valeur du montant du billet
	 * @param montant
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return le numéro du billet d'entrée
	 */
	public Integer getNumBilletEntree() {
		return numBilletEntree;
	}

	/**
	 * @return le numéro du billet de sortie
	 */
	public Integer getNumBilletSortie() {
		return numBilletSortie;
	}
}
