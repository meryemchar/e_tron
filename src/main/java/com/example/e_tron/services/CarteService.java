package com.example.e_tron.services;

import java.util.List;

import com.example.e_tron.entities.Carte;
import com.example.e_tron.entities.Utilisateur;

public interface CarteService {
		
	public Carte createCarte(Utilisateur u);
	public List<Carte> getAllCarte();
	public Carte getCarteById(Integer id);
	public void deleteCarte(Carte v);
	public Carte updateCarte(Carte v);

}
