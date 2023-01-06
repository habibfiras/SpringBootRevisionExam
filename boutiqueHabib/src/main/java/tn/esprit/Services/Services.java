package tn.esprit.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.Rep.BoutiqueRepository;
import tn.esprit.Rep.CentreCommercialRepository;
import tn.esprit.Rep.ClientRepository;
import tn.esprit.entities.Boutique;
import tn.esprit.entities.Categories;
import tn.esprit.entities.CentreCommercial;
import tn.esprit.entities.Client;
import tn.esprit.entities.Genre;

@Service
@Transactional
@Slf4j
public class Services implements LServices  {
	@Autowired
	CentreCommercialRepository centreCommercialRepository;
	@Autowired
	BoutiqueRepository boutiqueRepository;
	@Autowired
	ClientRepository clientRepository;
	@Override
	@Transactional
	public void ajoutCentre(CentreCommercial centre) {
		for(Boutique b : centre.getBoutiques()) {
			b.setCentreCommercial(centre);
		}
		centreCommercialRepository.save(centre);
		
	}
	@Override
	public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
		CentreCommercial cc = centreCommercialRepository.findById(idCentre).get();
		for(Boutique b : lb) {
			b.setCentreCommercial(cc);
		}
		boutiqueRepository.saveAll(lb);
	}
	@Override
	public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
		Set<Boutique> sb = new HashSet<Boutique>();
		for(Long i : idBoutiques) {
			Boutique b = boutiqueRepository.findById(i).get();
			b.getClients().add(client);
			//sb.add(b);
		}
		client.setBoutiques(sb);
		clientRepository.save(client);
	}
	@Override
	public List<Client> listeClients(Long idBoutique) {
		List<Client> lc = new ArrayList<>();
		Boutique b = boutiqueRepository.findById(idBoutique).get();
		for(Client c : b.getClients()) {
			lc.add(c);
		}
		return lc;
	}
	@Override
	public List<Boutique> listeBoutiques(Long idCentre) {
		List<Boutique> lb = new ArrayList<>();
		CentreCommercial cc = centreCommercialRepository.findById(idCentre).get();
		for (Boutique b : cc.getBoutiques()) {
			lb.add(b);
		}
		return lb;
	}
	@Override
	public List<Client> listeDeClientsParCategorie(Categories categorie) {
		boolean test = false;
		List<Client> lc = new ArrayList<>();
		for(Client c : clientRepository.findAll()) {
			for(Boutique b : c.getBoutiques()) {
				if (b.getCategories().toString().equals(categorie.toString())){
					test = true;
				}
				if(test) {
					lc.add(c);
				}
			}
		}
		return lc;
	}
	@Override
	@Scheduled(cron = "*/30 * * * * *")
	public void nbreClientParGenre() {
		int m=0,f=0;
		
		for(Client c : clientRepository.findAll()) {
			if(c.getGenre().toString().equals(Genre.MASCULIN.toString())) {
				m++;
			} else {
				f++;
			}
			log.info("fem "+f+" masc "+m);

		}
		
	}

}
