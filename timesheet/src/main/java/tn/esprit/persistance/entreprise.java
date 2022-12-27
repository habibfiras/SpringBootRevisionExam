package tn.esprit.persistance;

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
@Table(name = "entreprise")
public class entreprise {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEntreprise")
	private int idEntreprise;
	private String name;
	private String raisonSocial;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
	private Set<departement> departements;
	

}
