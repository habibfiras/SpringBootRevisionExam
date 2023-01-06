package tn.esprit.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.ClassPlace;
import tn.esprit.entities.EtatReservation;
import tn.esprit.entities.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, String> {
	@Query("Select v from Reservation v where v.vol.idVol = :id and v.classPlace = :cl and  v.etatReservation = :et")
    List<Reservation> find(@Param("id")int idVol,@Param("cl") ClassPlace classPlace,@Param("et") EtatReservation etatReservation);
	@Query(value="SELECT * FROM reservation v JOIN vol vo WHERE vo.id_vol = v.vol_id_vol and vo.id_vol= ?1 and v.class_place = ?2 and v.etat_reservation = ?3",nativeQuery=true)
    List<Reservation> findnative(int idVol,String classPlace,String etatReservation);

}
