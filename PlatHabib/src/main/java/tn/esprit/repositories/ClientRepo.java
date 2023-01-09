package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
	public Client findClientByNomAndPrenom(String nom ,String prenom);
}
