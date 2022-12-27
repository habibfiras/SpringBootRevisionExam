package tn.esprit.persistance;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "Contrat")
public class contrat {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="reference")
	private int reference ;
	@Temporal(TemporalType.DATE)
	private Date dateDebut; 
	private String typeContrat;
	private int salaire;
	@OneToOne(mappedBy="contrat")
	private employe employe;

}
