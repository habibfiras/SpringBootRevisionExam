package tn.esprit.DAO.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Assurance")
public class Assurance implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name="idAssurance")
	private int idAssurance;
	public Beneficaire getBeneficaire() {
		return Beneficaire;
	}
	public void setBeneficaire(Beneficaire beneficaire) {
		Beneficaire = beneficaire;
	}
	private String designation;
	private float montant;
	@ManyToOne
	Contrat contrat;
	@ManyToOne
	Beneficaire Beneficaire;



}
