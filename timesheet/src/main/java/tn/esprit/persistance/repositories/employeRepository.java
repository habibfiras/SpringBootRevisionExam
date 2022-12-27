package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.persistance.employe;


public interface employeRepository extends JpaRepository<employe,Integer> {
	@Query("Select count(*) from employe")
	public long NombreEmployeJPQL();
	@Query("Select nom from employe")
	public List<String> AllEmployeNamesJPQL();
}
