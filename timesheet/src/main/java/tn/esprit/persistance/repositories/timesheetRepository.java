package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.timesheet;

public interface timesheetRepository extends JpaRepository<timesheet,Integer> {

}
