package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Client;
import tn.esprit.entities.Cuisinier;
import tn.esprit.entities.Plat;
import tn.esprit.services.LService;

@RestController
@RequestMapping("restControllers")
public class RestControllers {
	@Autowired
	LService lService;
	
	  @PostMapping("/ajouterVolEtAeroport")
	  @ResponseBody
	  public Client ajouterClient(@RequestBody Client client) {
		  return lService.ajouterClient(client);
	  }
	  @PostMapping("/ajouterCuisinier")
	  @ResponseBody
	  public void ajouterCuisinier(@RequestBody Cuisinier cuisinier) {
		  lService.ajouterCuisinier(cuisinier);
	  }
	  @PostMapping("/ajouterPlatAffecterClientEtCisinier")
	  @ResponseBody
	  public void ajouterPlatAffecterClientEtCisinier(@RequestBody Plat plat,@RequestParam Integer idClient,@RequestParam Integer idCuisinier) {
		  lService.ajouterPlatAffecterClientEtCisinier(plat, idClient, idCuisinier);
	  }
	  @GetMapping("/AfficherListePlatsParClient")
	  public List<Plat> AfficherListePlatsParClient(@RequestParam String nom,@RequestParam String prenom) {
		  return lService.AfficherListePlatsParClient(nom, prenom);
		}
	  @GetMapping("/MontantApayerParClient")
		public float MontantApayerParClient(@RequestParam Integer idClient) {
		  return lService.MontantApayerParClient(idClient);
	  }
	  @GetMapping("/ModifierImc")
		public void ModifierImc(@RequestParam Integer idclient) {
		   lService.ModifierImc(idclient);
	  }
}
