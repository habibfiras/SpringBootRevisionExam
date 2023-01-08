package tn.esprit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "logistique")
public class Logistique {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idLog")
	private int idLog;
	private String description;
	private boolean reserve;
	private float prixUnit;
	private int quantite;
}
