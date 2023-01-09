package tn.esprit.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "cuisinier")
public class Cuisinier {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idCuisinier")
	private int idCuisinier;
	private String nom;
	private String prenom;
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Plat> plats;
}
