package tn.esprit.DAO.Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Beneficaire")

public class Beneficaire implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name="idBenef")
	private int idBenef ;
	private int cin;
	private String nom;
	private String prenom;
	private String profession;
	private float salaire;
	@JsonIgnore
	   @OneToMany(mappedBy = "Beneficaire" , fetch=FetchType.EAGER)
	    private List<Assurance> Assurance ;
	public int getIdBenef() {
		return idBenef;
	}
 

}
