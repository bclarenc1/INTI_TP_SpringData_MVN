package com.infotel.TPSpringMVC.service;

import com.infotel.TPSpringMVC.metier.Adresse;
import com.infotel.TPSpringMVC.metier.Personne;

public interface Iservice {

	public Personne ajouterPersonne(Personne p);
	public void supprimerPersonne(int id);
	public Personne getPersonne(int id);
	public Personne modifierPersonne(Personne p);
	public Iterable<Personne> findAllPeople();
	
//	public Adresse ajouterAdresse(Adresse a);
//	public void supprimerAdresse(int id);
//	public Adresse getAdresse(int id);
//	public Adresse modifierAdresse(Adresse a);
//	public Iterable<Adresse> findAllAddresses();

	
	public void ajouterAdresse(Adresse a);
	public void supprimerAdresse(int id);
	public Adresse getAdresse(int id);
	public void modifierAdresse(Adresse a);
	public Iterable<Adresse> findAllAddresses();
	
}
