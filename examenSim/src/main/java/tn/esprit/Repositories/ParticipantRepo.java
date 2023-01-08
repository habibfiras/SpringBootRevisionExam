package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Participant;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Integer> {

}
