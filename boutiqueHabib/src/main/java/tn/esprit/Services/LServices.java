package tn.esprit.Services;

import java.util.List;

import tn.esprit.entities.Boutique;
import tn.esprit.entities.Categories;
import tn.esprit.entities.CentreCommercial;
import tn.esprit.entities.Client;

public interface LServices {
	void ajoutCentre(CentreCommercial centre);
	void ajouterEtAffecterlisteBoutiques (List<Boutique> lb, Long idCentre);
	void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
	List<Client> listeClients(Long idBoutique);
	List<Boutique> listeBoutiques(Long idCentre) ;
	List<Client> listeDeClientsParCategorie(Categories categorie) ;
	void nbreClientParGenre();





}
