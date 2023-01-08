package tn.esprit.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "pathologie")
public class Pathologie {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idPath")
	private int idPath;
	private String codePath;
	private String libelle;
	private String description;
	public boolean archive;
	@ManyToMany(cascade = CascadeType.ALL )
	private List<Acte> actes;
	

}
