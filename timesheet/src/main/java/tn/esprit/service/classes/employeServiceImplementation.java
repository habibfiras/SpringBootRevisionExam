package tn.esprit.service.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.contrat;
import tn.esprit.persistance.departement;
import tn.esprit.persistance.employe;
import tn.esprit.persistance.repositories.contratRepository;
import tn.esprit.persistance.repositories.departementRepository;
import tn.esprit.persistance.repositories.employeRepository;
import tn.esprit.service.Interfaces.employeService;

@Service
public class employeServiceImplementation implements employeService {
	@Autowired
	employeRepository employeRepository;
	@Autowired
	departementRepository departementRepository;
	@Autowired
	contratRepository contratRepository;
	@Override
	public int ajouterEmploye(employe employe) {
		return employeRepository.save(employe).getIdEmploye();
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		employe emp = employeRepository.findById(employeId).get();
		departement dep = departementRepository.findById(depId).get();
		if(dep.getEmployes() ==null) {
			List<employe> listE = new ArrayList<>();
			listE.add(emp);
			dep.setEmployes(listE);
		} else {
			dep.getEmployes().add(emp);
		}
	}

	@Override
	public int ajouterContrat(contrat contrat) {
		return contratRepository.save(contrat).getReference();
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		contrat cr = contratRepository.findById(contratId).get();
		employe emp = employeRepository.findById(employeId).get();
		emp.setContrat(cr);
		employeRepository.save(emp); 
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		employe emp = employeRepository.findById(employeId).get();
		return emp.getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		return employeRepository.NombreEmployeJPQL();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		return employeRepository.AllEmployeNamesJPQL();
	}
	

}
