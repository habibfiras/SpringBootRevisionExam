package tn.esprit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Services.LServices;
import tn.esprit.entities.Evenement;
import tn.esprit.entities.Logistique;
import tn.esprit.entities.Participant;

@RestController
@RequestMapping("restControllers")
public class Controller {
	@Autowired
	LServices lServices;
	 @PostMapping("/ajouterPArticipant")
	 @ResponseBody
	public Participant ajouterPArticipant(@RequestBody Participant p) {
		 return lServices.ajouterPArticipant(p);
	}
	 @PostMapping("/ajouterAffectEvenParticip")
	 @ResponseBody
	public Evenement ajouterAffectEvenParticip(@RequestBody Evenement e) {
		return lServices.ajouterAffectEvenParticip(e);
	}
	 @PostMapping("/ajoutAffectLogEvnm")
	 @ResponseBody
	public Logistique ajoutAffectLogEvnm(@RequestBody Logistique l,@RequestParam String descriptionEvnmt) {
		 return lServices.ajoutAffectLogEvnm(l, descriptionEvnmt);
	 }
	 @GetMapping("/getLogistiqyeDates")
	 @ResponseBody
		public List<Logistique> getLogistiqyeDates(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dateDeb,@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dateFin) {
		 return lServices.getLogistiqyeDates(dateDeb, dateFin);
	 }
	 @GetMapping("/getParReservLogis")
		public List<Participant> getParReservLogis() {
		 return lServices.getParReservLogis();
	 }
	 @GetMapping("/rrs")
	 public void test() {
		  lServices.calculCout();
	 }
}
