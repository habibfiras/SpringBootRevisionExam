package tn.esprit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.Services.LServices;
import tn.esprit.entities.FamilleActe;
import tn.esprit.entities.Pathologie;
import tn.esprit.entities.Patient;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("restControllers")
public class RestController {
	@Autowired
	LServices lServices;
	@PostMapping("/ajouterPathologie")
	@ResponseBody
	public Pathologie ajouterPathologie(@RequestBody Pathologie path) {
		return lServices.ajouterPathologie(path);
	}
	@PostMapping("/ajouterPAtientEtAffecterAPathologie")
	@ResponseBody
	public Patient ajouterPAtientEtAffecterAPathologie(@RequestBody Patient p,@RequestParam String codePath) {
		return lServices.ajouterPAtientEtAffecterAPathologie(p, codePath);
	}
	@PostMapping("/ajouterFamilleActeEtActeAssocie")
	@ResponseBody
	public FamilleActe ajouterFamilleActeEtActeAssocie(@RequestBody FamilleActe facte) {
		return lServices.ajouterFamilleActeEtActeAssocie(facte);
	}
	@PutMapping("/affecterActeAPathologie")
	public void affecterActeAPathologie(@RequestParam String codeActe,@RequestParam String codePathologie) {
		 lServices.affecterActeAPathologie(codeActe, codePathologie);
	}
	@GetMapping("/calculerFacture")
	public float calculerFacture(@RequestParam String identifiant) {
		return lServices.calculerFacture(identifiant);
	}
}
