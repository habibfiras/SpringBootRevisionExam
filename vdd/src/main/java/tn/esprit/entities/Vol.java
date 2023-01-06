package tn.esprit.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "vol")
public class Vol {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idVol")
	private int idVol;
	@Temporal(TemporalType.DATE)
	Date dateDepart;
	@Temporal(TemporalType.DATE)
	Date dateArrive;
	@ManyToOne(cascade = CascadeType.ALL)
	Aeroport aDepart;
	@ManyToOne(cascade = CascadeType.ALL)
	Aeroport aArrive;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="vol")
	private Set<Reservation> reservations;
}
