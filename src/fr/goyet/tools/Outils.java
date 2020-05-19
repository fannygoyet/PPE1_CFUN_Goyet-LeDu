package fr.goyet.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import fr.goyet.model.Billet;

public class Outils {
	
	// Récupération du billet en cours, retourne le dernier billet enregistré
	public static Billet recupBilletEnCours(ArrayList<Billet> listeBillet) {
		return listeBillet.get(listeBillet.size() - 1);
    }
	
	// Calcul du temps passé en salle
	public static int calculTemps(String deb, String fin) throws ParseException {
		Date HD = new SimpleDateFormat("hh:mm").parse(deb);		// Récupération et formatage de l'horaire de début
		Date HF = new SimpleDateFormat("hh:mm").parse(fin);		// Récupération et formatage de l'horaire de fin
		
		GregorianCalendar cal = new GregorianCalendar();		// Création du calendrier grégorien
		
		cal.setTime(HF);										// Initialisation de l'horaire de fin sur le calendrier grégorien
		int finH = cal.get(Calendar.HOUR);						// Enregistrement de l'horaire en nombre entier
		cal.setTime(HD);										// Initialisation de l'horaire de début sur le calendrier grégorien
		int debH = cal.get(Calendar.HOUR);						// Enregistrement de l'horaire en nombre entier
		return finH - debH;										// Soustraction de l'heure de fin moins celle du début
	}

	
	// Calcul du montant
	public static Double calculMontant(Integer temps) {
    	double montant = 0;						// Initialisation de la variable
    	if(temps <= 60) {						// Si le temps est inférieur à 60 (minutes)
			if(temps >= 0 && temps <= 15) {		// Si 0 < temps <= 15
				montant = 0;					// Le montant = 0
			} 
			if(temps > 15 && temps <= 30) {		// Si 15 < temps <= 30
				montant = 0.50;					// Le montant = 0.50 euros
			}
			if (temps >30 && temps <= 60) {		// Si 30 < temps <= 60
				montant = 1;					// Le montant = 1 euro
			}
    	} else if(temps > 60){					// Si le temps est supérieur à une erreur 
    		montant = 1;						// Initialisation du montant à 1
    		for(int i = 60; i <= temps; i = i + 15) { 	// Pour chaque quart d'heure supplémentaire
    			montant += 0.5;					// 0.50 euros s'ajoutent au montant
    		}
    	}
    	return montant;							// Retourne le montant
    }
}