package com.example.e_tron.services;

import java.util.List;

import com.example.e_tron.entities.Voiture;

public interface VoitureService {
	
	public Voiture createVoiture(Voiture v);
	public List<Voiture> getAllVoiture();
	public Voiture getVoitureById(Integer id);
	public void deleteVoiture(Integer id);
	public Voiture updateVoiture(Voiture v);

}
