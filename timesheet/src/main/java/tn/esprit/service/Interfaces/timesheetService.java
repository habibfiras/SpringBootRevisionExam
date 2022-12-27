package tn.esprit.service.Interfaces;

import java.util.Date;

import tn.esprit.persistance.mission;

public interface timesheetService {
	public int ajouterMission(mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public void ajouterTimesheet(int missionId, int employeId, Date
	dateDebut, Date dateFin);
}
