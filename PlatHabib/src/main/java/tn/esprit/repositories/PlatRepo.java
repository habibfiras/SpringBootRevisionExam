package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Plat;

@Repository
public interface PlatRepo extends JpaRepository<Plat, Integer> {

}
