package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Client;
import tn.esprit.entities.Cuisinier;
import tn.esprit.entities.Plat;

public interface LService {
	public Client ajouterClient(Client client);
	public void ajouterCuisinier(Cuisinier cuisinier);
	public void ajouterPlatAffecterClientEtCisinier(Plat plat ,Integer idClient,Integer idCuisinier);
	List<Plat> AfficherListePlatsParClient(String nom ,String prenom);
	public float MontantApayerParClient(Integer idClient);
	public void ModifierImc(Integer idclient);
	public void AfficherListeCuisinier();
}
