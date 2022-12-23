package tn.esprit.DAO.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.DAO.Entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat,Integer>{
	@Query(value="SELECT e from contrat JOIN beneficaire ON "
			,nativeQuery=true)
	public Contrat beneficaire(); 
}
