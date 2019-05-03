package com.infotel.TPSpringMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TPSpringMVC.metier.Adresse;

@Transactional
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}
