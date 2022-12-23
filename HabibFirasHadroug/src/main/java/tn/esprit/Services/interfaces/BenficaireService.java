package tn.esprit.Services.interfaces;

import java.util.Set;

import tn.esprit.DAO.Entities.Assurance;
import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.DAO.Entities.typeContrat;

public interface BenficaireService {
	public int ajouterBeneficaire (Beneficaire bf);
	public int ajouterAssurance (Assurance a, int cinBf);
	public float getMontantBf (int cinBf);
	public Set<Beneficaire> getBeneficairesAsType(typeContrat typeContrat);
	public void statistiques ();
}
