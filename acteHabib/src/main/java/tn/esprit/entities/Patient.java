package tn.esprit.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idPatient")
	private Long idPatient;
    @Enumerated(EnumType.STRING)
    private TypePieceIdentite typePieceIdentite;
    private String identifiantPieceIdentite;
	@Temporal(TemporalType.DATE)
	private Date dateEmission;
	private String nomP;
	private String prenomP;
	@ManyToMany(cascade = CascadeType.ALL )
	@JsonIgnore
	private List<Pathologie> pathologies;
    }
