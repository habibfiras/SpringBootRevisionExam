package tn.esprit.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "voyageur")
public class Voyageur {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idVoyageur")
	private int idVoyageur;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	Date dateNaissance;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="voyageur")
	private Set<Reservation> reservations;
}
