package tn.esprit.Rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Boutique;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long>{

}
