package tn.esprit.service.Interfaces;

import java.util.List;

import tn.esprit.persistance.contrat;
import tn.esprit.persistance.employe;


public interface employeService {
	public int ajouterEmploye(employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public int ajouterContrat(contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
}
