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
@Table(name = "familleActe")
public class FamilleActe {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFA")
	private Long idFA;
	public String codeFA;
	public String libelle;
	public String description;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="familleActe")
	private Set<Acte> actes;
}
