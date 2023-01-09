package tn.esprit.entities;

import java.util.List;
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
import javax.persistence.ManyToOne;
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
@Table(name = "plat")
public class Plat {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idPlat")
	private int idPlat;
	private String label;
	private float prix;
	private float calories;
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	@ManyToOne
	Client client;
	@ManyToMany(mappedBy="plats", cascade = CascadeType.ALL)
	private List<Cuisinier> cuisiniers;

}
