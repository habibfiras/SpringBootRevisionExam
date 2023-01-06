package tn.esprit.Rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.CentreCommercial;

@Repository
public interface CentreCommercialRepository extends JpaRepository<CentreCommercial, Long> {

}
