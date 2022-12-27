package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.contrat;
import tn.esprit.persistance.employe;
import tn.esprit.service.Interfaces.employeService;

@RestController
public class employeController {
	@Autowired
	employeService employeService;
	@PostMapping("/addEmploye")
	@ResponseBody
	public int ajouterEmploye(@RequestBody employe employe) {
		return employeService.ajouterEmploye(employe);
	}
	@PostMapping("/affecterEmployeADepartement/{employeId}/{depId}")
	@ResponseBody
	public void affecterEmployeADepartement(int employeId, int depId) {
		 employeService.affecterEmployeADepartement(employeId, depId);
	}
	@PostMapping("/ajouterContrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody contrat contrat) {
		return employeService.ajouterContrat(contrat);
	}
	@PostMapping("/affecterContratAEmploye/{contratId}/{employeId}")
	@ResponseBody
	public void affecterContratAEmploye(int contratId, int employeId) {
		employeService.affecterContratAEmploye(contratId, employeId);
	}
	@GetMapping("/getEmployePrenomById/{employeId}")
	public String getEmployePrenomById(@PathVariable("employeId") int employeId) {
		return employeService.getEmployePrenomById(employeId);
	}
	@GetMapping("/getNombreEmploye")
	public long getNombreEmployeJPQL() {
		return employeService.getNombreEmployeJPQL();
	}
	@GetMapping("/getAllEmployeNamesJPQL")
	public List<String> getAllEmployeNamesJPQL() {
		return employeService.getAllEmployeNamesJPQL();
	}

}
