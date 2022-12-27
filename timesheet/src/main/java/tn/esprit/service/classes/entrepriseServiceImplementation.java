package tn.esprit.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.departement;
import tn.esprit.persistance.entreprise;
import tn.esprit.persistance.repositories.departementRepository;
import tn.esprit.persistance.repositories.entrepriseRepository;
import tn.esprit.service.Interfaces.entrepriseService;

@Service
public class entrepriseServiceImplementation implements entrepriseService  {
	@Autowired
	entrepriseRepository entrepriseRepository;
	@Autowired
	departementRepository departementRepository;
	

	@Override
	public int ajouterEntreprise(entreprise entreprise) {
		return entrepriseRepository.save(entreprise).getIdEntreprise();
	}

	@Override
	public int ajouterDepartement(departement dep) {
		return departementRepository.save(dep).getIdDepartement();
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		departement dep = departementRepository.findById(depId).get();
		entreprise ent = entrepriseRepository.findById(entrepriseId).get();
		dep.setEntreprise(ent);
		departementRepository.save(dep);
		
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> ls = new ArrayList<>();
		entreprise ent = entrepriseRepository.findById(entrepriseId).get();
		for (departement dep : ent.getDepartements()) {
			ls.add(dep.getName());
		}
		return ls;
	}

}
