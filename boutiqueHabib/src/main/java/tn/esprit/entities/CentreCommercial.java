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
@Table(name = "centreCommercial")
public class CentreCommercial {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idCentreCommercial")
	private Long idCentreCommercial;
	private String nomCentreCommercial;
	private String adresse;
	private String login;
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="centreCommercial")
	private Set<Boutique> boutiques
	;
}
