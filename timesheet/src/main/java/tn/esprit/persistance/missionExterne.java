package tn.esprit.persistance;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "missionExterne")
public class missionExterne extends mission {
	
	private String emailFacturation;
	private float tauxJournalierMoyen;
}
