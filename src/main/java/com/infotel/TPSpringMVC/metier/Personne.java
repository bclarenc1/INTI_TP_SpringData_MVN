package com.infotel.TPSpringMVC.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity		// JPA
@Component  // SpringData
@Scope(value="prototype") // SpringData
public class Personne {

	@Id  // JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // JPA
	private int id;
	private String nom;
	private String prenom;
	private int age;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Personne [id=" + id + "\t, prenom=" + prenom + "\t, nom=" + nom + "\t, age=" + age + "\t]";
	}
	
	
}
