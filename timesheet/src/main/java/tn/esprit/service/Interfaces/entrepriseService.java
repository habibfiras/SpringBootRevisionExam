package tn.esprit.service.Interfaces;

import java.util.List;

import tn.esprit.persistance.departement;
import tn.esprit.persistance.entreprise;

public interface entrepriseService {
	public int ajouterEntreprise(entreprise entreprise);
	public int ajouterDepartement(departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
}
