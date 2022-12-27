package tn.esprit.persistance;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "Mission")
public class mission {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idMission")
	private int idMission ;
	private String name;
	private String description;
	@ManyToMany(mappedBy="missions", cascade = CascadeType.ALL)
	private Set<employe> employes;
	@ManyToOne
	departement departement;
}
