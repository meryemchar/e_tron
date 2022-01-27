package com.example.e_tron.services;

import java.util.List;

import com.example.e_tron.entities.Abonnement;


public interface AbonnementService {
	
	public Abonnement createAbonnement(Abonnement v);
	public List<Abonnement> getAllAbonnement();
	public Abonnement getAbonnementById(Integer id);
	public void deleteAbonnement(Integer id);
	public Abonnement updateAbonnement(Abonnement v);
	public Abonnement getbyType(String type);
	

}
