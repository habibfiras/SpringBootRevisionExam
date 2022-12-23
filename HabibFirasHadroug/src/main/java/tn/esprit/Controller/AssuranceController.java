package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.DAO.Entities.Assurance;
import tn.esprit.DAO.Entities.Beneficaire;
import tn.esprit.Services.interfaces.AssuranceService;
import tn.esprit.Services.interfaces.BenficaireService;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {
	@Autowired
	BenficaireService benficaireService; 
	
	


}
