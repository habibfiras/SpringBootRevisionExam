package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Services.LServices;
import tn.esprit.entities.Boutique;
import tn.esprit.entities.Categories;
import tn.esprit.entities.CentreCommercial;
import tn.esprit.entities.Client;

@RestController
@RequestMapping("restControllers")
public class Controller {
	@Autowired
	LServices lServices;
	
	 @PostMapping("/add")
	public void ajoutCentre(@RequestBody CentreCommercial centre) {
		  lServices.ajoutCentre(centre);
	 }
	 @PostMapping("/ajouterEtAffecterlisteBoutiques")
	public void ajouterEtAffecterlisteBoutiques(@RequestBody List<Boutique> lb,@RequestParam Long idCentre) {
		 lServices.ajouterEtAffecterlisteBoutiques(lb, idCentre);
	}
	 @PostMapping("/ajouterEtAffecterClientBoutiques")
		public void ajouterEtAffecterClientBoutiques(@RequestBody Client client,@RequestParam List<Long> idBoutiques) {
		 lServices.ajouterEtAffecterClientBoutiques(client, idBoutiques);
	 }
	 @GetMapping("/listeClients")
	 public List<Client> listeClients(@RequestParam Long idBoutique){
		 return lServices.listeClients(idBoutique);
	 }
	 @GetMapping("/listeBoutiques")
	public List<Boutique> listeBoutiques(@RequestParam Long idCentre) {
		 return lServices.listeBoutiques(idCentre);
	 }
	 @GetMapping("/listeDeClientsParCategorie")
	public List<Client> listeDeClientsParCategorie(@RequestParam Categories categorie) {
		 return lServices.listeDeClientsParCategorie(categorie);
	}




}
