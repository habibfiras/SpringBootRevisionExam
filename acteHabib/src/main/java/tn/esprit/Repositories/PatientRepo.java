package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

}
