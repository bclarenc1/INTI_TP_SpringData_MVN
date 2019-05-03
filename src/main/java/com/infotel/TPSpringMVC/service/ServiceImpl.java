package com.infotel.TPSpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.TPSpringMVC.dao.AdresseRepository;
import com.infotel.TPSpringMVC.dao.PersonneRepository;
import com.infotel.TPSpringMVC.metier.Adresse;
import com.infotel.TPSpringMVC.metier.Personne;

@Service
public class ServiceImpl implements Iservice {

	@Autowired
	PersonneRepository personneRepository;
	@Autowired
	AdresseRepository adresseRepository;
	
	public Personne ajouterPersonne(Personne p) {
		return personneRepository.save(p);
	}
	public void supprimerPersonne(int id) {
		personneRepository.deleteById(id);
	}
	public Personne modifierPersonne(Personne p) {
		return personneRepository.save(p);
	}
	public Personne getPersonne(int id) {
		return personneRepository.findById(id).get();
	}
	public Iterable<Personne> findAllPeople() {
		return personneRepository.findAll();
	}
	
	
	public void ajouterAdresse(Adresse a) {
		adresseRepository.save(a);
	}
	public void supprimerAdresse(int id) {
		adresseRepository.deleteById(id);
	}
	public Adresse getAdresse(int id) {
		return adresseRepository.findById(id).get();
	}
	public void modifierAdresse(Adresse a) {
		adresseRepository.save(a);
	}
	public Iterable<Adresse> findAllAddresses() {
		return adresseRepository.findAll();
	}


}
