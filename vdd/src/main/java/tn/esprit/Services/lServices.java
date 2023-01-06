package tn.esprit.Services;

import java.util.List;
import java.util.Map;

import tn.esprit.entities.ClassPlace;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.Vol;
import tn.esprit.entities.Voyageur;

public interface lServices {
	String ajouterVolEtAeroprt(Vol vol);
	List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs);
	String reserverVol(int voyageurId,int volId, ClassPlace classPlace);
	Reservation confirmerReservation(String resId);
	Map<Integer,List<Voyageur>> getVoyageurByVol();
	void annulerReservation();
	
}
