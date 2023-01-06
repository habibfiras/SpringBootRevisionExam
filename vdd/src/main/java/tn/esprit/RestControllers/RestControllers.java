package tn.esprit.RestControllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Services.lServices;
import tn.esprit.entities.ClassPlace;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.Vol;
import tn.esprit.entities.Voyageur;

@RestController
@RequestMapping("restControllers")
public class RestControllers {
	  @Autowired
	     lServices lServices;

	    @PostMapping("ajouterVolEtAeroport")
		@ResponseBody
	    public String ajouterVolEtAeroport(@RequestBody Vol v) {
	        return lServices.ajouterVolEtAeroprt(v);
	    }
	    @PostMapping("ajouterVoyageurs")
		@ResponseBody
		public List<Voyageur> ajouterVoyageurs(@RequestBody List<Voyageur> voyageurs) {
	    	return lServices.ajouterVoyageurs(voyageurs);
	    }
	    @PostMapping("reserverVol")
	    public String reserverVol(@RequestParam int voyageurId, @RequestParam int volId, @RequestParam ClassPlace classPlace) {
	        return lServices.reserverVol(voyageurId, volId, classPlace);
	    }
	    @PostMapping("confirmerReservation")
		public Reservation confirmerReservation(@RequestParam String resId) {
	    	return lServices.confirmerReservation(resId);
	    }
	    @GetMapping("getVoyageurByVol")
		@ResponseBody
		public Map<Integer, List<Voyageur>> getVoyageurByVol() {
	    	return lServices.getVoyageurByVol();
	    }
}
