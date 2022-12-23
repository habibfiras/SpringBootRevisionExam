package tn.esprit.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.DAO.Entities.Assurance;
import tn.esprit.DAO.Entities.Beneficaire;

public interface AssuranceRepository extends JpaRepository<Assurance,Integer>{

}
