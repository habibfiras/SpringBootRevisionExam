package tn.esprit.Services;

import java.util.Date;
import java.util.List;

import tn.esprit.entities.Evenement;
import tn.esprit.entities.Logistique;
import tn.esprit.entities.Participant;

public interface LServices {
	public Participant ajouterPArticipant(Participant p);
	public Evenement ajouterAffectEvenParticip(Evenement e);
	public Logistique ajoutAffectLogEvnm(Logistique l,String descriptionEvnmt);
	public List<Logistique> getLogistiqyeDates( Date dateDeb , Date dateFin);
	public List<Participant> getParReservLogis();
	public void calculCout();
}
