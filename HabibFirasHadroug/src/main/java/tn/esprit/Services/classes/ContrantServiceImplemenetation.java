package tn.esprit.Services.classes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.DAO.Entities.Assurance;
import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.DAO.Entities.Contrat;
import tn.esprit.DAO.Repository.BeneficaireRepository;
import tn.esprit.Services.interfaces.ContratService;

public class ContrantServiceImplemenetation implements ContratService {
	@Autowired
	BeneficaireRepository beneficaireRepository;
	@Override
	public Contrat getContratBf(int idBf) {
		Beneficaire bf = beneficaireRepository.findById(idBf).orElse(null);
		Contrat c = bf.getAssurance().get(0).getContrat();
		Date oldDate = c.getDateEffet();
		for (int i = 0 ; i < bf.getAssurance().size(); i++) {
			Assurance as = bf.getAssurance().get(i);
			if(oldDate.after(as.getContrat().getDateEffet())) {
				c = as.getContrat();
			}
		}
		return c ;
	}

}
