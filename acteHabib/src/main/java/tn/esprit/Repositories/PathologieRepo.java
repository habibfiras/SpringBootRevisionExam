package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Pathologie;

@Repository
public interface PathologieRepo extends JpaRepository<Pathologie, Long> {
	public Pathologie findPathologieByCodePath(String codePath);
	public Pathologie findPathologieByLibelle(String libelle);
	
	

}
