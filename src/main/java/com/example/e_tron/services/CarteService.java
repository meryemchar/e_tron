package com.example.e_tron.services;

import java.util.List;

import com.example.e_tron.entities.Carte;

public interface CarteService {
		
	public Carte createCarte(Carte v);
	public List<Carte> getAllCarte();
	public Carte getCarteById(Integer id);
	public void deleteCarte(Carte v);
	public Carte updateCarte(Carte v);

}
