package com.infotel.TPSpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.TPSpringMVC.metier.Personne;
import com.infotel.TPSpringMVC.service.Iservice;

@Controller
public class PersonneController {

	@Autowired
	private Iservice service;

	@RequestMapping(value="/indexPersonne", method=RequestMethod.GET)
	public String display(Model model) {
		model.addAttribute("personne", new Personne());
		model.addAttribute("personnes", service.findAllPeople());
		return "personnes";
	}

	@RequestMapping(value="/savePersonne")
	public String save(Personne personne, Model model) {
		if (personne.getId() == 0) {
			service.ajouterPersonne(personne);
			model.addAttribute("personne", new Personne());
			model.addAttribute("personnes", service.findAllPeople());
			return "personnes";
		} else {  // 2 actions possibles pour le meme bouton
			service.modifierPersonne(personne);
			model.addAttribute("personne", new Personne());
			model.addAttribute("personnes", service.findAllPeople());
			return "personnes";
		}
	}

	@RequestMapping(value="/deletePersonne")
	public String delete(@RequestParam int id, Model model) {
			service.supprimerPersonne(id);
			model.addAttribute("personne", new Personne());
			model.addAttribute("personnes", service.findAllPeople());
			return "personnes";
    }
	
	@RequestMapping(value="/editPersonne")  // sert juste a remplir les champs du formulaire
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("personne", service.getPersonne(id));
        model.addAttribute("personnes", service.findAllPeople());
        return "personnes";
    }
}
