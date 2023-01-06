package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Voyageur;

@Repository
public interface VoyageurRepo extends JpaRepository<Voyageur, Integer> {

}
