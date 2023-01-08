package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Acte;

@Repository
public interface ActeRepo extends JpaRepository<Acte, Long> {
	public Acte findActeByCodeActe (String codeActe);

}
