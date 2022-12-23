package tn.esprit.DAO.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.DAO.Entities.typeContrat;

public interface BeneficaireRepository extends JpaRepository<Beneficaire,Integer> {
	Beneficaire getByCin(int cinBenef);
	@Query("select b From Beneficaire b join b.Assurance ass join ass.contrat c where c.type = :tc")
	public Set<Beneficaire> getBeneficairesAsType(@Param("tc") typeContrat tc);

}
