package tn.esprit.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Repositories.EvenementRepo;
import tn.esprit.Repositories.LogistiqueRepo;
import tn.esprit.Repositories.ParticipantRepo;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Logistique;
import tn.esprit.entities.Participant;

@Service
@Slf4j
@Transactional
public class Serives implements LServices {
	@Autowired
	ParticipantRepo participantRepo;
	@Autowired
	EvenementRepo evenementRepo;
	@Autowired
	LogistiqueRepo logistiqueRepo;
	@Override
	public Participant ajouterPArticipant(Participant p) {
		return participantRepo.save(p);
	}
	@Override
	@Transactional
	public Evenement ajouterAffectEvenParticip(Evenement e) {		
		for( Participant pEV : e.getParticipants()) {
			for(Participant p : participantRepo.findAll()) {
				if((p.getNom().toString().equals(pEV.getNom().toString())) ) {
					if(e.getParticipants()== null) {
						List<Participant> lp = new ArrayList<>();
				//		lp.add(p);
						participantRepo.delete(p);
						System.out.println("1");

					}
					else {
						participantRepo.delete(p);
						//e.getParticipants().add(p);
						System.out.println("2");

					}
				
				}
			}
		}
		
		return evenementRepo.save(e);
	}
	@Override
	public Logistique ajoutAffectLogEvnm(Logistique l, String descriptionEvnmt) {
		Evenement ev = evenementRepo.findEvenementByDescription(descriptionEvnmt);
		if(ev.getLogistiques()== null) {
			List<Logistique> lg = new ArrayList<>();
			lg.add(l);
			ev.setLogistiques(lg);
		}
		else {
			ev.getLogistiques().add(l);
		}
		return logistiqueRepo.save(l);
	}
	@Override
	public List<Logistique> getLogistiqyeDates(Date dateDeb, Date dateFin) {
		List<Logistique> lg = new ArrayList<>();
		for(Evenement e : evenementRepo.findAll()) {
			for(Logistique l : e.getLogistiques()) {
				if((e.getDateDebut().compareTo(dateDeb)>0)&&(e.getDateFin().compareTo(dateFin)<0)) {
					lg.add(l);
				}
			}
		}
		return lg;
	}
	@Override
	public List<Participant> getParReservLogis() {
		List<Participant> lp = new ArrayList<>();
		for(Participant p : participantRepo.findAll()) {
			for(Evenement ev : p.getEvenements()) {
				for(Logistique lg : ev.getLogistiques()) {
					if(lg.isReserve()== false) {
						lp.add(p);
					}
				}
			}
		} 
		return lp;
	}
	@Override
	@Scheduled(fixedRate  = 10000)
	public void calculCout() {
		float somme=0;
		for(Evenement e : evenementRepo.findAll()) {
			for(Logistique l : e.getLogistiques()) {
				somme+= l.getPrixUnit()*l.getQuantite();
				
			}
			e.setCout(somme);
			log.info("somm : "+somme+" pour "+e.getDescription());
			somme = 0;
		}
		
	}
}
