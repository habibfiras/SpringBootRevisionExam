package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Logistique;

@Repository
public interface LogistiqueRepo extends JpaRepository<Logistique, Integer> {

}
