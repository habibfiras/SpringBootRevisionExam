package tn.esprit.persistance;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "departement")
public class departement {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDepartement")
	private int idDepartement;
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<employe> employes;
	@ManyToOne
	@JsonIgnore
	entreprise entreprise;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
	private Set<mission> missions;
}
