package tn.esprit.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "evenement")
public class Evenement {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEvenement")
	private int idEvenement;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private float cout;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Participant> participants;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Logistique> logistiques;
	

	
}
