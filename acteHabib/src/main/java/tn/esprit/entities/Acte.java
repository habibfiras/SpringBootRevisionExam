package tn.esprit.entities;

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
@Table(name = "Acte")
public class Acte {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idActe")
	private Long idActe;
	private String codeActe;
	private int cotationActe;
	private float prixUnitaireActe;
	private String designationActe;
	@ManyToOne
	@JsonIgnore
	FamilleActe familleActe;
	@ManyToMany(mappedBy="actes", cascade = CascadeType.ALL)
	private List<Pathologie> pathologies;
}
