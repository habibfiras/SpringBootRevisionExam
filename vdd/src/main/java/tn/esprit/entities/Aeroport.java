package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "aeroport")
public class Aeroport {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idAeroport")
	private int idAeroport;
	private String nom;
	private String codeAITA;
	private long telephone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="aDepart")
	private Set<Vol> volsdep;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="aArrive")
	private Set<Vol> volsarr;
}
