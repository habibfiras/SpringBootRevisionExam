package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Cuisinier;

@Repository
public interface CuisinierRepo extends JpaRepository<Cuisinier, Integer> {

}
