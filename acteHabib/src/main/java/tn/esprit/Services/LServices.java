package tn.esprit.Services;

import tn.esprit.entities.FamilleActe;
import tn.esprit.entities.Pathologie;
import tn.esprit.entities.Patient;

public interface LServices {
	public Pathologie ajouterPathologie(Pathologie path);
	public Patient ajouterPAtientEtAffecterAPathologie(Patient p ,String codePath);
	public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte);
	public void affecterActeAPathologie(String codeActe , String codePathologie);
	public float calculerFacture(String identifiant);
	public void calculerNombreActesPArPathologie();
}
