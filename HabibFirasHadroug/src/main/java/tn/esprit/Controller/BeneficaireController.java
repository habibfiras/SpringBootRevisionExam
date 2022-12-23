package tn.esprit.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.DAO.Entities.Assurance;
import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.DAO.Entities.typeContrat;
import tn.esprit.Services.interfaces.BenficaireService;

@RestController
@RequestMapping("/beneficaire")

public class BeneficaireController {
	@Autowired
	BenficaireService benficaireService;
	@PostMapping("/addbenef")
	@ResponseBody
	public int addbenef(@RequestBody Beneficaire eq) {
		return benficaireService.ajouterBeneficaire(eq);
	}
	@PostMapping("/ajouterAssurance/{cinBf}")
	@ResponseBody
	public int ajouterAssurance(@RequestBody Assurance a, @PathVariable("cinBf") int cinBf) {
		return benficaireService.ajouterAssurance(a,cinBf );
	}
	@GetMapping("/montant/{mnt}")
	public float getMontantBf (@PathVariable("mnt") int mnt) {
		return benficaireService.getMontantBf(mnt);
	}
	@GetMapping("/typeContrat/{type}")
	public Set<Beneficaire> getbeneff(@PathVariable("type") typeContrat type ) {
		return benficaireService.getBeneficairesAsType(type);
	}

	

}
