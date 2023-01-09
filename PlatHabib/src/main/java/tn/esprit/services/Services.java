package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Categorie;
import tn.esprit.entities.Client;
import tn.esprit.entities.Cuisinier;
import tn.esprit.entities.Imc;
import tn.esprit.entities.Plat;
import tn.esprit.repositories.ClientRepo;
import tn.esprit.repositories.CuisinierRepo;
import tn.esprit.repositories.PlatRepo;

@Service
@Slf4j
@Transactional
public class Services implements LService{
	@Autowired
	ClientRepo clientRepo;
	@Autowired
	CuisinierRepo cuisinierRepo;
	@Autowired
	PlatRepo platRepo;

	@Override
	public Client ajouterClient(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public void ajouterCuisinier(Cuisinier cuisinier) {
		 cuisinierRepo.save(cuisinier);
	}

	@Override
	public void ajouterPlatAffecterClientEtCisinier(Plat plat ,Integer idClient,Integer idCuisinier) {
		int somme =0;
		Client cl = clientRepo.findById(idClient).get();
		Cuisinier cu = cuisinierRepo.findById(idCuisinier).get();
		for(Plat p : cl.getPlats()) {
			if(p.getCategorie().toString().equals(Categorie.PRINCIPAL.toString())) {
				somme++;
			}
		}
		if(somme<=2) {
			plat.setClient(cl);
			
			if(cu.getPlats()==null) {
				List<Plat> plc = new ArrayList<>();
				plc.add(plat);
				cu.setPlats(plc);
			}
			else {
				cu.getPlats().add(plat);
			}
			platRepo.save(plat);
		}
	}

	@Override
	public List<Plat> AfficherListePlatsParClient(String nom, String prenom) {
		List<Plat> pl = new ArrayList<>();
		Client cl = clientRepo.findClientByNomAndPrenom(nom, prenom);
		for(Plat p : platRepo.findAll()) {
			if((p.getClient().getNom().toString().equals(nom.toString()))&&(p.getClient().getPrenom().toString().equals(prenom.toString()))){
				pl.add(p);
			}
		}
		return pl;
	}

	@Override
	public float MontantApayerParClient(Integer idClient) {
		float somme =0;
		Client cl = clientRepo.findById(idClient).get();
		for(Plat p : platRepo.findAll()) {
			if(p.getClient()==cl){
				somme += p.getPrix();
			}
		}
		return somme;
	}

	@Override
	public void ModifierImc(Integer idclient) {
		float imc =0;
		Client cl = clientRepo.findById(idclient).get();
		for(Plat p : platRepo.findAll()) {
			if(p.getClient()==cl){
				imc += p.getCalories();
			}
		}
		if(imc<2000) {
			cl.setImc(Imc.FAIBLE);
		}
		else if (imc == 2000) {
			cl.setImc(Imc.IDEAL);
		} else {
			cl.setImc(Imc.FORT);
		}
		System.out.println(imc);
		
	}

	@Override
	@Scheduled(cron = "*/15 * * * * *" )
	public void AfficherListeCuisinier() {
		int s=0;
		for(Cuisinier c : cuisinierRepo.findAll()) {
			for(Plat p : c.getPlats()) {
				if(p.getCategorie().toString().equals(Categorie.PRINCIPAL.toString())) {
					s++;
					log.info(p.getLabel());
				}
				if(s>=2) {
					log.info("cuisinier "+c.getIdCuisinier());
				}
				
			}
			s=0;
		}
		
	}
	
}
