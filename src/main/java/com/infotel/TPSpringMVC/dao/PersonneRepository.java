package com.infotel.TPSpringMVC.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TPSpringMVC.metier.Personne;

@Transactional
public interface PersonneRepository extends JpaRepository<Personne,Integer> {
	public List<Personne> findByPrenom(String pr);
	
	@Query("SELECT p from Personne p where p.nom LIKE :x")
	public List<Personne> rechercherParMC(@Param("x") String mc);

	@Query("SELECT p from Personne p where p.nom LIKE :x and p.prenom LIKE :y")
	public List<Personne> rechercherParMC2(@Param("x") String nom, @Param("y") String prenom);
	
	@Modifying
	@Query("UPDATE Personne set prenom=:prenom, nom=:nom, age=:age where id=:id")
	public void modifierPersonne(@Param("id") int id, @Param("prenom") String prenom, @Param("nom") String nom, @Param("age") int age);
	
}
