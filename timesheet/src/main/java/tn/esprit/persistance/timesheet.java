package tn.esprit.persistance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "timesheet")
public class timesheet {

	@EmbeddedId
	private TimesheetPK timesheetPK;
	
	//idMission est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idMission", referencedColumnName = "idMission", insertable=false, updatable=false)
	private mission mission;
	
	//idEmploye est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idEmploye", referencedColumnName = "idEmploye", insertable=false, updatable=false)
	private employe employe;

	private boolean isValide;
	

	
	
}
