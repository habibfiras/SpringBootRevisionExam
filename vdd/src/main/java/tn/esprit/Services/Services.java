package tn.esprit.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.ClassPlace;
import tn.esprit.entities.EtatReservation;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.Vol;
import tn.esprit.entities.Voyageur;
import tn.esprit.Repositories.ReservationRepo;
import tn.esprit.Repositories.VolRepo;
import tn.esprit.Repositories.VoyageurRepo;

@Service
@Slf4j
@Transactional
public class Services implements lServices {
	@Autowired
    VolRepo volRepo;
	@Autowired
	VoyageurRepo voyageurRepo;
	@Autowired
	ReservationRepo reservationRepo;
	@Override
	public String ajouterVolEtAeroprt(Vol vol) {
		if( vol.getAArrive().getCodeAITA()==vol.getADepart().getCodeAITA()) {
			return "verifier !" ;

		}
		
		return "le vol succes!!!"+volRepo.save(vol).getIdVol();

	}
	@Override
	public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs) {
		return voyageurRepo.saveAll(voyageurs);
		
	}
	@Override
	@Transactional
	public String reserverVol(int voyageurId, int volId, ClassPlace classPlace) {
        String str = "";

		Voyageur voyageur = voyageurRepo.findById(voyageurId).get();
		Vol vol = volRepo.findById(volId).get();
		Reservation reservation = new Reservation();
		if(classPlace.toString().equals("ECONOMIQUE")) {
			if(reservationRepo.find(volId,classPlace.ECONOMIQUE,EtatReservation.ENCOURS).size() <3) {
		reservation.setIdReservation(classPlace.toString().substring(0,3)+"-"+vol.getIdVol()+"-"+voyageur.getIdVoyageur());
		reservation.setDateReservation(new Date());
		reservation.setEtatReservation(EtatReservation.ENCOURS);
	    reservation.setClassPlace(classPlace);
        reservation.setVol(vol);
        reservation.setVoyageur(voyageur);
        reservation = reservationRepo.save(reservation);
        
 
        str = "L'affectation du voyageur est effectué avec succés.L'ID de la réservation est: " + reservation.getIdReservation();
}
			else {
	            str = "La classe Business du vol " + vol.getIdVol() + " est complet";

			}
		} else if(classPlace.toString().equals("BUSINESS")) {
			if(reservationRepo.find(volId, classPlace.BUSINESS,EtatReservation.ENCOURS).size() < 2) {
				reservation.setIdReservation(classPlace.toString().substring(0,3)+"-"+vol.getIdVol()+"-"+voyageur.getIdVoyageur());
				reservation.setDateReservation(new Date());
				reservation.setEtatReservation(EtatReservation.ENCOURS);
			    reservation.setClassPlace(classPlace);
		        reservation.setVol(vol);
		        reservation.setVoyageur(voyageur);
				 reservation = reservationRepo.save(reservation);
				 
				 
	                str = "L'affectation du voyageur est effectué avec succés.L'ID de la réservation est: " + reservation.getIdReservation();
			}
			else {
                str = "La classe Economique du vol " + vol.getIdVol() + " est complet";
            }
		}
		System.out.println("!1!"+reservationRepo.find(volId, classPlace.BUSINESS,EtatReservation.ENCOURS).size());
		System.out.println("!2!"+reservationRepo.find(volId, classPlace.ECONOMIQUE,EtatReservation.ENCOURS).size());

		return str;
	}
	@Override
	public Reservation confirmerReservation(String resId) {
		Reservation res = reservationRepo.findById(resId).get();
  		res.setEtatReservation(EtatReservation.CONFIRME);
  		return res;
	}
	@Override
	public Map<Integer, List<Voyageur>> getVoyageurByVol() {
		Map<Integer, List<Voyageur>> map = new HashMap<>();
		 List<Voyageur> l = new ArrayList<>();
		 for (Vol v : volRepo.findByDateDepart(new Date())) {
			 for(Reservation r :v.getReservations()) {
				 if(r.getEtatReservation().toString().equals(EtatReservation.CONFIRME.toString())) {
					 l.add(r.getVoyageur());

				 }




			 }
			 map.put(v.getIdVol(),l);
			 System.out.println("!!idVol!!"+v.getIdVol());
			
		 }
		return map;
	}
	@Override
	@Scheduled(cron = "*/60 * * * * *" )
	public void annulerReservation() {
		for(Reservation r :reservationRepo.findAll()) {
			 if(r.getEtatReservation().toString().equals(EtatReservation.ENCOURS.toString())) {
				 if(calculDiff(r.getVol().getDateDepart(),new Date()) <=1) {
					 r.setEtatReservation(EtatReservation.ANNULEE);
					 reservationRepo.save(r);
		                log.info("Reservation annulé: " + r.getIdReservation() + "\n");
				 }
			 }
		}
		
	}
    public long calculDiff(Date dateDepart, Date dateArrivee) {
        long diffInMillies = dateArrivee.getTime() - dateDepart.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    

}
}