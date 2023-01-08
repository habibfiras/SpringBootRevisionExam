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
import tn.esprit.Repositories.ActeRepo;
import tn.esprit.Repositories.FamilleActeRepo;
import tn.esprit.Repositories.PathologieRepo;
import tn.esprit.Repositories.PatientRepo;
import tn.esprit.entities.Acte;
import tn.esprit.entities.FamilleActe;
import tn.esprit.entities.Pathologie;
import tn.esprit.entities.Patient;

@Service
@Transactional
@Slf4j
public class Services implements LServices {
	@Autowired
	PathologieRepo pathologieRepo;
	@Autowired
	PatientRepo patientRepo;
	@Autowired
	FamilleActeRepo familleActeRepo;
	@Autowired
	ActeRepo acteRepo;
	@Override
	public Pathologie ajouterPathologie(Pathologie path) {
		path.setArchive(false);
		return pathologieRepo.save(path);
	}
	@Override
	@Transactional
	public Patient ajouterPAtientEtAffecterAPathologie(Patient p, String codePath) {
		Pathologie pth = pathologieRepo.findPathologieByCodePath(codePath);
		if(p.getPathologies()== null) {
			List<Pathologie> lpList = new  ArrayList<>();
			lpList.add(pth);
			p.setPathologies(lpList); 
			System.out.println("0");
		}
		else {
			p.getPathologies().add(pth);
			System.out.println("1");
		} 
		return patientRepo.save(p);
	}
	
	@Override
	@Transactional
	public FamilleActe ajouterFamilleActeEtActeAssocie(FamilleActe facte) {
		for(Acte a : facte.getActes()) {
			a.setFamilleActe(facte);
		}
		
		
		return familleActeRepo.save(facte);
	}
	@Override
	public void affecterActeAPathologie(String codeActe, String codePathologie) {
		Acte a = acteRepo.findActeByCodeActe(codeActe);
		Pathologie p = pathologieRepo.findPathologieByCodePath(codePathologie);
		if (p.archive== false) {
			
		
		if(a.getPathologies()== null) {
			List<Pathologie> lpList = new  ArrayList<>();
			lpList.add(p);
			a.setPathologies(lpList);
		}
		else {
			a.getPathologies().add(p);
			System.out.println("1");
		} 
		
		if(p.getActes() == null) {
			List<Acte> lpacte = new ArrayList<>();
			lpacte.add(a);
			p.setActes(lpacte);
		}
		else {
			p.getActes().add(a);
		}
		}
	}
	@Override
	public float calculerFacture(String identifiant) {
		float somme=0;
		Pathologie p =pathologieRepo.findPathologieByCodePath(identifiant);
		if(p==null) {
		 p =pathologieRepo.findPathologieByLibelle(identifiant);
			
		}
		for(Acte a : p.getActes()) {
			somme += a.getCotationActe()*a.getPrixUnitaireActe();
		}
		return somme;
	}
	@Override
	@Scheduled(cron = "*/30 * * * * *" )
	public void calculerNombreActesPArPathologie() {
		int somme =0;
		for(Pathologie p : pathologieRepo.findAll()) {
			for(Acte a : acteRepo.findAll()) {
				somme++;
			}
		}
			log.info("somm"+somme);
		}

}
