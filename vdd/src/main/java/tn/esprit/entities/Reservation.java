package tn.esprit.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "reservation")
public class Reservation {
	@Id
    @Column(length = 100)
    String idReservation;
	@Temporal(TemporalType.DATE)
	Date dateReservation;
	@Enumerated(EnumType.STRING)
	ClassPlace classPlace;
    @Enumerated(EnumType.STRING)
	EtatReservation etatReservation;
    @ManyToOne
    @JsonIgnore
    Vol vol;
    @ManyToOne
    @JsonIgnore
    Voyageur voyageur;
}
