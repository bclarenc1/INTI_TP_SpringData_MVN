package com.infotel.TPSpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.TPSpringMVC.metier.Adresse;
import com.infotel.TPSpringMVC.service.Iservice;

@Controller
public class AdresseController {

	@Autowired
	private Iservice service;
	
	@RequestMapping(value="/indexAdresse", method=RequestMethod.GET)
	public String display(Model model) {
		model.addAttribute("adresse", new Adresse());
		model.addAttribute("adresses", service.findAllAddresses());
		return "adresses";
	}
//	
	@RequestMapping(value="/saveAdresse")
	public String save(Adresse adresse, Model model) {
		if (adresse.getIdAdresse() == 0) {
			service.ajouterAdresse(adresse);
			model.addAttribute("adresse", new Adresse());
			model.addAttribute("adresses", service.findAllAddresses());
			return "adresses";
		} else {  // 2 actions possibles pour le meme bouton
			service.modifierAdresse(adresse);
			model.addAttribute("adresse", new Adresse());
			model.addAttribute("adresses", service.findAllAddresses());
			return "adresses";
		}
	}

	@RequestMapping(value="/deleteAdresse")
	public String delete(@RequestParam int id, Model model) {
			service.supprimerAdresse(id);
			model.addAttribute("adresse", new Adresse());
			model.addAttribute("adresses", service.findAllAddresses());
			return "adresses";
    }
	
	@RequestMapping(value="/editAdresse")  // sert juste a remplir les champs du formulaire
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("adresse", service.getAdresse(id));
        model.addAttribute("adresses", service.findAllAddresses());
        return "adresses";
    }

}
