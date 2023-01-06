package tn.esprit.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Vol;

@Repository
public interface VolRepo extends JpaRepository<Vol,Integer>{
	List<Vol> findByDateDepart(Date d);
}
