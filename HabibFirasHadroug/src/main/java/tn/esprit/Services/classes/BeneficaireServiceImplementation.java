package tn.esprit.Services.classes;

import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.DAO.Entities.Assurance;
import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.DAO.Entities.Contrat;
import tn.esprit.DAO.Entities.typeContrat;
import tn.esprit.DAO.Repository.AssuranceRepository;
import tn.esprit.DAO.Repository.BeneficaireRepository;
import tn.esprit.DAO.Repository.ContratRepository;
import tn.esprit.Services.interfaces.BenficaireService;
@Service
public class BeneficaireServiceImplementation implements BenficaireService  {
	@Autowired
	BeneficaireRepository beneficaireRepository;
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	AssuranceRepository assuranceRepository;
	@Override
	public int ajouterBeneficaire(Beneficaire bf) {
		if((bf.getCin()!=0)&&(bf.getProfession()!="")&&(bf.getSalaire()!=0)) {
		bf = beneficaireRepository.save(bf);
	} 		return bf.getIdBenef();

		}
	@Transactional
	@Override
	public int ajouterAssurance (Assurance a, int cinBf) {
		Beneficaire bf=beneficaireRepository.getByCin(cinBf);
		a.setBeneficaire(bf);
		Contrat c = contratRepository.save(a.getContrat());
		a.setContrat(c);
		return assuranceRepository.save(a).getIdAssurance();
	}
	@Override
	public float getMontantBf(int cinBf) {
		Beneficaire bf = beneficaireRepository.getByCin(cinBf);
		float montant = 0;
		for (int i=0 ; i < bf.getAssurance().size(); i++) {
			if (bf.getAssurance().get(i).getContrat().getType()==typeContrat.Mensuel) {
				montant += bf.getAssurance().get(i).getMontant() * 12;
			} else if (bf.getAssurance().get(i).getContrat().getType()==typeContrat.Semestriel) {
				montant += bf.getAssurance().get(i).getMontant() * 2;

			} else {
				montant += bf.getAssurance().get(i).getMontant();

			}
		}
		return montant;
	}
	@Override
	public Set<Beneficaire> getBeneficairesAsType(typeContrat typeContrat) {
		return 	beneficaireRepository.getBeneficairesAsType(typeContrat);

	}
	@Override
	@Scheduled(cron = "*/60 * * * * *" )
	public void statistiques() {
		TreeMap<Integer, Integer> tree_map = new TreeMap<>(Collections.reverseOrder());
		
	}


}

