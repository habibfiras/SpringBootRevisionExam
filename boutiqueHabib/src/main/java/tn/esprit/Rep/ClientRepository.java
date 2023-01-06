package tn.esprit.Rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
