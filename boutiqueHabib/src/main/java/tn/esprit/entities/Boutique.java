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
@Table(name = "Boutique")
public class Boutique {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idBoutique")
	private Long idBoutique;
	private String nomBoutique;
	@Enumerated(EnumType.STRING)
	private Categories categories;
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	List<Client> clients;
	@ManyToOne
	@JsonIgnore
	CentreCommercial centreCommercial;
}
