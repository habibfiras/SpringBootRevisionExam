package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.departement;
import tn.esprit.persistance.entreprise;
import tn.esprit.service.Interfaces.entrepriseService;

@RestController
public class entrepriseController {
	@Autowired
	entrepriseService entrepriseService;
	
	@PostMapping("/addentreprise")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody entreprise entreprise) {
		return entrepriseService.ajouterEntreprise(entreprise);
	}
	@PostMapping("/ajouterDepartement")
	@ResponseBody
	public int ajouterDepartement(@RequestBody departement departement) {
		return entrepriseService.ajouterDepartement(departement);
	}
	@PostMapping("/affecterDepartementAEntreprise/{depId}/{entrepriseId}")
	@ResponseBody
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		 entrepriseService.affecterDepartementAEntreprise(depId, entrepriseId);
	}
	@GetMapping("/getAllDepartementsNamesByEntreprise/{entrepriseId}")
	public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("entrepriseId") int entrepriseId) {
		return entrepriseService.getAllDepartementsNamesByEntreprise(entrepriseId);
	}


}
