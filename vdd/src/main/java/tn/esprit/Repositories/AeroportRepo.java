package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Aeroport;


@Repository
public interface AeroportRepo extends JpaRepository<Aeroport, Integer> {

}
