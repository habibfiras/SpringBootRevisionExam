package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Evenement;

@Repository
public interface EvenementRepo extends JpaRepository<Evenement, Integer> {
	public Evenement findEvenementByDescription(String descriptionEvnmt);
}
