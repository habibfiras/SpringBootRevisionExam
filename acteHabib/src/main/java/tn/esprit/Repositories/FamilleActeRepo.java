package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.FamilleActe;

@Repository
public interface FamilleActeRepo extends JpaRepository<FamilleActe, Long> {

}
