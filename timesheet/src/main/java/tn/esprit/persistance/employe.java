package tn.esprit.persistance;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
@Table(name = "employe")
public class employe {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEmploye")
	private int idEmploye;
	private String prenom;
	private String nom;
	private String email;
	private int isActif;
	@Enumerated(EnumType.STRING)
	private role type;
	@OneToOne
	private contrat contrat;
	@ManyToMany(mappedBy="employes", cascade = CascadeType.ALL)
	private Set<departement> departements;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<mission> missions;
	
	

}
