package tn.esprit.service.classes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.TimesheetPK;
import tn.esprit.persistance.departement;
import tn.esprit.persistance.mission;
import tn.esprit.persistance.timesheet;
import tn.esprit.persistance.repositories.departementRepository;
import tn.esprit.persistance.repositories.missionRepository;
import tn.esprit.persistance.repositories.timesheetRepository;
import tn.esprit.service.Interfaces.timesheetService;


@Service
public class timesheetServiceImplementation implements timesheetService {
	@Autowired
	timesheetRepository timesheetRepository;
	@Autowired
	missionRepository missionRepository;
	@Autowired
	departementRepository departementRepository;
	@Override
	public int ajouterMission(mission mission) {
		return missionRepository.save(mission).getIdMission();
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		mission mi = missionRepository.findById(missionId).get();
		departement dep = departementRepository.findById(depId).get();
		mi.setDepartement(dep);
		missionRepository.save(mi);
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		timesheet timesheet = new timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}

}
